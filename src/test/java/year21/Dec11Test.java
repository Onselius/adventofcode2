package year21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Dec11Test {
    private final Dec11 dec11 = new Dec11();
    private final String testFilename = "test/test11.txt";
    private final String inputFilename = "input/input11.txt";

    @Test
    void test10Part1()
    {
        dec11.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(204, dec11.part1(10));
    }

    @Test
    void test100Part1()
    {
        dec11.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(1656, dec11.part1(100));
    }

    @Test
    void testPart2()
    {
        dec11.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(195, dec11.part2());
    }

    @Test
    void testPart1Input()
    {
        dec11.updateLinesFromFilename(inputFilename);

        long answer = dec11.part1(100);
        System.out.println("Part1: " + answer);
        Assertions.assertEquals(1735, answer);
    }

    @Test
    void testPart2Input()
    {
        dec11.updateLinesFromFilename(inputFilename);

        long answer = dec11.part2();
        System.out.println("Part2: " + answer);
        Assertions.assertEquals(400, answer);
    }
}