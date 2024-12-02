import pathlib


def parse(puzzle_input) -> list[str]:
    """Parse input."""
    return [[int(x) for x in line.split()] for line in puzzle_input.split("\n")]


def part1(data: list[str]):
    """Solve part 1."""
    answer = 0
    for line in data:
        if check_dec(line) or check_inc(line):
            answer += 1

    return answer


def check_dec(levels: list[int]):
    for i in range(len(levels) - 1):
        if 0 < levels[i] - levels[i + 1] < 4:
            continue
        return False
    print("decreasing")
    return True


def check_inc(levels: list[int]):
    for i in range(len(levels) - 1):
        if 0 < levels[i + 1] - levels[i] < 4:
            continue
        return False
    print("increasing")
    return True


def part2(data: list[str]):
    """Solve part 2."""
    answer = 0
    for levels in data:
        if check_dec(levels) or check_inc(levels):
            answer += 1
            continue
        for i in range(len(levels)):
            new_level = levels.copy()
            new_level.pop(i)
            if check_dec(new_level) or check_inc(new_level):
                answer += 1
                break

    return answer


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    puzzle_input = (puzzle_dir / "input.txt").read_text().strip()
    data = parse(puzzle_input)

    print(f"Part 1: {part1(data)}")
    print(f"Part 2: {part2(data)}")
