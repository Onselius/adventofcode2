import pytest
import day12 as aoc


@pytest.fixture
def example1():
    puzzle_input = """AAAA
BBCD
BBCC
EEEC"""
    return aoc.parse(puzzle_input)


@pytest.fixture
def example2():
    puzzle_input = """RRRRIICCFF
RRRRIICCCF
VVRRRCCFFF
VVRCCCJFFF
VVVVCJJCFE
VVIVCCJJEE
VVIIICJJEE
MIIIIIJJEE
MIIISIJEEE
MMMISSJEEE"""
    return aoc.parse(puzzle_input)


@pytest.fixture
def example3():
    puzzle_input = """AAAAAA
AAABBA
AAABBA
ABBAAA
ABBAAA
AAAAAA"""
    return aoc.parse(puzzle_input)


@pytest.mark.skip(reason="Not implemented")
def test_parse_example1(example1):
    """Test that input is parsed properly."""
    assert example1 == ...


def test_part1_example1(example1):
    """Test part 1 on example input."""
    assert aoc.part1(example1) == 140


def test_part1_example2(example2):
    """Test part 1 on example input."""
    assert aoc.part1(example2) == 1930


def test_part2_example1(example1):
    """Test part 2 on example input."""
    assert aoc.part2(example1) == 80


@pytest.mark.skip(reason="Not implemented")
def test_part2_example2(example2):
    """Test part 2 on example input."""
    assert aoc.part2(example2) == ...


def test_part2_example3(example3):
    """Test part 2 on example input."""
    assert aoc.part2(example3) == 368
