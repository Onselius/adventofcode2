import pytest
import day11 as aoc


@pytest.fixture
def example1():
    puzzle_input = """...#......
.......#..
#.........
..........
......#...
.#........
.........#
..........
.......#..
#...#....."""
    return puzzle_input


@pytest.fixture
def example2():
    puzzle_input = """   """
    return puzzle_input


@pytest.mark.skip(reason="Not implemented")
def test_parse_example1(example1):
    """Test that input is parsed properly."""
    maxX: int = max(x for y, x in example1[1].keys())
    maxY: int = max(y for y, x in example1[1].keys())
    assert maxX == 12
    assert maxY == 11


def test_part1_example1(example1):
    """Test part 1 on example input."""
    assert aoc.part1(example1, 1) == 374


def test_part1_10_example1(example1):
    """Test part 2 on example input."""
    assert aoc.part1(example1, 10) == 1030


def test_part1_100_example1(example1):
    """Test part 2 on example input."""
    assert aoc.part1(example1, 100) == 8410
