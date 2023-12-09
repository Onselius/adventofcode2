package year23;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.ReadFile;

import java.net.URL;
import java.util.List;

public class Dec08Test {
    private final Dec08 base_class = new Dec08();

    @Test
    void testPart1()
    {
        URL url  = getClass().getResource("test/test08.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        base_class.setLines(lines);

        Assertions.assertEquals(2, base_class.part1());
    }

    @Test
    void testPart1_2()
    {
        URL url  = getClass().getResource("test/test08_2.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        base_class.setLines(lines);

        Assertions.assertEquals(6, base_class.part1());
    }

    @Test
    void testPart2()
    {
        URL url  = getClass().getResource("test/test08_3.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        base_class.setLines(lines);

        Assertions.assertEquals(6, base_class.part2());
    }

    @Test
    void testPart1Input()
    {
        URL url  = getClass().getResource("input/input08.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        base_class.setLines(lines);

        int part1 = base_class.part1();
        System.out.println("Part1: " + part1);
        Assertions.assertEquals(19199, part1);
    }

    @Test
    void testPart2Input()
    {
        URL url  = getClass().getResource("input/input08.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        base_class.setLines(lines);

        long part2 = base_class.part2();
        System.out.println("Part2: " + part2);
        Assertions.assertEquals(13663968099527L, part2);
    }
}
