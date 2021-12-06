package year21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Dec05Test {
    private final Dec05 dec05 = new Dec05();
    private final String testFilename = "test/test05.txt";
    private final String inputFilename = "input/input05.txt";

    @Test
    void testPart1()
    {
        dec05.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(5, dec05.part1());
    }

    @Test
    void testPart2()
    {
        dec05.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(12, dec05.part2());
    }

    @Test
    void testPart1Input()
    {
        dec05.updateLinesFromFilename(inputFilename);

        long answer = dec05.part1();
        System.out.println("Part1: " + answer);
        Assertions.assertEquals(6461, answer);
    }

    @Test
    void testPart2Input()
    {
        dec05.updateLinesFromFilename(inputFilename);

        long answer = dec05.part2();
        System.out.println("Part2: " + answer);
        Assertions.assertEquals(18065, answer);
    }
}