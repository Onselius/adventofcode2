import pathlib


def parse(puzzle_input) -> list[str]:
    """Parse input."""
    return puzzle_input.split("\n")


def part1(data: list[str]):
    """Solve part 1."""
    answer = 0
    for line in data:
        numbers = []
        for c in line:
            if c.isdigit():
                numbers.append(c)
        answer += int(numbers[0] + numbers[-1])
    return answer


def part2(data: list[str]):
    """Solve part 2."""
    literals = ["one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
    answer = 0
    for line in data:
        numbers = []
        for i, c in enumerate(line):
            if c.isdigit():
                numbers.append(c)
            for j, literal in enumerate(literals):
                if line[i:].startswith(literal):
                    numbers.append(str(j + 1))
        answer += int(numbers[0] + numbers[-1])
    return answer


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    puzzle_input = (puzzle_dir / "input.txt").read_text().strip()
    data = parse(puzzle_input)

    print(f"Part 1: {part1(data)}")
    print(f"Part 2: {part2(data)}")
