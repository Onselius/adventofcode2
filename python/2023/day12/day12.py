import pathlib
from functools import cache


def parse(puzzle_input) -> list[str]:
    """Parse input."""
    return puzzle_input.split("\n")


def part1(data: list[str]):
    """Solve part 1."""
    answer = 0
    for line in data:
        springs, groups = line.split(" ")
        groups = tuple([int(g) for g in groups.split(",")])
        possibles = solve(springs, groups)
        answer += possibles
    return answer


@cache
def solve(springs: str, groups: tuple):
    if groups == ():
        return 0 if "#" in springs else 1
    if springs == "":
        return 1 if groups == () else 0

    total = 0
    if springs[0] in ".?":
        total += solve(springs[1:], groups)

    if springs[0] in "#?":
        if (
            groups[0] <= len(springs)
            and "." not in springs[: groups[0]]
            and (groups[0] == len(springs) or springs[groups[0]] != "#")
        ):
            total += solve(springs[groups[0] + 1 :], groups[1:])

    return total


def part2(data: list[str]):
    """Solve part 2."""
    answer = 0
    for line in data:
        springs, groups = line.split(" ")
        springs = "?".join([springs] * 5)
        groups = tuple([int(g) for g in groups.split(",")] * 5)
        possibles = solve(springs, groups)
        answer += possibles
    return answer


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    puzzle_input = (puzzle_dir / "input.txt").read_text().strip()
    data = parse(puzzle_input)

    print(f"Part 1: {part1(data)}")
    print(f"Part 2: {part2(data)}")
