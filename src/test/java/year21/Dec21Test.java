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

        Assertions.assertEquals(739785, dec21.part1(1000));
    }

    @Test
    void testPart2()
    {
        dec21.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(444356092776315L, dec21.part2(21));
    }

    @Test
    void testPart1Input()
    {
        dec21.updateLinesFromFilename(inputFilename);

        long answer = dec21.part1(1000);
        System.out.println("Part1: " + answer);
        Assertions.assertEquals(707784, answer);
    }

    @Test
    void testPart2Input()
    {
        dec21.updateLinesFromFilename(inputFilename);

        long answer = dec21.part2(21);
        System.out.println("Part2: " + answer);
        Assertions.assertEquals(157595953724471L, answer);
        // 1438780197958127
        // 464361514923
    }
}