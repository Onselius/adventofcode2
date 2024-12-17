import pytest
import day09 as aoc


@pytest.fixture
def example1():
    puzzle_input = """2333133121414131402"""
    return aoc.parse(puzzle_input)


@pytest.fixture
def example2():
    puzzle_input = """233313312141413140211"""
    return aoc.parse(puzzle_input)


@pytest.mark.skip(reason="Not implemented")
def test_parse_example1(example1):
    """Test that input is parsed properly."""
    assert example1 == ...


def test_part1_example1(example1):
    """Test part 1 on example input."""
    assert aoc.part1(example1) == 1928


def test_part1_example2(example2):
    """Test part 1 on example input."""
    assert aoc.part1(example2) == 2132


def test_part2_example1(example1):
    """Test part 2 on example input."""
    assert aoc.part2(example1) == 2858


# @pytest.mark.skip(reason="Not implemented")
def test_part2_example2(example2):
    """Test part 2 on example input."""
    assert aoc.part2(example2) == 2132
