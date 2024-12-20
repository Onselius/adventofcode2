import pytest
import day20 as aoc


@pytest.fixture
def example1():
    puzzle_input = """broadcaster -> a, b, c
%a -> b
%b -> c
%c -> inv
&inv -> a"""
    return aoc.parse(puzzle_input)


@pytest.fixture
def example2():
    puzzle_input = """broadcaster -> a
%a -> inv, con
&inv -> b
%b -> con
&con -> output"""
    return aoc.parse(puzzle_input)


@pytest.mark.skip(reason="Not implemented")
def test_parse_example1(example1):
    """Test that input is parsed properly."""
    assert example1 == ...


def test_part1_example1(example1):
    """Test part 1 on example input."""
    assert aoc.part1(example1) == 32000000


def test_part1_example2(example2):
    """Test part 1 on example input."""
    assert aoc.part1(example2) == 11687500


@pytest.mark.skip(reason="Not implemented")
def test_part2_example1(example1):
    """Test part 2 on example input."""
    assert aoc.part2(example1) == ...


@pytest.mark.skip(reason="Not implemented")
def test_part2_example2(example2):
    """Test part 2 on example input."""
    assert aoc.part2(example2) == ...
