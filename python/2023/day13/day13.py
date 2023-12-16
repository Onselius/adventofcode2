import pathlib


def parse(puzzle_input) -> list[str]:
    """Parse input."""
    return puzzle_input.split("\n\n")


def part1(data: list[str]):
    """Solve part 1."""
    return solve(data, 0)


def part2(data: list[str]):
    """Solve part 1."""
    return solve(data, 1)


def solve(data: list[str], allowed_errors):
    col_sum = 0
    row_sum = 0
    for pond in data:
        rows = []
        cols = []
        for line in pond.split("\n"):
            rows.append(line)
            for i, val in enumerate(line):
                if i >= len(cols):
                    cols.append([])
                cols[i].append(val)
        col_sum += check_values(cols, 0, allowed_errors)
        row_sum += check_values(rows, 0, allowed_errors)
    return (100 * row_sum) + col_sum


def check_values(values, old, allowed=0):
    for d in range(len(values) - 1):
        offset = 0
        errors = 0
        for c in values[d + 1 :]:
            if d - offset < 0:
                break
            down = values[d - offset]
            errors += count_diff(down, c)
            offset += 1
        if errors == allowed:
            if d + 1 != old:
                return d + 1
    return 0


def count_diff(one, two):
    errors = 0
    for i in range(len(one)):
        if one[i] != two[i]:
            errors += 1

    return errors


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    puzzle_input = (puzzle_dir / "input.txt").read_text().strip()
    data = parse(puzzle_input)

    print(f"Part 1: {part1(data)}")
    print(f"Part 2: {part2(data)}")
