import pathlib
from collections import deque
from util.grid import getNorth, getEast, getWest, getSouth, print_grid_with_pos

# TODO revist this


def parse(puzzle_input) -> dict[tuple, str]:
    """Parse input."""
    grid = {}
    for r, line in enumerate(puzzle_input.split("\n")):
        for c, val in enumerate(line):
            grid[(r, c)] = val
    return grid


def part1(grid: dict):
    """Solve part 1."""
    start = (0, 0, 0, 1)
    energized = traverse(grid, start)
    return energized


def traverse(grid, start):
    seen = set()
    queue = deque()
    queue.append(start)
    while queue:
        position = queue.popleft()
        if position[:2] not in grid:
            continue
        seen.add(position)
        next_pos = get_next(position, grid)
        queue.extend([p for p in next_pos if p not in seen])
    return len({(r, c) for (r, c, _, _) in seen})


def get_next(pos, grid):
    r, c, dr, dc = pos
    val = grid[(r, c)]
    a = []
    if val == "." or (val == "-" and dc != 0) or (val == "|" and dr != 0):
        r += dr
        c += dc
        a.append((r, c, dr, dc))
    elif val == "/":
        dr, dc = -dc, -dr
        r += dr
        c += dc
        a.append((r, c, dr, dc))
    elif val == "\\":
        dr, dc = dc, dr
        r += dr
        c += dc
        a.append((r, c, dr, dc))
    elif val == "|":
        for dr_new, dc_new in [(1, 0), (-1, 0)]:
            a.append((r + dr_new, c + dc_new, dr_new, dc_new))
    else:
        for dr_new, dc_new in [(0, 1), (0, -1)]:
            a.append((r + dr_new, c + dc_new, dr_new, dc_new))

    return a


def get_next_pos(grid, position):
    directions = {"n": getNorth, "e": getEast, "s": getSouth, "w": getWest}
    pos = position[:2]
    if pos not in grid:
        return []
    d = position[-1]
    val = grid[pos]
    if val == ".":
        return [directions[d](pos) + tuple(d)]
    elif val == "|":
        if d in "ew":
            return [getNorth(pos) + tuple("n"), getSouth(pos) + tuple("s")]
        else:
            return [directions[d](pos) + tuple(d)]
    elif val == "-":
        if d in "ns":
            return [getEast(pos) + tuple("e"), getWest(pos) + tuple("w")]
        else:
            return [directions[d](pos) + tuple(d)]
    elif val == "/":
        if d == "n":
            return [getEast(pos) + tuple("e")]
        if d == "e":
            return [getNorth(pos) + tuple("n")]
        if d == "s":
            return [getWest(pos) + tuple("w")]
        if d == "w":
            return [getSouth(pos) + tuple("s")]
        assert False
    elif val == "\\":
        if d == "s":
            return [getEast(pos) + tuple("e")]
        if d == "w":
            return [getNorth(pos) + tuple("n")]
        if d == "n":
            return [getWest(pos) + tuple("w")]
        if d == "e":
            return [getSouth(pos) + tuple("s")]
        assert False
    assert False


def part2(grid: dict):
    maxY: int = max(y for y, x in grid.keys())
    maxX: int = max(x for y, x in grid.keys())
    minY: int = min(y for y, x in grid.keys())
    minX: int = min(x for y, x in grid.keys())
    start = []
    for r in range(maxY + 1):
        start.append((r, minX, 0, 1))
        start.append((r, maxX, 0, -1))
    for c in range(maxX + +11):
        start.append((minY, c, 1, 0))
        start.append((maxY, c, -1, 0))
    energy = 0
    for s in start:
        n = traverse(grid, s)
        energy = max(energy, n)
    return energy


def part2_1(grid: dict):
    """Solve part 2."""
    maxY: int = max(y for y, x in grid.keys())
    maxX: int = max(x for y, x in grid.keys())
    minY: int = min(y for y, x in grid.keys())
    minX: int = min(x for y, x in grid.keys())
    start = []
    for c in range(maxX):
        start.append((minY, c, "s"))
    for c in range(maxX):
        start.append((maxY, c, "n"))
    for r in range(maxY):
        start.append((r, minX, "e"))
    for r in range(maxY):
        start.append((r, maxX, "w"))
    energy = []
    e_dict = {}
    for s in start:
        energized = set()
        seen = []
        next = [s]
        while len(next) > 0:
            current_pos = next.pop()
            seen.append(current_pos)
            energized.add(current_pos[:2])
            next_pos = get_next_pos(grid, current_pos)
            next.extend([p for p in next_pos if p not in seen and p[:2] in grid])
        energy.append(len(energized))
        e_dict[len(energized)] = s
    max_e = max(energy)
    print(e_dict[max_e])
    return max(energy)


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    puzzle_input = (puzzle_dir / "input.txt").read_text().strip()
    grid = parse(puzzle_input)

    print(f"Part 1: {part1(grid)}")
    print(f"Part 2: {part2(grid)}")
    print(f"Part 2: {part2_1(grid)}")
