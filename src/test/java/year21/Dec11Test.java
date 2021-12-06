package year21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Dec11Test {
    private final Dec11 dec11 = new Dec11();
    private final String testFilename = "test/test11.txt";
    private final String inputFilename = "input/input11.txt";

    @Test
    void testPart1()
    {
        dec11.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(5, dec11.part1());
    }

    @Test
    void testPart2()
    {
        dec11.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(12, dec11.part2());
    }

    @Test
    void testPart1Input()
    {
        dec11.updateLinesFromFilename(inputFilename);

        long answer = dec11.part1();
        System.out.println("Part1: " + answer);
        Assertions.assertEquals(6461, answer);
    }

    @Test
    void testPart2Input()
    {
        dec11.updateLinesFromFilename(inputFilename);

        long answer = dec11.part2();
        System.out.println("Part2: " + answer);
        Assertions.assertEquals(18115, answer);
    }
}