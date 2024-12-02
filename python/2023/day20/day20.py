import pathlib
from math import lcm
from copy import deepcopy
from collections import deque


def parse(puzzle_input) -> list[str]:
    """Parse input."""
    return puzzle_input.split("\n")


# name: type, targets:list, memory:list
def part1(data: list[str]):
    """Solve part 1."""
    modules = {}
    for line in data:
        name, targets = line.split(" -> ")
        type = name[:1]
        name = name[1:]
        targets = targets.split(", ")
        if type == "b":
            type = "&"
        if type == "%":
            memory = 0
        else:
            memory = dict()
        modules[name] = [type, targets, memory]

    for k, v in modules.items():
        for target in v[1]:
            if target not in modules:
                continue
            m = modules[target]
            if m[0] == "&":
                m[2][k] = 0

    # name: type, targets:list, memory:list
    # rx is end for input
    low = 0
    high = 0
    for i in range(1000):
        low += 1
        modules["roadcaster"][2]["start"] = 0
        queue = deque()
        queue.append(("roadcaster", 1, "start"))
        while queue:
            name, received, sender = queue.popleft()
            if name not in modules:
                continue
            module = modules[name]
            if module[0] == "%":
                if received:
                    continue
                module[2] = (module[2] + 1) % 2
                signal = module[2]

            else:
                module[2][sender] = received
                if all(s == 1 for s in module[2].values()):
                    signal = 0
                else:
                    signal = 1

            for t in module[1]:
                if signal:
                    high += 1
                else:
                    low += 1
                queue.append((t, signal, name))
            # print(module)

    return low * high


def part2(data: list[str]):
    """Solve part 2."""
    og_modules = {}
    for line in data:
        name, targets = line.split(" -> ")
        type = name[:1]
        name = name[1:]
        targets = targets.split(", ")
        if type == "b":
            type = "&"
        if type == "%":
            memory = 0
        else:
            memory = dict()
        og_modules[name] = [type, targets, memory]

    for k, v in og_modules.items():
        for target in v[1]:
            if target not in og_modules:
                continue
            m = og_modules[target]
            if m[0] == "&":
                m[2][k] = 0

    # name: type, targets:list, memory:list
    # rx is end for input

    starts = og_modules["roadcaster"][1]
    total_press = 1
    for start in starts:
        modules = deepcopy(og_modules)
        modules["roadcaster"][1] = [start]

        total_press = lcm(press_button(modules), total_press)

    return total_press


def press_button(modules):
    presses = 0
    while True:
        presses += 1
        modules["roadcaster"][2]["start"] = 0
        queue = deque()
        queue.append(("roadcaster", 1, "start"))
        while queue:
            name, received, sender = queue.popleft()
            if name == "jq" and received == 1:
                return presses
            if name not in modules:
                if received == 0:
                    return presses
                continue
            module = modules[name]
            if module[0] == "%":
                if received:
                    continue
                module[2] = (module[2] + 1) % 2
                signal = module[2]

            else:
                module[2][sender] = received
                if all(s == 1 for s in module[2].values()):
                    signal = 0
                else:
                    signal = 1

            for t in module[1]:
                queue.append((t, signal, name))


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    puzzle_input = (puzzle_dir / "input.txt").read_text().strip()
    data = parse(puzzle_input)

    print(f"Part 1: {part1(data)}")
    print(f"Part 2: {part2(data)}")
