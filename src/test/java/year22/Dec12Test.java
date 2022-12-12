package year22;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.ReadFile;

import java.net.URL;
import java.util.List;

public class Dec12Test {
    private final Dec12 base_class = new Dec12();

    @Test
    void testPart1()
    {
        URL url  = getClass().getResource("test/test12.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        base_class.setLines(lines);

        Assertions.assertEquals(31, base_class.part1());
    }
    @Test
    void testPart1_2()
    {
        URL url  = getClass().getResource("test/test12_2.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        base_class.setLines(lines);

        Assertions.assertEquals(27, base_class.part1());
    }
    @Test
    void testPart1_3()
    {
        URL url  = getClass().getResource("test/test12_3.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        base_class.setLines(lines);

        Assertions.assertEquals(33, base_class.part1());
    }

    @Test
    void testPart2()
    {
        URL url  = getClass().getResource("test/test12.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        base_class.setLines(lines);

        Assertions.assertEquals(29, base_class.part2());
    }

    @Test
    void testPart1Input() throws InterruptedException
    {
        URL url  = getClass().getResource("input/input12.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        base_class.setLines(lines);

        int part1 = base_class.part1();
        System.out.println("Part1: " + part1);
        Assertions.assertEquals(425, part1);
        // 455 too high
        // 447 too high
    }

    @Test
    void testPart2Input()
    {
        URL url  = getClass().getResource("input/input12.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        base_class.setLines(lines);

        int part2 = base_class.part2();
        System.out.println("Part2: " + part2);
        Assertions.assertEquals(418, part2);
    }
}
