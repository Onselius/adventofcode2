from time import sleep


class Grid:
    def __init__(self):
        self.grid = {}
        self.pos = (0, 0)

    def create_grid(self, input):
        pass


def neighbors_4(grid: dict[tuple], pos: tuple[int, int]):
    y, x = pos
    candidates = [
        (y - 1, x),
        (y + 1, x),
        (y, x - 1),
        (y, x + 1),
    ]
    return [p for p in candidates if p in grid]


def get_corners(grid: dict[tuple], pos: tuple[int, int]):
    y, x = pos
    candidates = [(y - 1, x - 1), (y - 1, x + 1), (y + 1, x - 1), (y + 1, x + 1)]
    return [p for p in candidates if p in grid]


def neighbors_8(grid: dict[tuple], pos: tuple[int, int]):
    y, x = pos
    candidates = [
        (y - 1, x),
        (y - 1, x - 1),
        (y - 1, x + 1),
        (y + 1, x),
        (y + 1, x - 1),
        (y + 1, x + 1),
        (y, x - 1),
        (y, x + 1),
    ]
    return [p for p in candidates if p in grid]


def getNorth(pos: tuple) -> tuple:
    return (pos[0] - 1, pos[1])


def getNE(pos: tuple) -> tuple:
    return (pos[0] - 1, pos[1] + 1)


def getNW(pos: tuple) -> tuple:
    return (pos[0] - 1, pos[1] - 1)


def getSouth(pos: tuple) -> tuple:
    return (pos[0] + 1, pos[1])


def getSE(pos: tuple) -> tuple:
    return (pos[0] + 1, pos[1] + 1)


def getSW(pos: tuple) -> tuple:
    return (pos[0] + 1, pos[1] - 1)


def getEast(pos: tuple) -> tuple:
    return (pos[0], pos[1] + 1)


def getWest(pos: tuple) -> tuple:
    return (pos[0], pos[1] - 1)


def print_grid(grid: dict, time: int = 0):
    keys = grid.keys()
    maxY: int = max(y for y, x in keys)
    maxX: int = max(x for y, x in keys)
    minY: int = min(y for y, x in keys)
    minX: int = min(x for y, x in keys)

    print(
        "\n".join(
            "".join(grid.get((y, x), " ")[0] for x in range(minX, maxX + 1))
            for y in range(minY, maxY + 1)
        )
    )
    sleep(time)


def print_non_square_grid(grid: dict, time: int = 0):
    keys = grid.keys()
    maxY: int = max(y for y, x in keys)
    maxX: int = max(x for y, x in keys)
    minY: int = min(y for y, x in keys)
    minX: int = min(x for y, x in keys)


def print_grid_with_pos(grid: dict, pos: tuple[int, int]):
    # TODO implement
    keys = grid.keys()
    maxY: int = max(y for y, x in keys)
    maxX: int = max(x for y, x in keys)
    minY: int = min(y for y, x in keys)
    minX: int = min(x for y, x in keys)

    print(
        "\n".join(
            "".join(grid[(y, x)] for x in range(minX, maxX + 1))
            for y in range(minY, maxY + 1)
        )
    )


def print_grid_with_visited(grid: dict, visited: dict, time: int = 0):
    keys = grid.keys()
    maxY: int = max(y for y, x in keys)
    maxX: int = max(x for y, x in keys)
    minY: int = min(y for y, x in keys)
    minX: int = min(x for y, x in keys)

    for r in range(minY, maxY):
        for c in range(minX, maxX):
            if (r, c) in visited:
                print("X", end="")
            else:
                print(grid.get((r, c), " "), end="")
        print()
    sleep(time)


def manhattan_distance(start: tuple, end: tuple):
    return sum(abs(val1 - val2) for val1, val2 in zip(start, end))


def getHashString(grid: dict):
    hash_string = "".join([str(hash(k)) for k in grid.values()])
    # print(f"hashstring: {hash_string}")
    return hash(hash_string)
