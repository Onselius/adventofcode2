import pathlib
import re


def parse(puzzle_input) -> list[str]:
    """Parse input."""
    return puzzle_input.split("\n")


def part1(data: list[str]):
    """Solve part 1."""
    tokens = 0
    button_search = r"X\+(\d+), Y\+(\d+)"
    prize_search = r"X\=(\d+), Y\=(\d+)"
    a = ()
    b = ()
    prize = ()
    for line in data:
        if line == "":
            continue
        elif line.startswith("Button A"):
            match = re.search(button_search, line)
            a = (int(match.group(1)), int(match.group(2)))
        elif line.startswith("Button B"):
            match = re.search(button_search, line)
            b = (int(match.group(1)), int(match.group(2)))
        else:
            match = re.search(prize_search, line)
            prize = (int(match.group(1)), int(match.group(2)))
            tokens += calculate_tokens2(a, b, prize)
            a = ()
            b = ()
            prize = ()

    return tokens


def part2(data: list[str]):
    """Solve part 2."""
    tokens = 0
    button_search = r"X\+(\d+), Y\+(\d+)"
    prize_search = r"X\=(\d+), Y\=(\d+)"
    a = ()
    b = ()
    prize = ()
    for line in data:
        if line == "":
            continue
        elif line.startswith("Button A"):
            match = re.search(button_search, line)
            a = (int(match.group(1)), int(match.group(2)))
        elif line.startswith("Button B"):
            match = re.search(button_search, line)
            b = (int(match.group(1)), int(match.group(2)))
        else:
            match = re.search(prize_search, line)
            prize = (int(match.group(1)), int(match.group(2)))
            prize = (prize[0] + 10000000000000, prize[1] + 10000000000000)
            tokens += calculate_tokens2(a, b, prize)
            a = ()
            b = ()
            prize = ()

    return tokens


def calculate_tokens(a: tuple, b: tuple, prize: tuple):
    a_first = 0
    for i in range(101):
        x = prize[0] - (a[0] * i)
        y = prize[1] - (a[1] * i)
        if x / b[0] == y / b[1]:
            a_first += i * 3 + x / b[0]
            break

    b_first = 0
    for i in range(101):
        x = prize[0] - (b[0] * i)
        y = prize[1] - (b[1] * i)
        if x / a[0] == y / a[1]:
            b_first += i + x / a[0] * 3
            break

    if a_first < b_first:
        return int(a_first)
    return int(b_first)


def calculate_tokens2(a: tuple, b: tuple, prize: tuple):
    new_a = (a[0] * a[1], a[1] * a[0])
    new_b = (b[0] * a[1], b[1] * a[0])
    new_prize = (prize[0] * a[1], prize[1] * a[0])
    target = new_prize[1] - new_prize[0]
    steps = new_b[1] - new_b[0]
    if target % steps != 0:
        return 0
    answer_b = int(target / steps)
    if (prize[0] - b[0] * answer_b) % a[0] == 0:
        answer_a = (prize[0] - b[0] * answer_b) / a[0]
        return int(answer_a * 3 + answer_b)
    return 0


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    puzzle_input = (puzzle_dir / "input.txt").read_text().strip()
    data = parse(puzzle_input)

    print(f"Part 1: {part1(data)}")
    print(f"Part 2: {part2(data)}")
