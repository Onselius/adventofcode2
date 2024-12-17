import pathlib
from collections import defaultdict


def parse(puzzle_input) -> list[str]:
    """Parse input."""
    stones = {}
    for s in puzzle_input.split():
        stones[s] = stones.get(s, 0) + 1
    return stones


def part1(data: dict):
    """Solve part 1."""
    return blink(data, 25)


def blink(stones: dict, count: int):
    updated = stones
    for i in range(count):
        stones = updated
        updated = defaultdict(int)
        for s in stones:
            if stones[s] == 0:
                continue
            if int(s) == 0:
                updated["1"] = updated["1"] + stones[s]
            elif len(s) % 2 == 0:
                first = s[: len(s) // 2].lstrip("0")
                second = int(s[len(s) // 2 :])
                updated[first] = updated[first] + stones[s]
                updated[str(second)] = updated[str(second)] + stones[s]
            else:
                new_stone = str(int(s) * 2024)
                updated[new_stone] = updated[new_stone] + stones[s]
    return sum(updated.values())


def part2(data: list[str]):
    """Solve part 2."""
    return blink(data, 75)


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    puzzle_input = (puzzle_dir / "input.txt").read_text().strip()
    data = parse(puzzle_input)

    print(f"Part 1: {part1(data)}")
    print(f"Part 2: {part2(data)}")
