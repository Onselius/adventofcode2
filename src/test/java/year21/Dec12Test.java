package year21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Dec12Test {
    private Dec12 dec12;
    private final String testFilename = "test/test12.txt";
    private final String testFilenameBig = "test/test12big.txt";
    private final String inputFilename = "input/input12.txt";

    @BeforeEach
    private void setUp()
    {
        dec12 = new Dec12();
    }

    @Test
    void testPart1()
    {
        dec12.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(10, dec12.part1());
    }

    @Test
    void testPart1Big()
    {
        dec12.updateLinesFromFilename(testFilenameBig);

        Assertions.assertEquals(226, dec12.part1());
    }

    @Test
    void testPart2()
    {
        dec12.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(36, dec12.part2());
    }

    @Test
    void testPart2Big()
    {
        dec12.updateLinesFromFilename(testFilenameBig);

        Assertions.assertEquals(3509, dec12.part2());
    }

    @Test
    void testPart1Input()
    {
        dec12.updateLinesFromFilename(inputFilename);

        long answer = dec12.part1();
        System.out.println("Part1: " + answer);
        Assertions.assertEquals(4659, answer);
    }

    @Test
    void testPart2Input()
    {
        dec12.updateLinesFromFilename(inputFilename);

        long answer = dec12.part2();
        System.out.println("Part2: " + answer);
        Assertions.assertEquals(148962, answer);
    }
}