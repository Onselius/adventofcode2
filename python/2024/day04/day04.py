import pathlib
from util.grid import getEast, getSW, getSouth, getSE, getNE, getNW, get_corners


def parse(puzzle_input) -> dict[tuple, str]:
    """Parse input."""
    grid = {}
    for y, row in enumerate(puzzle_input.split("\n")):
        for x, col in enumerate(row):
            grid[(y, x)] = col
            x += 1
    return grid


def part1(data: dict[tuple, str]):
    """Solve part 1."""
    start_word = "XMAS"
    count = 0
    for pos, val in data.items():
        if val == "S":
            word = "SAMX"
            for f in getEast, getSW, getSouth, getSE:
                search = True
                new_pos = pos
                for i in range(1, 4):
                    new_pos = f(new_pos)
                    new_val = data.get(new_pos)
                    if new_val == word[i]:
                        continue
                    else:
                        search = False
                        break
                if search:
                    count += 1
        elif val == "X":
            word = "XMAS"
            for f in getEast, getSW, getSouth, getSE:
                search = True
                new_pos = pos
                for i in range(1, 4):
                    new_pos = f(new_pos)
                    new_val = data.get(new_pos)
                    if new_val == word[i]:
                        continue
                    else:
                        search = False
                        break
                if search:
                    count += 1
    return count


def part2(data: dict[tuple, str]):
    """Solve part 2."""
    count = 0
    for pos, val in data.items():
        if val == "A":
            if (
                data.get(getNW(pos), "") == "M"
                and data.get(getSE(pos), "") == "S"
                and data.get(getSW(pos), "") == "M"
                and data.get(getNE(pos), "") == "S"
            ):
                count += 1
            elif (
                data.get(getNW(pos), "") == "S"
                and data.get(getSE(pos), "") == "M"
                and data.get(getSW(pos), "") == "S"
                and data.get(getNE(pos), "") == "M"
            ):
                count += 1
            elif (
                data.get(getNW(pos), "") == "S"
                and data.get(getSE(pos), "") == "M"
                and data.get(getSW(pos), "") == "M"
                and data.get(getNE(pos), "") == "S"
            ):
                count += 1
            elif (
                data.get(getNW(pos), "") == "M"
                and data.get(getSE(pos), "") == "S"
                and data.get(getSW(pos), "") == "S"
                and data.get(getNE(pos), "") == "M"
            ):
                count += 1
    return count


def part3(data: dict[tuple, str]):
    count = 0
    for pos, val in data.items():
        if val == "A":
            neighbors = get_corners(data, pos)
            if len(neighbors) == 4:
                values = [data[v] for v in neighbors]
                if values.count("M") == 2 and values.count("S") == 2:
                    count += 1

    return count


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    puzzle_input = (puzzle_dir / "input.txt").read_text().strip()
    data = parse(puzzle_input)

    print(f"Part 1: {part1(data)}")
    print(f"Part 2: {part2(data)}")
    print(f"Part 3: {part3(data)}")  # doesn't work!
