import pathlib
import functools


def parse(puzzle_input) -> list[str]:
    """Parse input."""
    return puzzle_input.split("\n")


def part1(data: list[str]):
    """Solve part 1."""
    sum = 0
    for line in data:
        print(f"processing {line}")
        springs, groups = line.split(" ")
        groups = [int(v) for v in groups.split(",")]
        # correct = new_check(springs, groups)
        correct = 0
        sets = generate_list(springs, groups, [])
        correct = is_correct(sets, groups)

        print(f"{line} {correct}")
        sum += correct
    return sum


def is_correct(sets, groups):
    count = 0
    for s in sets:
        combo = [s for s in s.split(".") if len(s) > 0]
        if len(combo) != len(groups):
            continue
        for i in range(len(combo)):
            correct = True
            if len(combo[i]) != groups[i]:
                correct = False
                break
        if correct:
            count += 1

    return count


def generate_list(line: str, groups, seen):
    my_set = set()
    if sum(groups) > (len(line) - line.count(".")):
        return my_set
    combo = [s for s in line.split(".") if len(s) > 0]
    # for i, c in enumerate(combo):
    # if len(combo[i]) < groups[i]:
    # return my_set
    if line.count("?") == 0:
        if len(combo) == len(groups):
            my_set.add(line)
        return my_set
    for l in line:
        if l == ".":
            continue
        if l == "?":
            if line in seen:
                continue
            seen.append(line)
            my_set.update(generate_list(line.replace("?", ".", 1), groups, seen))
            my_set.update(generate_list(line.replace("?", "#", 1), groups, seen))

    return my_set


def another_check(line: str, groups):
    correct = 0
    if sum(groups) >= len(line) - line.count("."):
        return correct
    symbols = line.split(".")
    for s in symbols:
        print(s)

    return correct


def new_check(line: str, groups):
    correct = 0
    if sum(groups) > (len(line) - line.count(".")):
        return correct
    if len(line) == 0 and len(groups) != 0:
        return 0
    elif len(line) == 0 and len(groups) == 0:
        return 1
    for i, l in enumerate(line):
        if l == ".":
            continue
        elif l == "?":
            correct += new_check(line.replace("?", ".", 1), groups)
            correct += new_check(line.replace("?", "#", 1), groups)
        elif l == "#":
            if len(line) >= groups[0] and "." not in line[i : i + groups[0]]:
                correct += new_check(line[i + groups[0] :], groups[1:])

    return correct


def check_correct(springs: str, groups):
    correct = 0
    if len(groups) == 0:
        if len(springs) == 0:
            return 1
        elif springs.replace("?", ".").count("#") == 0:
            return 1
        return 0
    i = 0
    iter_springs = iter(springs)
    for val in iter_springs:
        if i + sum(groups) > len(springs):
            break
        if val == ".":
            i += 1
            continue

        end_index = i + groups[0]
        if end_index > len(springs):
            return correct + 1 if len(groups) == 0 else correct

        match = springs[i:end_index]

        if match.replace("?", "#") == "#" * groups[0]:
            next_springs = springs[end_index:]
            if len(next_springs) != 0 and next_springs[0] in "?.":
                correct += check_correct(next_springs[1:], groups[1:])
            if val == "#":
                try:
                    [next(iter_springs) for _ in range(groups[0] + 1)]
                except StopIteration:
                    pass
                groups = groups[1:]
        if len(groups) == 0:
            break
        i += 1

    return correct


def part2(data: list[str]):
    """Solve part 2."""
    sum = 0
    for line in data:
        springs, groups = line.split(" ")
        # groups = [int(v) for v in groups.split(",") * 5]
        # springs = "?".join([springs * 5])
        groups = [int(v) for v in groups.split(",")]

        correct = faster(springs, len(springs), groups)
        # correct = is_correct(sets, groups)

        print(f"{line} {correct}")
        sum += correct
    return sum


def faster(line, size, groups):
    current_group = groups[0]
    new_group = groups[1:]
    count = 0

    # sum of group + number of groups must be longer then line (# + . between groups)
    r = size - (sum(new_group) + len(new_group)) - current_group + 1
    for i in range(r):
        # check for possible match
        if "." not in line[i : i + current_group]:
            if len(new_group) == 0:
                # if no new group and the rest of characters is . or ? add to count
                if all(c in ".?" for c in line[i + current_group]):
                    count += 1
            elif line[i + current_group] in ".?":
                count += faster(
                    line[i + current_group + 1 :],
                    size - current_group - i - 1,
                    new_group,
                )

        if line[i] not in ".?":
            break

    return count


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    puzzle_input = (puzzle_dir / "input.txt").read_text().strip()
    data = parse(puzzle_input)

    print(f"Part 1: {part1(data)}")
    print(f"Part 2: {part2(data)}")
