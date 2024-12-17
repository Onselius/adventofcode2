import pathlib
from util.grid import getEast, getDirections, print_grid_with_visited
from queue import Queue
from collections import defaultdict
from sys import maxsize
import heapq


def parse(puzzle_input) -> list[str]:
    """Parse input."""
    grid = {}
    start = ()
    end = ()
    for y, row in enumerate(puzzle_input.split("\n")):
        for x, col in enumerate(row):
            pos = (y, x)
            if col == "S":
                start = pos
                grid[pos] = "."
                continue
            elif col == "E":
                end = pos
            grid[pos] = col
    return start, end, grid


def part1(start, end, grid):
    """Solve part 1."""
    visited = get_paths(start, end, grid)
    return min(visited[p] for p in visited if p[0] == end[0] and p[1] == end[1])


def get_paths(start, end, grid):
    visited = defaultdict(lambda: maxsize)
    current_direction = getEast
    directions = getDirections()

    next = [(0, start[0], start[1], directions.index(current_direction))]
    end_score = 0
    while next:
        point = heapq.heappop(next)
        pos = (point[1], point[2], point[3])
        # print_grid_with_visited(grid, visited, 0)
        if point[0] > visited[pos]:
            continue
        visited[pos] = point[0]
        for i, dir in enumerate(directions):
            new_pos = dir((pos[0], pos[1]))
            new_with_dir = (new_pos[0], new_pos[1], i)
            if grid[new_pos] == "#":
                continue
            if i == point[3]:
                score = point[0] + 1
            else:
                score = point[0] + 1001
            if grid[new_pos] == "E":
                if score < visited[new_with_dir]:
                    visited[new_with_dir] = score
                # print(visited.get(new_with_dir, 0))
                continue
            if visited[new_with_dir] > score:
                heapq.heappush(next, ((score, new_pos[0], new_pos[1], i)))

    return visited


def part2(start, end, grid):
    """Solve part 2."""
    visited = get_paths(start, end, grid)
    lowest_visited = defaultdict(lambda: maxsize)
    for k, v in visited.items():
        if lowest_visited[k[:-1]] > v:
            lowest_visited[k[:-1]] = v

    print(lowest_visited[end])
    count = 1
    directions = getDirections()
    visited = set()
    next = [end]
    while next:
        pos = next.pop()
        if pos in visited:
            continue
        visited.add(pos)
        # print_grid_with_visited(grid, visited, 0)
        # print(next)
        neighbors = [dir(pos) for dir in directions if dir(pos) in lowest_visited]
        lowest = min(lowest_visited[p] for p in neighbors)
        for n in neighbors:
            if lowest == lowest_visited[n]:
                next.insert(0, n)

    return len(visited)


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    puzzle_input = (puzzle_dir / "input.txt").read_text().strip()
    start, end, grid = parse(puzzle_input)

    print(f"Part 1: {part1(start, end, grid)}")
    print(f"Part 2: {part2(start, end, grid)}")  # 490 low
