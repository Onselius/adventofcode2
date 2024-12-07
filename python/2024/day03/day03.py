import pathlib
import re


def parse(puzzle_input) -> list[str]:
    """Parse input."""

    return re.findall(r"(do)\(\)|(don)'t\(\)|mul\((\d+,\d+)\)", puzzle_input)


def part1(data: list[str]):
    """Solve part 1."""
    answer = 0
    for line in data:
        for group in line:
            if group == "" or group == "do" or group == "don":
                continue
            x, y = group.split(",")
            answer += int(x) * int(y)
    return answer


def part2(data: list[str]):
    """Solve part 2."""
    answer = 0
    enable = True
    for line in data:
        for group in line:
            if group == "":
                continue
            if group == "do":
                enable = True
            elif group == "don":
                enable = False
            elif enable:
                x, y = group.split(",")
                answer += int(x) * int(y)
                break
    return answer


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    puzzle_input = (puzzle_dir / "input.txt").read_text().strip()
    data = parse(puzzle_input)

    print(f"Part 1: {part1(data)}")
    print(f"Part 2: {part2(data)}")
