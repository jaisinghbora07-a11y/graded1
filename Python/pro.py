import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import accuracy_score, classification_report
import nltk
from nltk.corpus import stopwords
import re
import tkinter as tk
from tkinter import messagebox

# Download stopwords if not already done
# nltk.download('stopwords')

# Load and preprocess datasets (same as before)
fake_df = pd.read_csv('D:\Fake.csv')
true_df = pd.read_csv('D:\True.csv')
fake_df['label'] = 1
true_df['label'] = 0
df = pd.concat([fake_df, true_df], ignore_index=True)

stop_words = set(stopwords.words('english'))

def preprocess_text(text):
    text = re.sub(r'[^a-zA-Z\s]', '', text)
    text = text.lower()
    words = text.split()
    words = [word for word in words if word not in stop_words]
    return ' '.join(words)

df['processed_text'] = df['text'].apply(preprocess_text)

# Split and vectorize
X = df['processed_text']
y = df['label']
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)
vectorizer = TfidfVectorizer(max_features=5000)
X_train_tfidf = vectorizer.fit_transform(X_train)
X_test_tfidf = vectorizer.transform(X_test)

# Train model
model = LogisticRegression()
model.fit(X_train_tfidf, y_train)

# Evaluate and print accuracy (shown in console on startup)
y_pred = model.predict(X_test_tfidf)
print("Model Accuracy:", accuracy_score(y_test, y_pred))
print("Classification Report:\n", classification_report(y_test, y_pred))

# Prediction function
def predict_news(news_text):
    if not news_text.strip():
        return "Error: Please enter some news text."
    processed = preprocess_text(news_text)
    vectorized = vectorizer.transform([processed])
    prediction = model.predict(vectorized)[0]
    return "Fake" if prediction == 1 else "Real"

# GUI Setup
root = tk.Tk()
root.title("Fake News Detector")
root.geometry("500x400")

# Title Label
title_label = tk.Label(root, text="Fake News Detector", font=("Arial", 16, "bold"))
title_label.pack(pady=10)

# Input Label and Text Box
input_label = tk.Label(root, text="Paste your news article text here:")
input_label.pack()
text_box = tk.Text(root, height=10, width=50)
text_box.pack(pady=5)

# Prediction Label (initially empty)
result_label = tk.Label(root, text="", font=("Arial", 14))
result_label.pack(pady=10)

# Check Button Function
def check_news():
    news_text = text_box.get("1.0", tk.END).strip()
    prediction = predict_news(news_text)
    if prediction == "Fake":
        result_label.config(text=f"Prediction: {prediction}", fg="red")
    elif prediction == "Real":
        result_label.config(text=f"Prediction: {prediction}", fg="green")
    else:
        result_label.config(text=prediction, fg="black")
        messagebox.showerror("Error", prediction)

# Button
check_button = tk.Button(root, text="Check News", command=check_news, font=("Arial", 12))
check_button.pack(pady=10)

# Run the GUI
root.mainloop()
