import pathlib
import math
from copy import deepcopy


def parse(puzzle_input) -> list[str]:
    """Parse input."""
    return puzzle_input


def parse_rules(config):
    converter = "xmas"
    rules = {}

    for line in config.splitlines():
        name, _rule = line.split("{")
        _list = []
        _rule = _rule[:-1]
        for r in _rule.split(","):
            if ":" in r:
                symbol = converter.find(r[0])
                comp = r[1]
                value, target = r[2:].split(":")
                _list.append((symbol, comp, int(value), target))
            else:
                _list.append((r))
        rules[name] = _list
    return rules


def part1(data: list[str]):
    """Solve part 1."""
    _config, _input = data.split("\n\n")
    rules = parse_rules(_config)

    accepted = []
    rejected = []
    for _in in _input.splitlines():
        _in = _in[1:-1].split(",")
        value = tuple([int(v[2:]) for v in _in])
        result = get_result(value, rules, "in")
        if result == "A":
            accepted.append(value)
        else:
            rejected.append(value)

    return sum(sum(t) for t in accepted)


def get_result(value: tuple, rules: dict, rule: list):
    if rule in "AR":
        return rule
    rule = rules[rule]
    for r in rule:
        if type(r) == str:
            return get_result(value, rules, r)
        if r[1] == "<":
            if value[r[0]] < r[2]:
                return get_result(value, rules, r[3])
        else:
            if value[r[0]] > r[2]:
                return get_result(value, rules, r[3])

    return "R"


def part2(data: list[str]):
    """Solve part 2."""
    _config, _input = data.split("\n\n")
    rules = parse_rules(_config)

    count = count_correct(rules, "in", [[0, 4001], [0, 4001], [0, 4001], [0, 4001]])

    return count


def count_correct(rules: dict, key: str, correct: list):
    rule = rules[key]
    accepted = 0

    for r in rule:
        if type(r) == str:
            if r == "A":
                return accepted + calculate_range(correct)
            elif r == "R":
                return accepted
            else:
                return accepted + count_correct(rules, r, deepcopy(correct))
        else:
            i, comp, v, target = r
            if target == "A":
                # check new range, add prod() to accepted
                if comp == ">":
                    new_range = check_in(v, correct[i], True)
                else:
                    new_range = check_in(v, correct[i], False)
                correct[i] = new_range[0]
                accepted += calculate_range(correct)
                correct[i] = new_range[1]
            elif target == "R":
                # check new range, add prod() to accepted
                if comp == ">":
                    new_range = check_in(v, correct[i], True)
                else:
                    new_range = check_in(v, correct[i], False)
                correct[i] = new_range[1]
            else:
                if comp == ">":
                    new_range = check_in(v, correct[i], True)
                else:
                    new_range = check_in(v, correct[i], False)
                correct[i] = new_range[0]
                accepted += count_correct(rules, target, deepcopy(correct))
                correct[i] = new_range[1]

    return accepted


def calculate_range(correct: list):
    t = 1
    for v in correct:
        value = v[1] - v[0] - 1
        if value < 0:
            return 0
        t *= value
    return t


def check_in(v: int, _range: list, higher: bool):
    new_range = [[], []]
    if _range[0] < v < _range[1]:
        if higher:
            new_range[0] = [v, _range[1]]
            new_range[1] = [_range[0], v + 1]
        else:
            new_range[0] = [_range[0], v]
            new_range[1] = [v - 1, _range[1]]
    else:
        [[1, 1], [1, 1]]

    return new_range


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    puzzle_input = (puzzle_dir / "input.txt").read_text().strip()
    data = parse(puzzle_input)

    print(f"Part 1: {part1(data)}")
    print(f"Part 2: {part2(data)}")
