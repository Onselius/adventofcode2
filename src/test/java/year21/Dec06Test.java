package year21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Dec06Test {
    private final Dec06 dec06 = new Dec06();
    private final String testFilename = "test/test06.txt";
    private final String inputFilename = "input/input06.txt";

    @Test
    void testPart1()
    {
        dec06.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(26, dec06.part1(18));
    }

    @Test
    void test2Part1()
    {
        dec06.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(5934, dec06.part1(80));
    }

    @Test
    void testPart2()
    {
        dec06.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(26984457539L, dec06.part2(256));
    }

    @Test
    void testPart1Input()
    {
        dec06.updateLinesFromFilename(inputFilename);

        long answer = dec06.part1(80);
        System.out.println("Part1: " + answer);
        Assertions.assertEquals(390011, answer);
    }

    @Test
    void testPart2Input()
    {
        dec06.updateLinesFromFilename(inputFilename);

        long answer = dec06.part2(256);
        System.out.println("Part2: " + answer);
        Assertions.assertEquals(1746710169834L, answer);
    }
}