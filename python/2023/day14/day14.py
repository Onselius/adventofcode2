import pathlib
from util.grid import getNorth, print_grid, getWest, getSouth, getEast, getHashString


def parse(puzzle_input) -> list[str]:
    """Parse input."""
    grid = {}
    for y, row in enumerate(puzzle_input.split("\n")):
        for x, c in enumerate(row):
            grid[(y, x)] = c

    return grid


def part1(grid):
    """Solve part 1."""
    grid = rotate_grid(grid, getNorth)

    return calculate_part1(grid)


def rotate_grid(grid, direction):
    moves = 1
    while moves != 0:
        moves = 0
        for p, c in grid.items():
            if c != "O":
                continue
            new_pos = p
            north = direction(new_pos)
            try:
                while grid[north] == ".":
                    new_pos = north
                    north = direction(north)
            except:
                pass
            if new_pos != p:
                grid[p] = "."
                grid[new_pos] = "O"
                moves += 1

    return grid


def calculate_part1(grid):
    maxY: int = max(y for y, x in grid.keys())
    sum = 0
    for p, val in grid.items():
        if val != "O":
            continue
        sum += maxY - p[0] + 1
    return sum


def get_rock_position(grid: dict):
    rocks = []
    for p, val in grid.items():
        if val == "O":
            rocks.append(str(p[0]) + str(p[1]))

    return "".join(rocks)


def part2(grid):
    """Solve part 2."""

    rotation = [getNorth, getWest, getSouth, getEast]
    grids = set()
    gridss = {}
    cycles = []
    for cycle in range(1000000000):
        start = getHashString(grid)
        if start in gridss.keys():
            grid = gridss[start]
            break
        cycles.append(start)
        for i in range(4):
            direction = rotation[i % 4]
            grid = rotate_grid(grid, direction)
        gridss[start] = grid.copy()
        grids.add(getHashString(grid))

    cycle_length = len(cycles) - cycles.index(start)
    index = ((1000000000 - 1 - len(cycles)) % cycle_length) + cycles.index(start)
    value = calculate_part1(gridss[cycles[index]])

    return value


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    puzzle_input = (puzzle_dir / "input.txt").read_text().strip()
    grid = parse(puzzle_input)

    print(f"Part 1: {part1(grid)}")
    print(f"Part 2: {part2(grid)}")
