package year21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Dec22Test {
    private final Dec22 dec22 = new Dec22();
    private final String testFilename = "test/test22.txt";
    private final String inputFilename = "input/input01.txt";

    @Test
    void testPart1()
    {
        dec22.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(5, dec22.part1());
    }

    @Test
    void testPart2()
    {
        dec22.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(12, dec22.part2());
    }

    @Test
    void testPart1Input()
    {
        dec22.updateLinesFromFilename(inputFilename);

        long answer = dec22.part1();
        System.out.println("Part1: " + answer);
        Assertions.assertEquals(6461, answer);
    }

    @Test
    void testPart2Input()
    {
        dec22.updateLinesFromFilename(inputFilename);

        long answer = dec22.part2();
        System.out.println("Part2: " + answer);
        Assertions.assertEquals(18225, answer);
    }
}