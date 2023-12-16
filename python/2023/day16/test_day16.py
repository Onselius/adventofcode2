import pytest
import day16 as aoc


@pytest.fixture
def example1():
    puzzle_input = r""".|...\....
|.-.\.....
.....|-...
........|.
..........
.........\
..../.\\..
.-.-/..|..
.|....-|.\
..//.|...."""
    return aoc.parse(puzzle_input)


@pytest.fixture
def example2():
    puzzle_input = """   """
    return aoc.parse(puzzle_input)


def test_parse_example1(example1):
    """Test that input is parsed properly."""
    assert example1 == ...


def test_part1_example1(example1):
    """Test part 1 on example input."""
    assert aoc.part1(example1) == 46


def test_part2_example1(example1):
    """Test part 2 on example input."""
    assert aoc.part2(example1) == 51


def test_part2_example2(example2):
    """Test part 2 on example input."""
    assert aoc.part2(example2) == ...