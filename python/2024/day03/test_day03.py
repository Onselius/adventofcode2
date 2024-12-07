import pytest
import day03 as aoc


@pytest.fixture
def example1():
    puzzle_input = (
        """xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"""
    )
    return aoc.parse(puzzle_input)


@pytest.fixture
def example2():
    puzzle_input = (
        """xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"""
    )
    return aoc.parse(puzzle_input)


def test_parse_example1(example1):
    """Test that input is parsed properly."""
    assert len(example1) == 4


def test_parse_example2(example2):
    """Test that input is parsed properly."""
    assert len(example2) == 6


def test_part1_example1(example1):
    """Test part 1 on example input."""
    assert aoc.part1(example1) == 161


def test_part2_example2(example2):
    """Test part 2 on example input."""
    assert aoc.part2(example2) == 48
