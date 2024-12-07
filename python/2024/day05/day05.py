import pathlib


def parse(puzzle_input) -> list[str]:
    """Parse input."""
    return puzzle_input.split("\n")


def part1(data: list[str]):
    """Solve part 1."""
    allowed_after_this = {}
    allowed_before_this = {}
    upgrades = []
    read_rules = True
    for line in data:
        if line == "":
            read_rules = False
            continue
        if read_rules:
            a, b = line.split("|")
            allowed_after_this[a] = allowed_after_this.get(a, [])
            allowed_after_this[a].append(b)
            allowed_before_this[b] = allowed_before_this.get(b, [])
            allowed_before_this[b].append(a)
        else:
            upgrades.append(line.split(","))
    valid_values = []
    for upgrade in upgrades:
        valid = True
        for i, u in enumerate(upgrade):
            before = upgrade[:i]
            if any(x in before for x in allowed_after_this.get(u, [])):
                valid = False
                break
        if valid:
            valid_values.append(int(upgrade[int((len(upgrade) - 1) / 2)]))

    return sum(valid_values)


def part2(data: list[str]):
    allowed_after_this = {}
    upgrades = []
    read_rules = True
    for line in data:
        if line == "":
            read_rules = False
            continue
        if read_rules:
            a, b = line.split("|")
            allowed_after_this[a] = allowed_after_this.get(a, [])
            allowed_after_this[a].append(b)
        else:
            upgrades.append(line.split(","))
    valid_values = []
    for upgrade in upgrades:
        valid = True
        for i, u in enumerate(upgrade):
            before = upgrade[:i]
            if any(x in before for x in allowed_after_this.get(u, [])):
                valid = False
                break
        if not valid:
            # fix update order
            valid = False
            new_order: list = upgrade.copy()
            while not valid:
                valid = True
                for i, u in enumerate(new_order):
                    before = new_order[:i]
                    if any(x in before for x in allowed_after_this.get(u, [])):
                        valid = False
                        new_order.remove(u)
                        new_order.insert(i - 1, u)
                        break

            valid_values.append(int(new_order[int((len(new_order) - 1) / 2)]))

    return sum(valid_values)


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    puzzle_input = (puzzle_dir / "input.txt").read_text().strip()
    data = parse(puzzle_input)

    print(f"Part 1: {part1(data)}")
    print(f"Part 2: {part2(data)}")
