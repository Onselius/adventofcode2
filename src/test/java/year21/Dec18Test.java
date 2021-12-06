package year21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Dec18Test {
    private final Dec18 dec18 = new Dec18();
    private final String testFilename = "test/test18.txt";
    private final String inputFilename = "input/input18.txt";

    @Test
    void testPart1()
    {
        dec18.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(5, dec18.part1());
    }

    @Test
    void testPart2()
    {
        dec18.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(12, dec18.part2());
    }

    @Test
    void testPart1Input()
    {
        dec18.updateLinesFromFilename(inputFilename);

        long answer = dec18.part1();
        System.out.println("Part1: " + answer);
        Assertions.assertEquals(6461, answer);
    }

    @Test
    void testPart2Input()
    {
        dec18.updateLinesFromFilename(inputFilename);

        long answer = dec18.part2();
        System.out.println("Part2: " + answer);
        Assertions.assertEquals(18185, answer);
    }
}