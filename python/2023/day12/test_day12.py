import pytest
import day12 as aoc


@pytest.fixture
def example1():
    puzzle_input = """???.### 1,1,3
.??..??...?##. 1,1,3
?#?#?#?#?#?#?#? 1,3,1,6
????.#...#... 4,1,1
????.######..#####. 1,6,5
?###???????? 3,2,1"""
    return aoc.parse(puzzle_input)


@pytest.fixture
def example2():
    puzzle_input = """?#??? 1
#.??#?#??. 1,3
????#????.?????##??? 2,5,1,1,2,1
???.### 1,1,3"""
    return aoc.parse(puzzle_input)


@pytest.mark.skip(reason="Not implemented")
def test_parse_example1(example1):
    """Test that input is parsed properly."""
    assert example1 == ...


def test_part1_example1(example1):
    """Test part 1 on example input."""
    assert aoc.part1(example1) == 21


@pytest.mark.skip(reason="Not implemented")
def test_part1_example2(example2):
    """Test part 1 on example input."""
    assert aoc.part1(example2) == 1


def test_part2_example1(example1):
    """Test part 2 on example input."""
    assert aoc.part2(example1) == 525152


@pytest.mark.skip(reason="Not implemented")
def test_part2_example2(example2):
    """Test part 2 on example input."""
    assert aoc.part2(example2) == ...
