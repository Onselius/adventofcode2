package year21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Dec16Test {
    private final Dec16 dec16 = new Dec16();
    private final String testFilename = "test/test16.txt";
    private final String inputFilename = "input/input16.txt";

    @Test
    void testPart1Index0()
    {
        dec16.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(6, dec16.part1(0));
    }

    @Test
    void testPart1Index0ToBinary()
    {
        dec16.updateLinesFromFilename(testFilename);

        Assertions.assertEquals("110100101111111000101000", dec16.convertHexToBinary("D2FE28"));
    }

    @Test
    void testPart1Index0Version()
    {
        dec16.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(6, dec16.getVersion("110100101111111000101000"));
    }

    @Test
    void testPart1Index0Type()
    {
        dec16.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(4, dec16.getType("110100101111111000101000"));
    }

    @Test
    void testPart1Index0LiteralValue()
    {
        dec16.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(2021, dec16.parseLiteralValue("110100101111111000101000").get(1));
    }

    @Test
    void testPart1Index0OperationValue15()
    {
        dec16.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(30, dec16.parseOperatorValue("00111000000000000110111101000101001010010001001000000000").get(1));
    }

    @Test
    void testPart1Index0OperationValue11()
    {
        dec16.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(6, dec16.parseOperatorValue("11101110000000001101010000001100100000100011000001100000").get(1));
    }


    @Test
    void testPart1Index1()
    {
        dec16.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(9, dec16.part1(1));
    }

    @Test
    void testPart1Index2()
    {
        dec16.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(14, dec16.part1(2));
    }

    @Test
    void testPart1Index3()
    {
        dec16.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(16, dec16.part1(3));
    }

    @Test
    void testPart1Index4()
    {
        dec16.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(12, dec16.part1(4));
    }

    @Test
    void testPart1Index5()
    {
        dec16.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(23, dec16.part1(5));
    }

    @Test
    void testPart1Index6()
    {
        dec16.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(31, dec16.part1(6));
    }

    @Test
    void testPart2Index8()
    {
        dec16.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(3, dec16.part2(8));
    }

    @Test
    void testPart2Index9()
    {
        dec16.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(54, dec16.part2(9));
    }

    @Test
    void testPart2Index10()
    {
        dec16.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(7, dec16.part2(10));
    }

    @Test
    void testPart2Index11()
    {
        dec16.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(9, dec16.part2(11));
    }

    @Test
    void testPart2Index12()
    {
        dec16.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(1, dec16.part2(12));
    }

    @Test
    void testPart2Index13()
    {
        dec16.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(0, dec16.part2(13));
    }

    @Test
    void testPart2Index14()
    {
        dec16.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(0, dec16.part2(14));
    }

    @Test
    void testPart2Index15()
    {
        dec16.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(1, dec16.part2(15));
    }

    @Test
    void testPart1Input()
    {
        dec16.updateLinesFromFilename(inputFilename);

        long answer = dec16.part1(0);
        System.out.println("Part1: " + answer);
        Assertions.assertEquals(893, answer);
    }

    @Test
    void testPart2Input()
    {
        dec16.updateLinesFromFilename(inputFilename);

        long answer = dec16.part2(0);
        System.out.println("Part2: " + answer);
        Assertions.assertEquals(4358595186090L, answer);
    }
}