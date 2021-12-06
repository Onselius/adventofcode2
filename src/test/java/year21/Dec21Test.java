package year21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Dec21Test {
    private final Dec21 dec21 = new Dec21();
    private final String testFilename = "test/test21.txt";
    private final String inputFilename = "input/input21.txt";

    @Test
    void testPart1()
    {
        dec21.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(5, dec21.part1());
    }

    @Test
    void testPart2()
    {
        dec21.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(12, dec21.part2());
    }

    @Test
    void testPart1Input()
    {
        dec21.updateLinesFromFilename(inputFilename);

        long answer = dec21.part1();
        System.out.println("Part1: " + answer);
        Assertions.assertEquals(6461, answer);
    }

    @Test
    void testPart2Input()
    {
        dec21.updateLinesFromFilename(inputFilename);

        long answer = dec21.part2();
        System.out.println("Part2: " + answer);
        Assertions.assertEquals(18215, answer);
    }
}