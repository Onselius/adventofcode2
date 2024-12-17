import pathlib
import re
from sys import maxsize
from util.grid import print_fixed_pos, getEast
import math


def parse(puzzle_input) -> list[str]:
    """Parse input."""
    return puzzle_input.split("\n")


def part1(data: list[str], size: tuple[int, int]):
    """Solve part 1."""
    search = r"p\=(.*,.*) v\=(.*,.*)"
    robots = []
    for line in data:
        match = re.search(search, line)
        x, y = match.group(1).split(",")
        p = (int(y), int(x))
        x, y = match.group(2).split(",")
        v = (int(y), int(x))
        robots.append([p, v])

    # print()
    # print_fixed_pos(size, [r[0] for r in robots], 0)
    # print()
    robots = test_walk(size, 100, robots)

    # print()
    # print_fixed_pos(size, [r[0] for r in robots], 0)
    return math.prod(calculate(size, robots))


def test_walk(
    size: tuple[int, int],
    seconds: int,
    robots: tuple[tuple[int, int], tuple[int, int]],
):
    new_robots = []
    for robot in robots:
        new_y = robot[0][0] + (robot[1][0] * seconds)
        new_x = robot[0][1] + (robot[1][1] * seconds)
        # robot[0] = (new_y, new_x)
        new_robots.append([(new_y % size[0], new_x % size[1]), robot[1]])
    return new_robots


def walk(
    size: tuple[int, int],
    seconds: int,
    robots: tuple[tuple[int, int], tuple[int, int]],
):
    loop = 0
    lowest = maxsize
    highest = 0
    ref_value = 196
    print_progress = False
    for s in range(seconds):
        for robot in robots:
            new_y = (robot[0][0] + robot[1][0]) % size[0]
            new_x = (robot[0][1] + robot[1][1]) % size[1]
            robot[0] = (new_y, new_x)

        if print_progress:
            if s % 100 == 0:
                print(f"second: {s} highest: {highest}")

        scores = calculate(size, robots)

        for score in scores:
            if score > ref_value:
                print_fixed_pos(size, [r[0] for r in robots], 0)
                print(s)
                print(scores)
                input("press to continue")

        score = math.prod(calculate(size, robots))
        if score < lowest:
            print_fixed_pos(size, [r[0] for r in robots], 0)
            print()
            lowest = score
            highest = score
            loop = s + 1

    return loop


def check_joining(size, positions, amount):
    maxY: int = size[0]
    maxX: int = size[1]
    minY: int = 0
    minX: int = 0

    count = 0
    for r in range(minY, maxY + 1):
        for c in range(minX, maxX + 1):
            if (r, c) in positions:
                count += 1
            else:
                count = 0
            if count == amount:
                return True
    return False


def calculate(size: tuple[int, int], robots: tuple[tuple[int, int], tuple[int, int]]):
    middle = ((size[0] - 1) / 2, (size[1] - 1) / 2)
    first = sum(1 for r in robots if r[0][0] < middle[0] and r[0][1] < middle[1])
    # first_list = [r for r in robots if r[0][0] < middle[0] and r[0][1] < middle[1]]
    second = sum(1 for r in robots if r[0][0] > middle[0] and r[0][1] < middle[1])
    third = sum(1 for r in robots if r[0][0] < middle[0] and r[0][1] > middle[1])
    fourth = sum(1 for r in robots if r[0][0] > middle[0] and r[0][1] > middle[1])

    return [first, second, third, fourth]


def calculate_part2(
    size: tuple[int, int], robots: tuple[tuple[int, int], tuple[int, int]], offset: int
):
    middle = ((size[0] - 1) / 2, (size[1] - 1) / 2)
    first = sum(1 for r in robots if r[0][0] < middle[0] and r[0][1] < middle[1])
    second = sum(1 for r in robots if r[0][0] > middle[0] and r[0][1] < middle[1])
    third = sum(1 for r in robots if r[0][0] < middle[0] and r[0][1] > middle[1])
    fourth = sum(1 for r in robots if r[0][0] > middle[0] and r[0][1] > middle[1])

    amount = len(robots) - offset
    if amount == first or amount == second or amount == third or amount == fourth:
        return True
    return False


def part2(data: list[str], size: tuple[int, int]):
    """Solve part 2."""
    search = r"p\=(.*,.*) v\=(.*,.*)"
    robots = []
    for line in data:
        match = re.search(search, line)
        x, y = match.group(1).split(",")
        p = (int(y), int(x))
        x, y = match.group(2).split(",")
        v = (int(y), int(x))
        robots.append([p, v])

    # robots = test_walk(size, 5000, robots)
    return walk(size, 10408, robots)

    return size[0] * size[1]
    return calculate(size, robots)


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    puzzle_input = (puzzle_dir / "input.txt").read_text().strip()
    data = parse(puzzle_input)

    print(f"Part 1: {part1(data, (103, 101))}")
    print(f"Part 2: {part2(data, (103, 101))}")  # high 10403 9999 9901
