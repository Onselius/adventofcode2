import pytest
import day01 as aoc


@pytest.fixture
def example1():
    puzzle_input = """1abc2
pqr3stu8vwx
a1b2c3d4e5f
treb7uchet"""
    return aoc.parse(puzzle_input)


@pytest.fixture
def example2():
    puzzle_input = """two1nine
eightwothree
abcone2threexyz
xtwone3four
4nineeightseven2
zoneight234
7pqrstsixteen"""
    return aoc.parse(puzzle_input)


def test_parse_example1(example1):
    """Test that input is parsed properly."""
    assert len(example1) == 4


def test_part1_example1(example1):
    """Test part 1 on example input."""
    assert aoc.part1(example1) == 142


@pytest.mark.skip(reason="Not implemented")
def test_part2_example1(example1):
    """Test part 2 on example input."""
    assert aoc.part2(example1) == ...


def test_part2_example2(example2):
    """Test part 2 on example input."""
    assert aoc.part2(example2) == 281
