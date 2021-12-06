package year21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.ReadFile;

import java.net.URL;
import java.util.List;

class Dec02Test {

    private final Dec02 dec02 = new Dec02();

    @Test
    void testPart1()
    {
        URL url  = getClass().getResource("test/test02.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        dec02.setLines(lines);

        Assertions.assertEquals(150, dec02.part1());
    }

    @Test
    void testPart2()
    {
        URL url  = getClass().getResource("test/test02.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        dec02.setLines(lines);

        Assertions.assertEquals(901, dec02.part2());
    }

    @Test
    void testPart1Input()
    {
        URL url  = getClass().getResource("input/input02.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        dec02.setLines(lines);

        System.out.println("Part1: " + dec02.part1());
    }

    @Test
    void testPart2Input()
    {
        URL url  = getClass().getResource("input/input02.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        dec02.setLines(lines);

        System.out.println("Part2: " + dec02.part2());
    }
}