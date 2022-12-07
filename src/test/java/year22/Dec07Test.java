package year22;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.ReadFile;

import java.net.URL;
import java.util.List;

public class Dec07Test {
    private final Dec07 base_class = new Dec07();

    @Test
    void testPart1()
    {
        URL url  = getClass().getResource("test/test07.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        base_class.setLines(lines);

        Assertions.assertEquals(95437, base_class.part1());
    }

    @Test
    void testPart2()
    {
        URL url  = getClass().getResource("test/test07.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        base_class.setLines(lines);

        Assertions.assertEquals(24933642, base_class.part2());
    }

    @Test
    void testPart1Input()
    {
        URL url  = getClass().getResource("input/input07.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        base_class.setLines(lines);

        long part1 = base_class.part1();
        System.out.println("Part1: " + part1);
        Assertions.assertEquals(1783610, part1);
    }

    @Test
    void testPart2Input()
    {
        URL url  = getClass().getResource("input/input07.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        base_class.setLines(lines);

        long part2 = base_class.part2();
        System.out.println("Part2: " + part2);
        Assertions.assertEquals(4370655, part2);
    }
}
