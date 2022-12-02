package year21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Dec15Test {
    private final Dec15 dec15 = new Dec15();
    private final String testFilename = "test/test15.txt";
    private final String inputFilename = "input/input15.txt";

    @Test
    void testPart1()
    {
        dec15.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(40, dec15.part1());
    }

    @Test
    void testPart2() throws InterruptedException {
        dec15.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(315, dec15.part2());
    }

    @Test
    void testPart1Input()
    {
        dec15.updateLinesFromFilename(inputFilename);

        long answer = dec15.part1();
        System.out.println("Part1: " + answer);
        Assertions.assertEquals(361, answer);
    }

    @Test
    void testPart2Input() throws InterruptedException {
        dec15.updateLinesFromFilename(inputFilename);

        long answer = dec15.part2();
        System.out.println("Part2: " + answer);
        Assertions.assertEquals(2838, answer);
    }
}