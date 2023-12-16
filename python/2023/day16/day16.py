import pathlib
from util.grid import getNorth, getEast, getWest, getSouth, print_grid_with_pos


def parse(puzzle_input) -> dict[tuple, str]:
    """Parse input."""
    grid = {}
    for r, line in enumerate(puzzle_input.split("\n")):
        for c, val in enumerate(line):
            grid[(r, c)] = val
    return grid


def part1(grid: dict):
    """Solve part 1."""
    energized = set()
    seen = []
    start = (0, 0, "e")
    next = [start]
    while len(next) > 0:
        current_pos = next.pop()
        seen.append(current_pos)
        energized.add(current_pos[:2])
        next_pos = get_next_pos(grid, current_pos)
        next.extend([p for p in next_pos if p not in seen and p[:2] in grid])
    return len(energized)


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
    return max(energy)


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    puzzle_input = (puzzle_dir / "input.txt").read_text().strip()
    grid = parse(puzzle_input)

    print(f"Part 1: {part1(grid)}")
    print(f"Part 2: {part2(grid)}")
