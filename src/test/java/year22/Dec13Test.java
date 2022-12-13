package year22;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.ReadFile;

import java.net.URL;
import java.util.List;

public class Dec13Test {
    private final Dec13 base_class = new Dec13();

    @Test
    void testPart1() throws ParseException
    {
        URL url  = getClass().getResource("test/test13.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        base_class.setLines(lines);

        Assertions.assertEquals(13, base_class.part1());
    }

    @Test
    void testPart2()
    {
        URL url  = getClass().getResource("test/test13.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        base_class.setLines(lines);

        Assertions.assertEquals(0, base_class.part2());
    }

    @Test
    void testPart1Input() throws ParseException
    {
        URL url  = getClass().getResource("input/input13.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        base_class.setLines(lines);

        int part1 = base_class.part1();
        System.out.println("Part1: " + part1);
        Assertions.assertEquals(0, part1);
        // 690 too low
        // 6520 too high
        // 3595 too low
        // 6223 wrong
        // 6382 wrong
    }

    @Test
    void testPart2Input()
    {
        URL url  = getClass().getResource("input/input13.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        base_class.setLines(lines);

        int part2 = base_class.part2();
        System.out.println("Part2: " + part2);
        Assertions.assertEquals(0, part2);
    }
}
