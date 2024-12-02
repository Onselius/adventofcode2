import pathlib


def parse(puzzle_input):
    """Parse input."""
    grid: dict[int, list] = dict()
    blocks = []

    for r, row in enumerate(puzzle_input.splitlines()):
        start, end = row.split("~")
        print(start + " " + end)
        rs, cs, hs = [int(s) for s in start.split(",")]
        re, ce, he = [int(s) for s in end.split(",")]
        blocks.append()

    return grid


def part1(grid: dict[int, list]):
    """Solve part 1."""
    settle(grid)

    return "part1"


def settle(grid: dict[int, list]):
    maxH = max([h for h in grid.keys()])

    for h in range(2, maxH + 1):
        pass
    pass


def part2(data: list[str]):
    """Solve part 2."""
    return "part2"


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    puzzle_input = (puzzle_dir / "input.txt").read_text().strip()
    grid = parse(puzzle_input)

    print(f"Part 1: {part1(grid)}")
    print(f"Part 2: {part2(grid)}")
