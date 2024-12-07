import pytest
import day04 as aoc


@pytest.fixture
def example1():
    puzzle_input = """..X...
.SAMX.
.A..A.
XMAS.S
.X...."""
    return aoc.parse(puzzle_input)


@pytest.fixture
def example2():
    puzzle_input = """MMMSXXMASM
MSAMXMSMSA
AMXSXMAAMM
MSAMASMSMX
XMASAMXAMM
XXAMMXXAMA
SMSMSASXSS
SAXAMASAAA
MAMMMXMMMM
MXMXAXMASX"""
    return aoc.parse(puzzle_input)


def test_parse_example1(example1):
    """Test that input is parsed properly."""
    assert len(example1) == 100


def test_part1_example1(example1):
    """Test part 1 on example input."""
    assert aoc.part1(example1) == 4


def test_part1_example2(example2):
    """Test part 1 on example input."""
    assert aoc.part1(example2) == 18


@pytest.mark.skip(reason="Not implemented")
def test_part2_example1(example1):
    """Test part 2 on example input."""
    assert aoc.part2(example1) == ...


def test_part2_example2(example2):
    """Test part 2 on example input."""
    assert aoc.part2(example2) == 9


def test_part3_example2(example2):
    """Test part 2 on example input."""
    assert aoc.part3(example2) == 9
