import pathlib


def parse(puzzle_input):
    """Parse input."""


def part1(data):
    """Solve part 1."""
    return "part1"


def part2(data):
    """Solve part 2."""
    return "part2"


if __name__ == "__main__":
    puzzle_input = pathlib.Path("./input.txt").read_text().strip()
    data = parse(puzzle_input)

    print(f"Part 1: {part1(data)}")
    print(f"Part 2: {part2(data)}")
