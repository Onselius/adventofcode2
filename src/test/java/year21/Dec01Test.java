package year21;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.ReadFile;

import java.net.URL;
import java.util.List;

class Dec01Test {

    private final Dec01 dec01 = new Dec01();

    @Test
    void testPart1()
    {
        URL url  = getClass().getResource("test/test01.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        dec01.setLines(ReadFile.convertToInteger(lines));

        Assertions.assertEquals(7, dec01.part1());
    }

    @Test
    void testPart2()
    {
        URL url  = getClass().getResource("test/test01.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        dec01.setLines(ReadFile.convertToInteger(lines));

        Assertions.assertEquals(5, dec01.part2());
    }

    @Test
    void testPart1Input()
    {
        URL url  = getClass().getResource("input/input01.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        dec01.setLines(ReadFile.convertToInteger(lines));

        System.out.println("Part1: " + dec01.part1());
    }

    @Test
    void testPart2Input()
    {
        URL url  = getClass().getResource("input/input01.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        dec01.setLines(ReadFile.convertToInteger(lines));

        System.out.println("Part2: " + dec01.part2());
    }
}