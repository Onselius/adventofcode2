package year21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Dec04 {

    private List<String> lines;

    public Dec04() {
    }

    protected long part1()
    {
        List<Integer> input = Arrays.stream(lines.remove(0).split(",")).map(Integer::parseInt).collect(Collectors.toList());
        List<BingoGrid> grids = new ArrayList<>();

        for (int i = 0; i < lines.size(); i += 6)
        {
            BingoGrid bingoGrid = createGrids(lines.subList(i + 1, i + 6));
            grids.add(bingoGrid);
        }

        int currentNumber = 0;
        BingoGrid winner = null;
        for (int number : input)
        {
            for (BingoGrid grid : grids)
            {
                grid.markNumber(number);
                if (grid.checkIfWinner())
                {
                    winner = grid;
                }
            }
            if (winner != null)
            {
                currentNumber = number;
                break;
            }
        }
        System.out.println("We have a winner");

        long sum = winner.calculatePart1(currentNumber);
        return sum;
    }

    protected long part2()
    {
        List<Integer> input = Arrays.stream(lines.remove(0).split(",")).map(Integer::parseInt).collect(Collectors.toList());
        List<BingoGrid> grids = new ArrayList<>();

        for (int i = 0; i < lines.size(); i += 6)
        {
            BingoGrid bingoGrid = createGrids(lines.subList(i + 1, i + 6));
            grids.add(bingoGrid);
        }

        int currentNumber = 0;
        BingoGrid winner = null;
        for (int number : input)
        {
            boolean newWinner = false;
            List<BingoGrid> winners = new ArrayList<>();
            for (BingoGrid grid : grids)
            {
                grid.markNumber(number);
                if (grid.checkIfWinner())
                {
                    winner = grid;
                    newWinner = true;
                    winners.add(grid);
                }
            }
            grids.removeAll(winners);
            if (newWinner)
            {
                currentNumber = number;
            }
        }

        long sum = winner.calculatePart1(currentNumber);
        return sum;
    }

    private BingoGrid createGrids(List<String> lines)
    {
        BingoGrid bingoGrid = new BingoGrid();

        for (int y = 0; y < lines.size(); y++)
        {
            List<String> splittedLine = new ArrayList<>(List.of(lines.get(y).split(" ")));
            splittedLine.removeIf(String::isEmpty);

            for (int x = 0; x < splittedLine.size(); x++)
            {
                bingoGrid.addNumber(Integer.parseInt(splittedLine.get(x)), x, y);
            }
        }

        return bingoGrid;
    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public class BingoGrid
    {
        private List<List<Integer>> rows;
        private List<List<Integer>> columns;
        public List<Integer> markedNumbers;
        public List<Integer> unmarkedNumbers;

        public BingoGrid()
        {
            this.rows = new ArrayList<>(5);
            this.columns = new ArrayList<>(5);
            this.markedNumbers = new ArrayList<>();
            this.unmarkedNumbers = new ArrayList<>();

            createLists(rows);
            createLists(columns);
        }

        public long calculatePart1(int number)
        {
            long sum = 0;
            for (int i : this.unmarkedNumbers)
            {
                sum += i;
            }

            return sum * number;
        }

        public boolean checkIfWinner()
        {
            for (List<Integer> list : this.rows)
            {
                if (list.isEmpty())
                {
                    return true;
                }
            }
            for (List<Integer> list : this.columns)
            {
                if (list.isEmpty())
                {
                    return true;
                }
            }
            return false;
        }

        private void createLists(List<List<Integer>> mainList)
        {
            for (int i = 0; i < 5; i++)
            {
                mainList.add(new ArrayList<>());
            }
        }

        public void addNumber(int number, int x, int y)
        {
            this.rows.get(y).add(x, number);
            this.columns.get(x).add(y, number);
            this.unmarkedNumbers.add(number);
        }

        public void markNumber(int number)
        {
            for (List<Integer> list : rows)
            {
                for (int i : list)
                {
                    if (i == number)
                    {
                        list.remove(Integer.valueOf(number));
                        this.markedNumbers.add(number);
                        this.unmarkedNumbers.remove(Integer.valueOf(number));
                        break;
                    }
                }
            }
            for (List<Integer> list : columns)
            {
                for (int i : list)
                {
                    if (i == number)
                    {
                        list.remove(Integer.valueOf(number));
                        this.markedNumbers.add(number);
                        this.unmarkedNumbers.remove(Integer.valueOf(number));
                        break;
                    }
                }
            }
        }

    }
}
