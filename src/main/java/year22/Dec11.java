package year22;

import util.StopWatch;

import java.util.*;

public class Dec11 {
    private List<String> lines;
    private Monkey[] monkeys;

    public Dec11() {
    }

    protected int part1()
    {
        StopWatch stopWatch = new StopWatch();
        parseList();
        for (int round = 0; round < 20; round++)
        {
            for (Monkey monkey: monkeys)
            {
                int size = monkey.items.size();
                for (int i = 0; i < size; i++)
                {
                    int item = monkey.getItem();
                    item = (int) monkey.inspect(item);
                    item = monkey.relief(item);
                    int target = monkey.test(item);
                    monkeys[target].addItem(item);
                }
            }
//            System.out.println(Arrays.toString(monkeys));
        }

        int[] topValues = Arrays.stream(monkeys).mapToInt(m -> m.inspected).sorted().toArray();

        stopWatch.stopTime();
        return topValues[topValues.length - 1] * topValues[topValues.length - 2];
    }

    private void parseList()
    {
        monkeys = new Monkey[(lines.size() + 1)/ 7];
        for (int i = 0; i < lines.size();)
        {
            int index = Integer.parseInt(lines.get(i).split(" ")[1].split(":")[0]);
            i++;
            String[] items = lines.get(i).split(":")[1].split(",");
            i++;
            String[] ops = lines.get(i).split("= ")[1].split(" ");
            char operator = ops[1].charAt(0);
            String stringOpValue = ops[2];
            int opValue = stringOpValue.equals("old") ? -1: Integer.parseInt(stringOpValue);
            i++;
            int test = Integer.parseInt(lines.get(i).split("by ")[1]);
            i++;
            int trueValue = Integer.parseInt((lines.get(i).split("monkey ")[1]));
            i++;
            int falseValue = Integer.parseInt((lines.get(i).split("monkey ")[1]));
            monkeys[index] = new Monkey(operator, opValue, test, trueValue, falseValue);
            for (int j = 0; j < items.length; j++)
            {
                monkeys[index].addItem(Integer.parseInt(items[j].strip()));
            }
            i += 2;
        }
    }

    protected long part2()
    {
        StopWatch stopWatch = new StopWatch();
        parseList();
        long lcd = 1;
        for (Monkey monkey: monkeys)
        {
            lcd *= monkey.test;
        }
        for (int round = 0; round < 10000; round++)
        {
            for (Monkey monkey: monkeys)
            {
                int size = monkey.items.size();
                for (int i = 0; i < size; i++)
                {
                    int item = monkey.getItem();
                    long inspectedItem = monkey.inspect(item);
//                    item = monkey.relief(item);
                    item = (int) (inspectedItem % lcd);
                    int target = monkey.test(item);
                    if (item < 0)
                    {
                        System.out.println();
                    }
                    monkeys[target].addItem(item);
                }
            }
//            System.out.println(Arrays.toString(monkeys));
        }

        int[] topValues = Arrays.stream(monkeys).mapToInt(m -> m.inspected).sorted().toArray();

        stopWatch.stopTime();
        return (long) topValues[topValues.length - 1] * topValues[topValues.length - 2];
    }

    public void setLines(List<String> lines)
    {
        this.lines = lines;
    }


    private class Monkey
    {
        private Queue<Integer> items;
        private char operator;
        private int opValue;
        private int test;
        private int trueMonkey;
        private int falseMonkey;
        private int inspected;

        public Monkey(char operator,
                      int opValue,
                      int test,
                      int trueMonkey,
                      int falseMonkey)
        {
            this.operator = operator;
            this.opValue = opValue;
            this.test = test;
            this.trueMonkey = trueMonkey;
            this.falseMonkey = falseMonkey;
            this.items = new LinkedList<>();
            this.inspected = 0;
        }

        private int getItem()
        {
            return items.poll();
        }

        private void addItem(int value)
        {
            items.add(value);
        }

        private long inspect(int value)
        {
            inspected++;
            int op = opValue == -1 ? value : opValue;
            return operator == '+' ? value + op : (long) value * op;
        }

        private int relief(int value)
        {
            return value / 3;
        }

        private int test(int value)
        {
            return value % test == 0 ? trueMonkey : falseMonkey;
        }

    }
}
