from fpdf import FPDF

class PDF(FPDF):
    def header(self):
        self.set_font("Arial", "B", 14)
        self.cell(0, 10, "AI Learning Roadmap (2025 Edition)", ln=True, align="C")
        self.ln(5)

    def chapter_title(self, title):
        self.set_font("Arial", "B", 12)
        self.set_fill_color(230, 230, 230)
        self.cell(0, 10, title, ln=True, fill=True)
        self.ln(2)

    def chapter_body(self, body):
        self.set_font("Arial", "", 10)
        self.multi_cell(0, 8, body)
        self.ln()

pdf = PDF()
pdf.set_auto_page_break(auto=True, margin=15)
pdf.add_page()

roadmap_sections = [
    ("Stage 1: Prerequisites (Foundations)", 
     "• Python Programming: Learn syntax, OOP, data structures, and file handling.\n"
     "• Math for AI: Linear Algebra, Calculus, and Probability & Statistics.\n"
     "• Data Structures & Algorithms: Learn arrays, trees, graphs, and Big-O."),

    ("Stage 2: Core Machine Learning", 
     "• ML Concepts: Supervised/Unsupervised learning, overfitting, etc.\n"
     "• ML Algorithms: Linear/Logistic Regression, SVM, KNN, Decision Trees.\n"
     "• Tools: scikit-learn, pandas, seaborn.\n• Projects: Titanic survival, spam classifier."),

    ("Stage 3: Deep Learning", 
     "• Neural Networks: Perceptron, ReLU, Backpropagation.\n"
     "• Advanced Topics: CNNs, RNNs, LSTMs, Transfer Learning.\n"
     "• Tools: TensorFlow, PyTorch.\n• Projects: Digit recognition, text sentiment analyzer."),

    ("Stage 4: Specialized AI Domains", 
     "• NLP: Tokenization, Transformers, BERT, GPT.\n"
     "• Computer Vision: Object detection (YOLO), segmentation (U-Net).\n"
     "• Reinforcement Learning: Q-learning, DQN, policy gradients.\n"
     "• Tools: Hugging Face, OpenCV, spaCy."),

    ("Stage 5: Advanced Topics + Research", 
     "• LLMs: GPT, fine-tuning, prompt engineering, RAG.\n"
     "• AI Ethics: Fairness, bias, explainability.\n"
     "• Read Papers: Use arXiv, Papers with Code, Google Scholar."),

    ("Stage 6: Projects + Portfolio", 
     "• Build Projects: Real-world applications, Kaggle competitions.\n"
     "• Portfolio: GitHub repos, write-ups on Medium.\n"
     "• Open Source: Contribute to AI libraries and tools."),

    ("Stage 7: Career & Continuous Learning", 
     "• MLOps: Learn Docker, FastAPI, MLflow, GCP/AWS.\n"
     "• Roles: ML Engineer, Data Scientist, NLP Engineer.\n"
     "• Continuous Learning: Follow AI communities and new research.")
]

for title, body in roadmap_sections:
    pdf.chapter_title(title)
    pdf.chapter_body(body)

pdf.output("AI_Learning_Roadmap_2025.pdf")
