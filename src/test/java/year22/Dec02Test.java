package year22;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.ReadFile;

import java.net.URL;
import java.util.List;

public class Dec02Test {
    private final Dec02 dec02 = new Dec02();

    @Test
    void testPart1()
    {
        URL url  = getClass().getResource("test/test02.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        dec02.setLines(lines);

        Assertions.assertEquals(15, dec02.part1());
    }

    @Test
    void testPart2()
    {
        URL url  = getClass().getResource("test/test02.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        dec02.setLines(lines);

        Assertions.assertEquals(12, dec02.part2());
    }

    @Test
    void testPart1Input()
    {
        URL url  = getClass().getResource("input/input02.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        dec02.setLines(lines);

        int part1 = dec02.part1();
        System.out.println("Part1: " + part1);
        Assertions.assertEquals(13924, part1);
        // 15130 too high
        // 12412 too low
    }

    @Test
    void testPart2Input()
    {
        URL url  = getClass().getResource("input/input02.txt");
        List<String> lines = ReadFile.getTextFromFile(url.getPath());
        dec02.setLines(lines);

        int part2 = dec02.part2();
        System.out.println("Part2: " + part2);
        Assertions.assertEquals(13448, part2);
    }
}
