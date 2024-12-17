import pytest
import day10 as aoc


@pytest.fixture
def example1():
    puzzle_input = """89010123
78121874
87430965
96549874
45678903
32019012
01329801
10456732"""
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
    assert aoc.part1(example1) == 36


def test_part2_example1(example1):
    """Test part 2 on example input."""
    assert aoc.part2(example1) == 81


@pytest.mark.skip(reason="Not implemented")
def test_part2_example2(example2):
    """Test part 2 on example input."""
    assert aoc.part2(example2) == ...
