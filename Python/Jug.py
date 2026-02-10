from collections import deque

def solve_water_jug(jug1_capacity, jug2_capacity, target):
    
    visited = set()
    parent = dict()
    action = dict()

    queue = deque()
    start_state = (0, 0)
    queue.append(start_state)
    visited.add(start_state)
    parent[start_state] = None
    action[start_state] = "Start"

    while queue:
        current = queue.popleft()
        jug1, jug2 = current

        if jug1 == target or jug2 == target:
            return reconstruct_path(current, parent, action)

        next_states = []

        next_states.append(((jug1_capacity, jug2), "Fill Jug1 to {}L".format(jug1_capacity)))

        next_states.append(((jug1, jug2_capacity), "Fill Jug2 to {}L".format(jug2_capacity)))

        next_states.append(((0, jug2), "Empty Jug1"))

        next_states.append(((jug1, 0), "Empty Jug2"))

        pour = min(jug1, jug2_capacity - jug2)
        new_state = (jug1 - pour, jug2 + pour)
        next_states.append((new_state, f"Pour {pour}L from Jug1 to Jug2"))

        pour = min(jug2, jug1_capacity - jug1)
        new_state = (jug1 + pour, jug2 - pour)
        next_states.append((new_state, f"Pour {pour}L from Jug2 to Jug1"))

        for state, act in next_states:
            if state not in visited:
                visited.add(state)
                parent[state] = current
                action[state] = act
                queue.append(state)

    return None  


def reconstruct_path(state, parent, action):
    path = []
    while state is not None:
        path.append((action[state], state))
        state = parent[state]
    path.reverse()
    return path


def print_solution(jug1_capacity, jug2_capacity, target):
    print(f"Capacities: Jug1={jug1_capacity}L, Jug2={jug2_capacity}L | Target: {target}L\n")
    path = solve_water_jug(jug1_capacity, jug2_capacity, target)

    if not path:
        print("No solution found.")
        return

    for i, (act, (j1, j2)) in enumerate(path):
        print(f"{i:02d}. {act:<35} ->  State: (Jug1={j1}L, Jug2={j2}L)")
    
    print("\nReached target!")

print_solution(4, 3, 2)
