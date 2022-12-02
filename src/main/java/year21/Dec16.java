package year21;

import util.ReadFile;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dec16 {

    private List<String> lines;
    private HashMap<List<Integer>, Integer> grid;
    private int versionSum;

    public Dec16() {
    }

    protected long part1(int index)
    {
        versionSum = 0;
        String packet = lines.get(index);
        packet = convertHexToBinary(packet);

        List<Long> result = parsePacket(packet);

        return this.versionSum;
    }

    protected long part2(int index)
    {
        versionSum = 0;
        String packet = lines.get(index);
        packet = convertHexToBinary(packet);

        List<Long> result = parsePacket(packet);
        return result.get(1);
    }


    public List<Long> parsePacket(String packet)
    {
//        System.out.println(packet);
        int version = getVersion(packet);
        int type = getType(packet);

        List<Long> returnList;
        if (type == 4)
        {
            returnList = parseLiteralValue(packet);
        }
        else
        {
            returnList = parseOperatorValue(packet);
        }

        return returnList;
    }

    public List<Long> parseLiteralValue(String packet)
    {
        packet = packet.substring(6);
        long size = 6;
        StringBuilder builder = new StringBuilder(packet.length());
        while (true)
        {
            builder.append(packet, 1, 5);
            size += 5;
            if (packet.startsWith("0")) break;
            packet = packet.substring(5);
        }
        long value = Long.parseLong(builder.toString(), 2);

        return List.of(size, value);
    }

    public List<Long> parseOperatorValue(String packet)
    {
        char lengthID = packet.charAt(6);
        List<Long> returnList;
        if (lengthID == '0')
        {
            returnList = parse15Bit(packet);
        }
        else
        {
            returnList = parse11Bit(packet);
        }

        return returnList;
    }

    public List<Long> parse15Bit(String payload)
    {
        int payloadLength = Integer.parseInt(payload.substring(7, 22), 2);
//        System.out.println("substring: " + payload.substring(7, 22));
//        System.out.println("length: " + payloadLength);
        long readBits = 0;
        List<Long> values = new ArrayList<>();
        List<Long> returnList;

        while (readBits < payloadLength)
        {
            returnList = parsePacket(payload.substring((int) (22 + readBits)));
            readBits += returnList.get(0);
            values.add(returnList.get(1));
        }
        long value = operate(getType(payload), values);

        return List.of(22L + payloadLength, value);
    }

    public List<Long> parse11Bit(String payload)
    {
        int numberOfPackages = Integer.parseInt(payload.substring(7, 18), 2);
        int readPackages = 0;
        long readBits = 0L;
        List<Long> values = new ArrayList<>();
        List<Long> returnList;

        while (readPackages < numberOfPackages)
        {
            returnList = parsePacket(payload.substring((int) (18 + readBits)));
            readPackages++;
            readBits += returnList.get(0);
            values.add(returnList.get(1));
        }
        long value = operate(getType(payload), values);

        return List.of(18 + readBits, value);
    }

    public long operate(int operator, List<Long> values)
    {
        long value = 0L;
        switch (operator)
        {
            case 0:
                value = values.stream().mapToLong(Long::longValue).sum();
                break;
            case 1:
                value = values.stream().reduce(1L, (a, b) -> a * b);
                break;
            case 2:
                value = values.stream().min(Long::compareTo).get();
                break;
            case 3:
                value = values.stream().max(Long::compareTo).get();
                break;
            case 5:
                if (values.get(0) > values.get(1))
                {
                    value = 1;
                }
                else
                {
                    value = 0;
                }
                break;
            case 6:
                if (values.get(0) < values.get(1))
                {
                    value = 1;
                }
                else
                {
                    value = 0;
                }
                break;
            case 7:
                if (values.get(0).equals(values.get(1)))
                {
                    value = 1;
                }
                else
                {
                    value = 0;
                }
                break;
        }

        return value;
    }

    public int getVersion(String packet)
    {
        String versionBinary = packet.substring(0, 3);
        int version = Integer.parseInt(versionBinary, 2);
        this.versionSum += version;
        return version;
    }

    public int getType(String packet)
    {
        String typeBinary = packet.substring(3, 6);
        return Integer.parseInt(typeBinary, 2);
    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public void updateLinesFromFilename(String filename)
    {
        URL url  = getClass().getResource(filename);
        this.lines = ReadFile.getTextFromFile(url.getPath());
    }

    public HashMap<List<Integer>, Integer> getGrid() {
        return grid;
    }

    public String convertHexToBinary(String hex)
    {
        hex = hex.replaceAll("0", "0000");
        hex = hex.replaceAll("1", "0001");
        hex = hex.replaceAll("2", "0010");
        hex = hex.replaceAll("3", "0011");
        hex = hex.replaceAll("4", "0100");
        hex = hex.replaceAll("5", "0101");
        hex = hex.replaceAll("6", "0110");
        hex = hex.replaceAll("7", "0111");
        hex = hex.replaceAll("8", "1000");
        hex = hex.replaceAll("9", "1001");
        hex = hex.replaceAll("A", "1010");
        hex = hex.replaceAll("B", "1011");
        hex = hex.replaceAll("C", "1100");
        hex = hex.replaceAll("D", "1101");
        hex = hex.replaceAll("E", "1110");
        hex = hex.replaceAll("F", "1111");
        return hex;
    }

    public String getValue(String packageValue)
    {
        return "";
    }
}

/*
1101000101001010010001001000000000
101000101001010010001001000000000
parken > fight > cobra > fight
jules > cobra > parken > parken
fight > jules > cobra
cobra > jules




*/






