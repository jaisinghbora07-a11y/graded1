from collections import deque

def display(state):
    for i in range(0, 9, 3):
        print(state[i], state[i+1], state[i+2])
    print()

def moves(state):
    pos = state.index(0)   
    possible = []
    
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]  
    row, col = divmod(pos, 3)
    
    for dr, dc in directions:
        r, c = row + dr, col + dc
        if 0 <= r < 3 and 0 <= c < 3:
            new_pos = r * 3 + c
            new_state = state[:]
            new_state[pos], new_state[new_pos] = new_state[new_pos], new_state[pos]
            possible.append(new_state)
    return possible

def bfs(start, goal):
    queue = deque([start])
    visited = set()
    step = 0
    
    while queue:
        state = queue.popleft()
        if tuple(state) in visited:
            continue
        visited.add(tuple(state))
        
        print("Step", step)
        display(state)
        step += 1
        
        if state == goal:
            print("Goal reached!")
            return
        
        for next_state in moves(state):
            queue.append(next_state)

start = [1, 2, 3,
         4, 0, 5,
         6, 7, 8]

goal = [1, 2, 3,
        4, 5, 0,
        6, 7, 8]

bfs(start, goal)
