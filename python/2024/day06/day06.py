import pathlib
from util.grid import (
    getWest,
    getNorth,
    getEast,
    getSW,
    getSouth,
    getSE,
    getNE,
    getNW,
    get_corners,
    print_grid_with_visited,
)


def parse(puzzle_input) -> list[str]:
    """Parse input."""
    grid = {}
    for y, row in enumerate(puzzle_input.split("\n")):
        for x, col in enumerate(row):
            grid[(y, x)] = col
    return puzzle_input


def part1(data):
    """Solve part 1."""
    grid = {}
    pos = ()
    for y, row in enumerate(data.split("\n")):
        for x, col in enumerate(row):
            grid[(y, x)] = col
            if col == "^":
                pos = (y, x)
                grid[(y, x)] = "."

    visited = set()
    visited.add(pos)
    direction = 0
    turn_order = [getNorth, getEast, getSouth, getWest]
    while True:
        # print_grid_with_visited(grid, visited, 0)
        next = turn_order[direction](pos)
        if not next in grid:
            break
        value = grid[next]
        if value == "#":
            direction = (direction + 1) % 4
        elif value in ".":
            pos = next
            visited.add(pos)

    return len(visited)


def part2(data):
    """Solve part 2."""
    grid = {}
    pos = ()
    for y, row in enumerate(data.split("\n")):
        for x, col in enumerate(row):
            grid[(y, x)] = col
            if col == "^":
                pos = (y, x)
                grid[(y, x)] = "."

    direction = 0
    obstacles = set()
    loops = 0
    turn_order = [getNorth, getEast, getSouth, getWest]
    while True:
        next = turn_order[direction](pos)
        if not next in grid:
            break
        value = grid[next]
        if value == "#":
            direction = (direction + 1) % 4
        elif value in ".":
            if next not in obstacles:
                # grid_copy = grid.copy()
                # grid_copy[next] = "#"
                obstacles.add(next)
                grid[next] = "#"
                if check_loop(grid, pos, direction):
                    loops += 1
                grid[next] = "."

            pos = next

    return loops


def check_loop(grid, pos, direction):
    visited = set()
    visited.add((pos[0], pos[1], direction))
    turn_order = [getNorth, getEast, getSouth, getWest]
    while True:
        next = turn_order[direction](pos)
        next_with_dir = (next[0], next[1], direction)
        if not next in grid:
            return False
        if next_with_dir in visited:
            return True
        value = grid[next]
        if value == "#":
            direction = (direction + 1) % 4
        elif value in ".":
            pos = next
            visited.add(next_with_dir)


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    data = (puzzle_dir / "input.txt").read_text().strip()
    # data = parse(puzzle_input)

    print(f"Part 1: {part1(data)}")
    print(f"Part 2: {part2(data)}")
