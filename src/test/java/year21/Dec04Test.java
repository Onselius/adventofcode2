package year21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.ReadFile;

import java.net.URL;
import java.util.List;

class Dec04Test {
    private final Dec04 dec04 = new Dec04();

    @Test
    void testPart1()
    {
        URL url  = getClass().getResource("test/test04.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        dec04.setLines(lines);

        Assertions.assertEquals(4512, dec04.part1());
    }

    @Test
    void testPart2()
    {
        URL url  = getClass().getResource("test/test04.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        dec04.setLines(lines);

        Assertions.assertEquals(1924, dec04.part2());
    }

    @Test
    void testPart1Input()
    {
        URL url  = getClass().getResource("input/input04.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        dec04.setLines(lines);

        System.out.println("Part1: " + dec04.part1());
    }

    @Test
    void testPart2Input()
    {
        URL url  = getClass().getResource("input/input04.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        dec04.setLines(lines);

        System.out.println("Part2: " + dec04.part2());
    }
}