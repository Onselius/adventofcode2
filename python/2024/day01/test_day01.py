import pytest
import day01 as aoc


@pytest.fixture
def example1():
    puzzle_input = """3   4
4   3
2   5
1   3
3   9
3   3"""
    return aoc.parse(puzzle_input)


@pytest.fixture
def example2():
    puzzle_input = """   """
    return aoc.parse(puzzle_input)


@pytest.mark.skip(reason="Not implemented")
def test_parse_example1(example1):
    """Test that input is parsed properly."""
    assert example1 == ...


def test_part1_example1(example1):
    """Test part 1 on example input."""
    puzzle_input = """3   4
4   3
2   5
1   3
3   9
3   3"""
    first, second = aoc.parse(puzzle_input)
    assert aoc.part1(first, second) == 11


def test_part2_example1(example1):
    """Test part 2 on example input."""
    puzzle_input = """3   4
4   3
2   5
1   3
3   9
3   3"""
    first, second = aoc.parse(puzzle_input)
    assert aoc.part2(first, second) == 31


@pytest.mark.skip(reason="Not implemented")
def test_part2_example2(example2):
    """Test part 2 on example input."""
    assert aoc.part2(example2) == ...
