import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.ReadFile;

import java.net.URL;
import java.util.List;

public class BaseTest {
    private final Base base_class = new Base();

    @Test
    void testPart1()
    {
        URL url  = getClass().getResource("test/test_file.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        base_class.setLines(lines);

        Assertions.assertEquals(0, base_class.part1());
    }

    @Test
    void testPart2()
    {
        URL url  = getClass().getResource("test/test_file.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        base_class.setLines(lines);

        Assertions.assertEquals(0, base_class.part2());
    }

    @Test
    void testPart1Input()
    {
        URL url  = getClass().getResource("input/input_file.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        base_class.setLines(lines);

        int part1 = base_class.part1();
        System.out.println("Part1: " + part1);
        Assertions.assertEquals(0, part1);
    }

    @Test
    void testPart2Input()
    {
        URL url  = getClass().getResource("input/input_file.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        base_class.setLines(lines);

        int part2 = base_class.part2();
        System.out.println("Part2: " + part2);
        Assertions.assertEquals(0, part2);
    }
}
