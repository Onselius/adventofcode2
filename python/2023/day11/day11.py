import pathlib
from grid import neighbors_4, manhattan_distance


def parse(puzzle_input) -> tuple[list, list, dict]:
    """Parse input."""
    grid = {}
    galaxies = []
    empty: tuple[list, list] = ([], [])
    for y, row in enumerate(puzzle_input.split("\n")):
        if row.find("#") == -1:
            empty[0].append(y)
        for x, col in enumerate(row):
            if col == "#":
                galaxies.append((y, x))
            grid[(y, x)] = col

    maxX: int = max(x for y, x in galaxies)
    exes = [x for y, x in galaxies]
    for x in range(maxX):
        if not x in exes:
            empty[1].append(x)

    return galaxies, empty, grid


def part1(puzzle_input: str, age: int):
    """Solve part 1."""
    galaxies, empty, grid = parse(puzzle_input)
    shortest = []

    for i, start in enumerate(galaxies):
        for end in galaxies[i:]:
            distance = manhattan_distance(start, end)
            shortest.append(distance + calculate_step(age, start, end, empty))

    # this seems unnecessary...
    for g in galaxies:
        break
        grid[g] = "."
        visited = set()
        visited.add(g)
        step = 0
        next = neighbors_4(grid, g)
        next = set([(y, x) for y, x in next if y >= g[0]])
        while len(next) > 0:
            step += 1
            newNext = []
            for pos in next:
                if grid[pos] == "#":
                    shortest.append(step + calculate_step(age, g, pos, empty))
                [
                    newNext.append(p)
                    for p in neighbors_4(grid, pos)
                    if p not in visited and p[0] >= g[0]
                ]
                visited.add(pos)
            next = set(newNext)
    return sum(shortest)


def part2(puzzle_input: str):
    """Solve part 2."""
    return part1(puzzle_input, 1000000)


def calculate_step(age: int, g: tuple, pos: tuple, empty: tuple):
    step = 0
    for y in empty[0]:
        if g[0] < y < pos[0] or g[0] > y > pos[0]:
            step += 1
    for x in empty[1]:
        if g[1] < x < pos[1] or g[1] > x > pos[1]:
            step += 1
    steps = step * age
    if age == 1:
        return steps
    return steps - step


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    puzzle_input = (puzzle_dir / "input.txt").read_text().strip()
    galaxies, empty, grid = parse(puzzle_input)

    print(f"Part 1: {part1(puzzle_input, 1)}")
    print(f"Part 2: {part1(puzzle_input, 1000000)}")

    # 377319269864 too high
