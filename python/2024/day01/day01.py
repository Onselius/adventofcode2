import pathlib


def parse(puzzle_input) -> list[str]:
    """Parse input."""
    first = []
    second = []
    for line in puzzle_input.split("\n"):
        x, y = line.split()
        first.append(int(x))
        second.append(int(y))

    return first, second


def part1(first: list[str], second: list[str]):
    """Solve part 1."""
    first.sort()
    second.sort()
    answer = 0
    for i in range(len(first)):
        answer += abs(first[i] - second[i])
    return answer


def part2(first: list[int], second: list[int]):
    """Solve part 2."""
    answer = 0
    for x in first:
        answer += x * second.count(x)

    return answer


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    puzzle_input = (puzzle_dir / "input.txt").read_text().strip()
    first, second = parse(puzzle_input)

    print(f"Part 1: {part1(first, second)}")
    print(f"Part 2: {part2(first, second)}")
