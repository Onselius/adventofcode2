package year22;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.ReadFile;

import java.net.URL;
import java.util.List;

public class Dec01Test {
    private final Dec01 dec01 = new Dec01();

    @Test
    void testPart1()
    {
        URL url  = getClass().getResource("test/test01.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        dec01.setLines(lines);

        Assertions.assertEquals(24000, dec01.part1());
    }

    @Test
    void testPart2()
    {
        URL url  = getClass().getResource("test/test01.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        dec01.setLines(lines);

        Assertions.assertEquals(45000, dec01.part2());
    }

    @Test
    void testPart1Input()
    {
        URL url  = getClass().getResource("input/input01.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        dec01.setLines(lines);

        int part1 = dec01.part1();
        System.out.println("Part1: " + part1);
        Assertions.assertEquals(67027, part1);
    }

    @Test
    void testPart2Input()
    {
        URL url  = getClass().getResource("input/input01.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        dec01.setLines(lines);

        int part2 = dec01.part2();
        System.out.println("Part2: " + part2);
        Assertions.assertEquals(197291, part2);
    }
}
