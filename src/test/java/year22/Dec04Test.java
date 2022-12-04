package year22;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.ReadFile;

import java.net.URL;
import java.util.List;

public class Dec04Test {
    private final Dec04 base_class = new Dec04();

    @Test
    void testPart1()
    {
        URL url  = getClass().getResource("test/test04.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        base_class.setLines(lines);

        Assertions.assertEquals(2, base_class.part1());
    }

    @Test
    void testPart2()
    {
        URL url  = getClass().getResource("test/test04.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        base_class.setLines(lines);

        Assertions.assertEquals(4, base_class.part2());
    }

    @Test
    void testPart1Input()
    {
        URL url  = getClass().getResource("input/input04.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        base_class.setLines(lines);

        int part1 = base_class.part1();
        System.out.println("Part1: " + part1);
        Assertions.assertEquals(576, part1);
    }

    @Test
    void testPart2Input()
    {
        URL url  = getClass().getResource("input/input04.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        base_class.setLines(lines);

        int part2 = base_class.part2();
        System.out.println("Part2: " + part2);
        Assertions.assertEquals(905, part2);
        // too low
    }
}
