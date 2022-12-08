package year22;

import java.util.Arrays;
import java.util.List;

public class Dec08 {
    private List<String> lines;
    private int[][] trees;


    public Dec08() {
    }

    protected int part1()
    {
        int size = lines.size();
        trees = new int[size][size];
        int visible = size * 4 - 4;

        for (int y = 0; y < size; y++)
        {
            for (int x = 0; x < size; x++)
            {
                trees[y][x] = lines.get(y).charAt(x);
            }
        }
        for (int y = 1; y < size - 1; y++)
        {
            for (int x = 1; x < size - 1; x++)
            {
                if (checkWest(y, x))
                {
                    visible++;
                }
                else if (checkNorth(y, x))
                {
                    visible++;
                }
                else if (checkEast(y, x))
                {
                    visible++;
                }
                else if (checkSouth(y, x))
                {
                    visible++;
                }
            }
        }

        return visible;
    }

    private boolean checkSouth(int y, int x) {
        int height = trees[y][x];
        for (int i = y + 1; i < lines.size(); i++)
        {
            if (trees[i][x] >= height)
            {
                return false;
            }
        }
        return true;
    }

    private boolean checkEast(int y, int x) {
        int height = trees[y][x];
        for (int i = x + 1; i < lines.size(); i++)
        {
            if (trees[y][i] >= height)
            {
                return false;
            }
        }
        return true;
    }

    private boolean checkNorth(int y, int x) {
        int height = trees[y][x];
        for (int i = y - 1; i >= 0; i--)
        {
            if (trees[i][x] >= height)
            {
                return false;
            }
        }
        return true;
    }

    private boolean checkWest(int y, int x) {
        int height = trees[y][x];
        for (int i = x - 1; i >= 0; i--)
        {
            if (trees[y][i] >= height)
            {
                return false;
            }
        }
        return true;
    }

    protected int part2()
    {
        int size = lines.size();
        trees = new int[size][size];
        for (int y = 0; y < size; y++)
        {
            for (int x = 0; x < size; x++)
            {
                trees[y][x] = lines.get(y).charAt(x);
            }
        }
        int highest = 0;
        for (int y = 1; y < size - 1; y++)
        {
            for (int x = 1; x < size - 1; x++)
            {
                int score = 1;
                score *= countWest(y, x);
                score *= countNorth(y, x);
                score *= countEast(y, x);
                score *= countSouth(y, x);

                if (score > highest)
                {
                    highest = score;
                }
            }
        }

        return highest;
    }
    private int countSouth(int y, int x) {
        int height = trees[y][x];
        int count = 0;
        for (int i = y + 1; i < lines.size(); i++)
        {
            count++;
            if (trees[i][x] >= height)
            {
                break;
            }
        }
        return count;
    }

    private int countEast(int y, int x) {
        int height = trees[y][x];
        int count = 0;
        for (int i = x + 1; i < lines.size(); i++)
        {
            count++;
            if (trees[y][i] >= height)
            {
                break;
            }
        }
        return count;
    }

    private int countNorth(int y, int x) {
        int height = trees[y][x];
        int count = 0;
        for (int i = y - 1; i >= 0; i--)
        {
            count++;
            if (trees[i][x] >= height)
            {
                break;
            }
        }
        return count;
    }

    private int countWest(int y, int x) {
        int height = trees[y][x];
        int count = 0;
        for (int i = x - 1; i >= 0; i--)
        {
            count++;
            if (trees[y][i] >= height)
            {
                break;
            }
        }
        return count;
    }

    public void setLines(List<String> lines)
    {
        this.lines = lines;
    }
}
