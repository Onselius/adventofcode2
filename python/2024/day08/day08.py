import pathlib
from collections import defaultdict


def parse(puzzle_input) -> list[str]:
    """Parse input."""
    return puzzle_input


def part1(data):
    """Solve part 1."""
    grid = set()
    antennas = defaultdict(list)
    for y, row in enumerate(data.split("\n")):
        for x, col in enumerate(row):
            if col.isalnum():
                antennas[col].append((y, x))
            grid.add((y, x))
    nodes = set()
    for a in antennas.values():
        for i in range(len(a) - 1):
            for j in range(i + 1, len(a)):
                first = a[i]
                second = a[j]
                diff = (first[0] - second[0], first[1] - second[1])
                node1 = (first[0] + diff[0], first[1] + diff[1])
                node2 = (second[0] - diff[0], second[1] - diff[1])
                if node1 in grid:
                    nodes.add(node1)
                if node2 in grid:
                    nodes.add(node2)

    return len(nodes)


def part2(data: list[str]):
    """Solve part 2."""
    grid = set()
    antennas = defaultdict(list)
    for y, row in enumerate(data.split("\n")):
        for x, col in enumerate(row):
            if col.isalnum():
                antennas[col].append((y, x))
            grid.add((y, x))
    nodes = set()
    for a in antennas.values():
        for i in range(len(a) - 1):
            for j in range(i + 1, len(a)):
                first = a[i]
                second = a[j]
                diff = (first[0] - second[0], first[1] - second[1])
                node1 = (first[0] + diff[0], first[1] + diff[1])
                node2 = (second[0] - diff[0], second[1] - diff[1])
                while node1 in grid or node2 in grid:
                    if node1 in grid:
                        nodes.add(node1)
                    if node2 in grid:
                        nodes.add(node2)
                    node1 = (node1[0] + diff[0], node1[1] + diff[1])
                    node2 = (node2[0] - diff[0], node2[1] - diff[1])

    # [nodes.add(x) for x in antennas.values()]
    [nodes.add(a) for values in antennas.values() for a in values]
    print(len(antennas))
    return len(nodes)


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    puzzle_input = (puzzle_dir / "input.txt").read_text().strip()
    data = parse(puzzle_input)

    print(f"Part 1: {part1(data)}")
    print(f"Part 2: {part2(data)}")
