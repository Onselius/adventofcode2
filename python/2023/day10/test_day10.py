import pytest
import day10 as aoc


@pytest.fixture
def example1():
    puzzle_input = """.....
.S-7.
.|.|.
.L-J.
....."""
    return aoc.parse(puzzle_input)


@pytest.fixture
def example2():
    puzzle_input = """.F----7F7F7F7F-7....
.|F--7||||||||FJ....
.||.FJ||||||||L7....
FJL7L7LJLJ||LJ.L-7..
L--J.L7...LJS7F-7L7.
....F-J..F7FJ|L7L7L7
....L7.F7||L7|.L7L7|
.....|FJLJ|FJ|F7|.LJ
....FJL-7.||.||||...
....L---J.LJ.LJLJ..."""
    return puzzle_input


@pytest.fixture
def example3():
    puzzle_input = """FF7FSF7F7F7F7F7F---7
L|LJ||||||||||||F--J
FL-7LJLJ||||||LJL-77
F--JF--7||LJLJ7F7FJ-
L---JF-JLJ.||-FJLJJ7
|F|F-JF---7F7-L7L|7|
|FFJF7L7F-JF7|JL---7
7-L-JL7||F7|L7F-7F7|
L.L7LFJ|||||FJL7||LJ
L7JLJL-JLJLJL--JLJ.L"""
    return puzzle_input


def test_part1_example1(example1):
    """Test part 1 on example input."""
    assert aoc.part1(example1[0], example1[1]) == 4


@pytest.mark.skip(reason="Not implemented")
def test_part2_example1(example1):
    """Test part 2 on example input."""
    assert aoc.part2(example1) == ...


def test_part2_example2(example2):
    """Test part 2 on example input."""
    assert aoc.part2(example2) == 8


def test_part2_example3(example3):
    """Test part 2 on example input."""
    assert aoc.part2(example3) == 10
