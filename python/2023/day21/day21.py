import pathlib
from collections import deque
from grid import neighbors_4, print_grid, print_grid_with_visited


def parse(puzzle_input) -> list[str]:
    """Parse input."""
    grid = dict()
    start = (0, 0)
    for r, line in enumerate(puzzle_input.splitlines()):
        for c, val in enumerate(line):
            if val == "#":
                continue
            grid[(r, c)] = val
            if val == "S":
                start = (r, c)
    return grid, start


def part1(puzzle_input: str):
    """Solve part 1."""
    grid, start = parse(puzzle_input)

    return walk_grid(grid, start, 64)


def walk_grid(grid, start, steps):
    queue = deque()
    queue.append(start)

    width = max([c for r, c in grid.keys()]) + 1
    height = max([r for r, c in grid.keys()]) + 1
    connections = dict()
    connected = 0
    max_steps = 26501365

    for i in range(steps):
        next_queue = set()
        visited = set()

        while queue:
            pos = queue.popleft()
            r, c = pos

            for d in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                actual = (r + d[0], c + d[1])
                position = (actual[0] % height, actual[1] % width)

                if position in grid and actual not in visited:
                    visited.add(actual)
                    next_queue.add(actual)

        queue = deque(next_queue)
        # print_grid_with_visited(grid, visited, 0)

    return len(visited)


def part2(data: list[str]):
    """Solve part 2."""
    return "part2"


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    puzzle_input = (puzzle_dir / "input.txt").read_text().strip()

    print(f"Part 1: {part1(puzzle_input)}")
    print(f"Part 2: {part2(puzzle_input)}")

    # 6501 high
    # 6245 high
