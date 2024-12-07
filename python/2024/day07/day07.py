import pathlib


def parse(puzzle_input) -> list[str]:
    """Parse input."""
    return puzzle_input.split("\n")


def part1(data: list[str]):
    """Solve part 1."""
    answer = 0
    for line in data:
        sum, numbers = line.split(": ")
        sum = int(sum)
        numbers = [int(x) for x in numbers.split()]
        # print(f"sum {sum} numbers {numbers}")
        if check_double(sum, numbers, numbers.pop(0)):
            answer += sum
    return answer


def check_double(sum: int, numbers: list[int], current_sum: int):
    possible_operators = ["+", "*"]
    if current_sum > sum:
        return False
    if len(numbers) == 0:
        return sum == current_sum
    number = numbers.pop(0)
    if check_double(sum, numbers.copy(), (current_sum + number)):
        return True
    if check_double(sum, numbers.copy(), (current_sum * number)):
        return True
    return False


def part2(data: list[str]):
    """Solve part 2."""
    answer = 0
    for line in data:
        sum, numbers = line.split(": ")
        sum = int(sum)
        numbers = [int(x) for x in numbers.split()]
        # print(f"sum {sum} numbers {numbers}")
        if check_triple(sum, numbers, numbers.pop(0)):
            answer += sum
    return answer


def check_triple(sum: int, numbers: list[int], current_sum: int):
    possible_operators = ["+", "*", "||"]
    if current_sum > sum:
        return False
    if len(numbers) == 0:
        return sum == current_sum
    number = numbers.pop(0)
    if check_triple(sum, numbers.copy(), (current_sum + number)):
        return True
    if check_triple(sum, numbers.copy(), (current_sum * number)):
        return True
    if check_triple(sum, numbers.copy(), int(str(current_sum) + str(number))):
        return True
    return False


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    puzzle_input = (puzzle_dir / "input.txt").read_text().strip()
    data = parse(puzzle_input)

    print(f"Part 1: {part1(data)}")
    print(f"Part 2: {part2(data)}")
