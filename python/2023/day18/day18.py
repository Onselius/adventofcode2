import pathlib
from util.grid import print_grid
from collections import deque
import numpy as np


def parse(puzzle_input) -> list[str]:
    """Parse input."""

    # print_grid(grid)
    return puzzle_input.splitlines()


def part1(data):
    """Solve part 1."""
    directions = {"R": (0, 1), "L": (0, -1), "D": (1, 0), "U": (-1, 0)}
    grid = set()
    r, c = 0, 0
    for line in data:
        d, s, _ = line.split(" ")
        for i in range(int(s)):
            ndir = directions[d]
            r += ndir[0]
            c += ndir[1]
            grid.add((r, c))
    start = (1, 1)

    queue = deque()
    queue.append(start)
    while queue:
        r, c = queue.popleft()
        for dr, dc in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
            nr = r + dr
            nc = c + dc
            if (nr, nc) not in grid:
                grid.add((nr, nc))
                queue.append((nr, nc))

    return len(grid)


def part2(data: list[str]):
    """Solve part 2."""
    directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    grid = []
    r, c = 0, 0
    boundry = 0
    for line in data:
        _, _, color = line.split(" ")
        color = color.lstrip("(").rstrip(")")[1:]
        d = int(color[-1])
        s = int(color[:5], 16)
        ndir = directions[d]

        r = r + s * ndir[0]
        c = c + s * ndir[1]

        boundry += s
        grid.append((r, c))

    area = shoelace(grid[::-1])

    correct = area - (boundry / 2) + 1 + boundry

    return correct


def shoelace(vertices):
    # A function to apply the Shoelace algorithm
    numberOfVertices = len(vertices)
    sum1 = 0
    sum2 = 0

    for i in range(0, numberOfVertices - 1):
        sum1 = sum1 + vertices[i][0] * vertices[i + 1][1]
        sum2 = sum2 + vertices[i][1] * vertices[i + 1][0]

    # Add xn.y1
    sum1 = sum1 + vertices[numberOfVertices - 1][0] * vertices[0][1]
    # Add x1.yn
    sum2 = sum2 + vertices[0][0] * vertices[numberOfVertices - 1][1]

    area = abs(sum1 - sum2) / 2
    return area


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    puzzle_input = (puzzle_dir / "input.txt").read_text().strip()
    data = parse(puzzle_input)

    print(f"Part 1: {part1(data)}")
    print(f"Part 2: {part2(data)}")
