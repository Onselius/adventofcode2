import pytest
import day16 as aoc


@pytest.fixture
def example1():
    puzzle_input = """###############
#.......#....E#
#.#.###.#.###.#
#.....#.#...#.#
#.###.#####.#.#
#.#.#.......#.#
#.#.#####.###.#
#...........#.#
###.#.#####.#.#
#...#.....#.#.#
#.#.#.###.#.#.#
#.....#...#.#.#
#.###.#.#.#.#.#
#S..#.....#...#
###############"""
    return aoc.parse(puzzle_input)


@pytest.fixture
def example2():
    puzzle_input = """#################
#...#...#...#..E#
#.#.#.#.#.#.#.#.#
#.#.#.#...#...#.#
#.#.#.#.###.#.#.#
#...#.#.#.....#.#
#.#.#.#.#.#####.#
#.#...#.#.#.....#
#.#.#####.#.###.#
#.#.#.......#...#
#.#.###.#####.###
#.#.#...#.....#.#
#.#.#.#####.###.#
#.#.#.........#.#
#.#.#.#########.#
#S#.............#
#################"""
    return aoc.parse(puzzle_input)


@pytest.fixture
def example3():
    puzzle_input = """##########
#.......E#
#.##.#####
#..#.....#
##.#####.#
#S.......#
##########"""
    return aoc.parse(puzzle_input)


@pytest.fixture
def example4():
    puzzle_input = """###########################
#######################..E#
######################..#.#
#####################..##.#
####################..###.#
###################..##...#
##################..###.###
#################..####...#
################..#######.#
###############..##.......#
##############..###.#######
#############..####.......#
############..###########.#
###########..##...........#
##########..###.###########
#########..####...........#
########..###############.#
#######..##...............#
######..###.###############
#####..####...............#
####..###################.#
###..##...................#
##..###.###################
#..####...................#
#.#######################.#
#S........................#
###########################"""
    return aoc.parse(puzzle_input)


@pytest.mark.skip(reason="Not implemented")
def test_parse_example1(example1):
    """Test that input is parsed properly."""
    assert example1 == ...


def test_part1_example1(example1):
    """Test part 1 on example input."""
    s, e, g = example1
    assert aoc.part1(s, e, g) == 7036


def test_part1_example2(example2):
    """Test part 1 on example input."""
    s, e, g = example2
    assert aoc.part1(s, e, g) == 11048


def test_part1_example4(example4):
    """Test part 1 on example input."""
    s, e, g = example4
    assert aoc.part1(s, e, g) == 21148


def test_part1_example3(example3):
    """Test part 1 on example input."""
    s, e, g = example3
    assert aoc.part1(s, e, g) == 4013


def test_part2_example1(example1):
    """Test part 2 on example input."""
    s, e, g = example1
    assert aoc.part2(s, e, g) == 45


@pytest.mark.skip(reason="Not implemented")
def test_part2_example2(example2):
    """Test part 2 on example input."""
    assert aoc.part2(example2) == 64
