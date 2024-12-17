import pathlib
from collections import defaultdict
from util.grid import getWest, getNorth, getEast, getSouth, neighbors_4


def parse(puzzle_input) -> list[str]:
    """Parse input."""
    return puzzle_input.split("\n")


def part1_1(data: list[str]):
    """Solve part 1."""
    prices = {}
    grid = {}
    plots = defaultdict(list)
    for y, row in enumerate(data):
        for x, col in enumerate(row):
            grid[(y, x)] = col
            plots[col].append(((y, x)))

    score = {}
    for name, places in plots.items():
        edges = 0
        for pos in places:
            for n in neighbors_4((), pos, False):
                if n not in places:
                    edges += 1
        score[name] = len(places) * edges

    return sum(score.values())


def part1(data: list[str]):
    """Solve part 1."""
    grid = {}
    plots = defaultdict(list)
    for y, row in enumerate(data):
        for x, col in enumerate(row):
            grid[(y, x)] = col
            plots[col].append(((y, x)))

    score = {}
    plots_visited = set()
    for point in grid:
        if point in plots_visited:
            continue
        name = grid[point]
        edges = 0
        area = 0
        next = set()
        next.add(point)
        visited = set()
        while next:
            area += 1
            p = next.pop()
            visited.add(p)
            for n in neighbors_4((), p, False):
                if grid.get(n, "#") == name and n not in visited:
                    next.add(n)
                elif grid.get(n, "#") == name and n in visited:
                    continue
                else:
                    edges += 1
        plots_visited.update(visited)
        score[name] = score.get(name, 0) + (area * edges)

    return sum(score.values())


def part2(data: list[str]):
    """Solve part 2."""
    grid = {}
    plots = defaultdict(list)
    for y, row in enumerate(data):
        for x, col in enumerate(row):
            grid[(y, x)] = col
            plots[col].append(((y, x)))

    getEdges = [getWest, getNorth, getEast, getSouth]
    score = {}
    plots_visited = set()
    for point in grid:
        if point in plots_visited:
            continue
        name = grid[point]
        edges = []
        area = 0
        next = set()
        next.add(point)
        visited = set()
        while next:
            area += 1
            p = next.pop()
            visited.add(p)
            # for n in neighbors_4((), p, False):
            for i in range(len(getEdges)):
                n = getEdges[i](p)
                if grid.get(n, "#") == name and n not in visited:
                    next.add(n)
                elif grid.get(n, "#") == name and n in visited:
                    continue
                else:
                    edges.append((n[0], n[1], i))
        plots_visited.update(visited)
        sides = 0
        while edges:
            edge = edges.pop()
            start_pos = (edge[0], edge[1])
            direction = (edge[2] + 1) % 4  # get side direction
            other_direction = (direction + 2) % 4  # get side direction
            pos = start_pos
            for getEdge in [getEdges[dir] for dir in [direction, other_direction]]:
                while True:
                    point = getEdge(pos)
                    point_with_dir = (point[0], point[1], edge[2])
                    if point_with_dir in edges:
                        edges.remove(point_with_dir)
                        pos = point
                        continue
                    break
                pos = start_pos

            sides += 1

        score[name] = score.get(name, 0) + (area * sides)
    return sum(score.values())


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    puzzle_input = (puzzle_dir / "input.txt").read_text().strip()
    data = parse(puzzle_input)

    print(f"Part 1: {part1(data)}")  # 13286162 high
    print(f"Part 2: {part2(data)}")
