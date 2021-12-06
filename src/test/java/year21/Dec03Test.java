package year21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.ReadFile;

import java.net.URL;
import java.util.List;

class Dec03Test {
    private final Dec03 dec03 = new Dec03();

    @Test
    void testPart1()
    {
        URL url  = getClass().getResource("test/test03.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        dec03.setLines(lines);

        Assertions.assertEquals(198, dec03.part1());
    }

    @Test
    void testPart2()
    {
        URL url  = getClass().getResource("test/test03.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        dec03.setLines(lines);

        Assertions.assertEquals(230, dec03.part2());
    }

    @Test
    void testPart1Input()
    {
        URL url  = getClass().getResource("input/input03.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        dec03.setLines(lines);

        System.out.println("Part1: " + dec03.part1());
    }

    @Test
    void testPart2Input()
    {
        URL url  = getClass().getResource("input/input03.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        dec03.setLines(lines);

        System.out.println("Part2: " + dec03.part2());
    }
}