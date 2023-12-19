import pathlib
from sys import maxsize
from collections import deque
from heapq import heappop, heappush

# TODO revisit this


def parse(puzzle_input: str) -> list[list[int]]:
    """Parse input."""
    return [list(map(int, line.strip())) for line in puzzle_input.splitlines()]


def part1(grid: list[list[int]]):
    """Solve part 1."""
    maxR = len(grid) - 1
    maxC = len(grid[0]) - 1
    end = (maxR, maxC)
    visited = set()
    pq = [(0, 0, 0, 0, 1, 0), (0, 0, 0, 1, 0, 0)]

    while pq:
        hl, r, c, dr, dc, s = heappop(pq)

        if (r, c) == end:
            return hl

        if (r, c, dr, dc, s) in visited:
            continue

        visited.add((r, c, dr, dc, s))

        if s < 3:
            nr = r + dr
            nc = c + dc
            if 0 <= nr <= maxR and 0 <= nc <= maxC:
                heappush(pq, (hl + grid[nr][nc], nr, nc, dr, dc, s + 1))

        for ndr, ndc in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
            if (ndr, ndc) != (dr, dc) and (ndr, ndc) != (-dr, -dc):
                nr = r + ndr
                nc = c + ndc
                if 0 <= nr <= maxR and 0 <= nc <= maxC:
                    heappush(pq, (hl + grid[nr][nc], nr, nc, ndr, ndc, 1))

    return 0


def part2(grid: list[list[int]]):
    """Solve part 2."""
    maxR = len(grid) - 1
    maxC = len(grid[0]) - 1
    end = (maxR, maxC)
    visited = set()
    pq = [(0, 0, 0, 0, 1, 0), (0, 0, 0, 1, 0, 0)]

    while pq:
        hl, r, c, dr, dc, s = heappop(pq)

        if (r, c) == end and s >= 4:
            return hl

        if (r, c, dr, dc, s) in visited:
            continue

        visited.add((r, c, dr, dc, s))

        if s < 10:
            nr = r + dr
            nc = c + dc
            if 0 <= nr <= maxR and 0 <= nc <= maxC:
                heappush(pq, (hl + grid[nr][nc], nr, nc, dr, dc, s + 1))

        if s >= 4:
            for ndr, ndc in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                if (ndr, ndc) != (dr, dc) and (ndr, ndc) != (-dr, -dc):
                    nr = r + ndr
                    nc = c + ndc
                    if 0 <= nr <= maxR and 0 <= nc <= maxC:
                        heappush(pq, (hl + grid[nr][nc], nr, nc, ndr, ndc, 1))

    return 0


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    puzzle_input = (puzzle_dir / "input.txt").read_text().strip()
    data = parse(puzzle_input)

    print(f"Part 1: {part1(data)}")
    print(f"Part 2: {part2(data)}")
