package year21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Dec20Test {
    private final Dec20 dec20 = new Dec20();
    private final String testFilename = "test/test20.txt";
    private final String inputFilename = "input/input20.txt";

    @Test
    void testPart1()
    {
        dec20.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(5, dec20.part1());
    }

    @Test
    void testPart2()
    {
        dec20.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(12, dec20.part2());
    }

    @Test
    void testPart1Input()
    {
        dec20.updateLinesFromFilename(inputFilename);

        long answer = dec20.part1();
        System.out.println("Part1: " + answer);
        Assertions.assertEquals(6461, answer);
    }

    @Test
    void testPart2Input()
    {
        dec20.updateLinesFromFilename(inputFilename);

        long answer = dec20.part2();
        System.out.println("Part2: " + answer);
        Assertions.assertEquals(18205, answer);
    }
}