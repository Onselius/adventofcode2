package year21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Dec08Test {
    private final Dec08 dec08 = new Dec08();
    private final String testFilename = "test/test08.txt";
    private final String inputFilename = "input/input08.txt";

    @Test
    void testPart1()
    {
        dec08.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(26, dec08.part1());
    }

    @Test
    void testPart2()
    {
        dec08.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(61229, dec08.part2());
    }

    @Test
    void testPart2SmallSample()
    {
        dec08.updateLinesFromFilename(testFilename);
        dec08.setLines(List.of("acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cdfeb fcadb cdfeb cdbaf"));

        Assertions.assertEquals(5353, dec08.part2());
    }

    @Test
    void testPart1Input()
    {
        dec08.updateLinesFromFilename(inputFilename);

        long answer = dec08.part1();
        System.out.println("Part1: " + answer);
        Assertions.assertEquals(412, answer);
    }

    @Test
    void testPart2Input()
    {
        dec08.updateLinesFromFilename(inputFilename);

        long answer = dec08.part2();
        System.out.println("Part2: " + answer);
        Assertions.assertEquals(978171, answer);
    }
}