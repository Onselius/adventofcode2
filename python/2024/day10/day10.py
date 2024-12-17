import pathlib
from util.grid import (
    getWest,
    getNorth,
    getEast,
    getSouth,
    neighbors_4,
    print_grid_with_visited,
)
from collections import defaultdict


def parse(puzzle_input) -> list[str]:
    """Parse input."""
    return puzzle_input.split("\n")


def part1(data: list[str]):
    """Solve part 1."""
    grid = {}
    heads = []
    for y, row in enumerate(data):
        for x, col in enumerate(row):
            pos = (y, x)
            grid[pos] = int(col)
            if col == "0":
                heads.append(pos)

    answer = 0
    for head in heads:
        visited = set()
        tops = 0
        stack = [head]
        while stack:
            pos = stack.pop()
            visited.add(pos)
            if grid[pos] == 9:
                tops += 1
                continue
            for next in neighbors_4(grid, pos):
                if grid[pos] + 1 == grid[next] and next not in visited:
                    stack.append(next)
        answer += tops

    return answer


def part2(data: list[str]):
    """Solve part 2."""
    grid = {}
    heads = []
    for y, row in enumerate(data):
        for x, col in enumerate(row):
            pos = (y, x)
            grid[pos] = int(col)
            if col == "0":
                heads.append(pos)

    answer = 0
    for head in heads:
        tops = 0
        stack = [head]
        while stack:
            pos = stack.pop()
            if grid[pos] == 9:
                tops += 1
                continue
            for next in neighbors_4(grid, pos):
                if grid[pos] + 1 == grid[next]:
                    stack.append(next)
        answer += tops

    return answer


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    puzzle_input = (puzzle_dir / "input.txt").read_text().strip()
    data = parse(puzzle_input)

    print(f"Part 1: {part1(data)}")
    print(f"Part 2: {part2(data)}")
