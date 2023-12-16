import pathlib
from util.grid import getNorth, getSouth, getEast, getWest, print_grid


def parse(puzzle_input) -> tuple[tuple, dict]:
    """Parse input."""
    grid = {}
    start = (0, 0)
    for y, row in enumerate(puzzle_input.split("\n")):
        for x, col in enumerate(row):
            if col == "S":
                start = (y, x)
            grid[(y, x)] = col
    return start, grid


def part1(start: tuple, grid: dict):
    """Solve part 1."""
    steps, loop = createLoop(start, grid)

    return steps


def createLoop(start: tuple, grid: dict) -> tuple[int, list]:
    next = getStartNext(start, grid)
    loop = [start]
    steps = 0

    while True:
        if not next:
            break
        newNext = []

        steps += 1
        for pos in next:
            symbol = grid.get(pos, "")
            [newNext.append(p) for p in getNext(symbol, pos) if p not in loop]
            loop.append(pos)
            grid[pos] = "X"

        # print_grid(grid, 2)
        # print()
        next = newNext

    return steps, loop


def getStartNext(start: tuple, grid: dict):
    symbols = ["|", "-", "L", "J", "7", "F"]

    for symbol in symbols:
        next = getNext(symbol, start)
        if not start in getNext(grid.get(next[0], ""), next[0]):
            continue
        if not start in getNext(grid.get(next[1], ""), next[1]):
            continue
        grid[start] = symbol
        break

    return getNext(symbol, start)


def getNext(symbol: str, pos: tuple) -> list:
    match symbol:
        case "|":
            return [getNorth(pos), getSouth(pos)]
        case "-":
            return [getWest(pos), getEast(pos)]
        case "L":
            return [getNorth(pos), getEast(pos)]
        case "J":
            return [getNorth(pos), getWest(pos)]
        case "7":
            return [getWest(pos), getSouth(pos)]
        case "F":
            return [getEast(pos), getSouth(pos)]
        case "S":
            assert False
    return []


def part2(puzzle_input: str):
    """Solve part 2."""
    start, grid = parse(puzzle_input)
    steps, loop = createLoop(start, grid)

    inside = 0
    switchSymbols = ["J", "L", "|"]

    for y, row in enumerate(puzzle_input.split("\n")):
        isInside = False
        for x, col in enumerate(row):
            if (y, x) not in loop:
                if isInside:
                    inside += 1
            elif col in switchSymbols:
                isInside = not isInside

    return inside


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    puzzle_input = (puzzle_dir / "input.txt").read_text().strip()
    start, data = parse(puzzle_input)

    print(f"Part 1: {part1(start, data)}")
    print(f"Part 2: {part2(puzzle_input)}")
