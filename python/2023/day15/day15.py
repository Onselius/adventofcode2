import pathlib
from collections import defaultdict


def parse(puzzle_input: str) -> list[str]:
    """Parse input."""
    return puzzle_input.replace("\n", "").split(",")


def part1(data: list[str]):
    """Solve part 1."""
    sum = 0
    for line in data:
        current = 0
        for c in line:
            current = apply(current + ord(c))
        sum += current
    return sum


def apply(value: int):
    return (value * 17) % 256


def part2(data: list[str]):
    """Solve part 2."""
    boxes = defaultdict(dict)
    for line in data:
        current = 0
        for i, c in enumerate(line):
            if c in "-=":
                break
            current = apply(current + ord(c))
        label = line[:i]
        box = boxes[current]
        if c == "-":
            box.pop(label, "")
        else:
            focal = line[-1]
            box[label] = focal

    answer = 0
    for box, v in boxes.items():
        for i, value in enumerate(v.values()):
            power = (box + 1) * (i + 1) * int(value)
            answer += power

    return answer


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    puzzle_input = (puzzle_dir / "input.txt").read_text().strip()
    data = parse(puzzle_input)

    print(f"Part 1: {part1(data)}")
    print(f"Part 2: {part2(data)}")
