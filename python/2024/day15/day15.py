import pathlib
from util.grid import getEast, getNorth, getWest, getSouth, print_grid_with_pos
from collections import defaultdict


def parse(puzzle_input) -> list[str]:
    """Parse input."""
    return puzzle_input


def part1(data: list[str]):
    """Solve part 1."""
    map, directions = data.split("\n\n")
    moves = directions.replace("\n", "")
    pos = ()
    grid = dict()
    for y, row in enumerate(map.split("\n")):
        for x, col in enumerate(row):
            if col == "@":
                pos = (y, x)
                grid[(y, x)] = "."
                continue
            grid[(y, x)] = col

    moveset = {"<": getWest, "^": getNorth, ">": getEast, "v": getSouth}
    for m in moves:
        move = moveset[m]
        next = move(pos)
        while grid[next] == "O":
            next = move(next)
        if grid[next] == ".":
            new_pos = move(pos)
            grid[next] = grid[new_pos]
            grid[new_pos] = "."
            pos = new_pos
        # print_grid_with_pos(grid, pos)
        # print()

    return get_gps(grid)


def get_gps(grid: dict):
    gps = 0
    for k, v in grid.items():
        if v == "O":
            gps += 100 * k[0] + k[1]
    return gps


def part2(data: list[str]):
    """Solve part 2."""
    map, directions = data.split("\n\n")
    moves = directions.replace("\n", "")
    pos = ()
    grid = defaultdict(str)
    for y, row in enumerate(map.split("\n")):
        for x, col in enumerate(row):
            big_x = x * 2
            if col == "@":
                pos = (y, big_x)
                grid[(y, big_x)] = "."
                grid[(y, big_x + 1)] = "."
                continue
            elif col == "O":
                grid[(y, big_x)] = "O"
                grid[(y, big_x + 1)] = "."
                continue
            grid[(y, big_x)] = col
            grid[(y, big_x + 1)] = col

    moveset = {"<": getWest, "^": getNorth, ">": getEast, "v": getSouth}
    for m in moves:
        move = moveset[m]
        if can_move(grid, [pos], move):
            make_move(grid, [pos], move)
            pos = move(pos)

        # print(m)
        # print_grid_with_pos(grid, pos)
        # print()

    return get_gps(grid)


def can_move(grid, positions, move):
    for p in positions:
        next = move(p)
        if grid[next] == "#":
            return False
    boxes = set()
    for p in positions:
        next = move(p)
        if grid[next] == "O":
            boxes.add(next)
        elif grid[getWest(next)] == "O":
            boxes.add(getWest(next))

    if boxes:
        for box in boxes:
            if move == getWest:
                checklist = [box]
            elif move == getEast:
                checklist = [getEast(box)]
            else:
                checklist = [box, getEast(box)]
            if not can_move(grid, checklist, move):
                return False

    return True


def make_move(grid, positions, move):
    for p in positions:
        next = move(p)
        if grid[next] == "#":
            return
    boxes = set()
    for p in positions:
        next = move(p)
        if grid[next] == "O":
            boxes.add(next)
        elif grid[getWest(next)] == "O":
            boxes.add(getWest(next))

    if boxes:
        for box in boxes:
            if move == getWest:
                checklist = [box]
            elif move == getEast:
                checklist = [getEast(box)]
            else:
                checklist = [box, getEast(box)]
            make_move(grid, checklist, move)
        for box in boxes:
            grid[move(box)] = "O"
            grid[box] = "."


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    puzzle_input = (puzzle_dir / "input.txt").read_text().strip()
    data = parse(puzzle_input)

    print(f"Part 1: {part1(data)}")
    print(f"Part 2: {part2(data)}")  # 1484808 high
