package year22;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.ReadFile;

import java.net.URL;
import java.util.List;

public class Dec06Test {
    private final Dec06 base_class = new Dec06();

    @Test
    void testPart1_1()
    {
        URL url  = getClass().getResource("test/test06.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        lines = List.of(lines.get(0));
        base_class.setLines(lines);

        Assertions.assertEquals(7, base_class.part1());
    }
    @Test
    void testPart1_2()
    {
        URL url  = getClass().getResource("test/test06.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        lines = List.of(lines.get(1));
        base_class.setLines(lines);

        Assertions.assertEquals(5, base_class.part1());
    }
    @Test
    void testPart1_3()
    {
        URL url  = getClass().getResource("test/test06.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        lines = List.of(lines.get(2));
        base_class.setLines(lines);

        Assertions.assertEquals(6, base_class.part1());
    }
    @Test
    void testPart1_4()
    {
        URL url  = getClass().getResource("test/test06.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        lines = List.of(lines.get(3));
        base_class.setLines(lines);

        Assertions.assertEquals(10, base_class.part1());
    }
    @Test
    void testPart1_5()
    {
        URL url  = getClass().getResource("test/test06.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        lines = List.of(lines.get(4));
        base_class.setLines(lines);

        Assertions.assertEquals(11, base_class.part1());
    }

    @Test
    void testPart2()
    {
        URL url  = getClass().getResource("test/test06.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        base_class.setLines(lines);

        Assertions.assertEquals(0, base_class.part2());
    }

    @Test
    void testPart1Input()
    {
        URL url  = getClass().getResource("input/input06.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        base_class.setLines(lines);

        int part1 = base_class.part1();
        System.out.println("Part1: " + part1);
        Assertions.assertEquals(1080, part1);
    }

    @Test
    void testPart2Input()
    {
        URL url  = getClass().getResource("input/input06.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        base_class.setLines(lines);

        int part2 = base_class.part2();
        System.out.println("Part2: " + part2);
        Assertions.assertEquals(0, part2);
    }
}
