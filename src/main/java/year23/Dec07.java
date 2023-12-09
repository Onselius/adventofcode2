package year23;

import util.StopWatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dec07 {
    private List<String> lines;
    Map<Character, Character> conversion;
    public Dec07() {
    }

    protected int part1()
    {
        StopWatch stopWatch = new StopWatch();
        List<Hand> hands = new ArrayList<>();
        conversion = Map.of(
                'T', ':',
                'J', ';',
                'Q', '<',
                'K', '=',
                'A', '>');
        for (String line: lines)
        {
            String[] input = line.split(" ");
            Hand hand = new Hand(input[0], input[1]);
            setRank1(hand);
            hands.add(hand);
        }

        Collections.sort(hands);

        int winnings = 0;
        for (int rank = 0; rank < hands.size(); rank++)
        {
            winnings += hands.get(rank).bid * (rank + 1);
        }

        stopWatch.stopTime();
        return winnings;
    }


    private void setRank1(Hand hand)
    {
        Set<Character> cardSet = new HashSet<>(5);
        for (char c: hand.cards)
        {
            cardSet.add(c);
        }

        switch (cardSet.size())
        {
            case 1:
                hand.type = 6;
                break;
            case 2:
                // four or full house
                hand.type = checkFour(hand.cards);
                break;
            case 3:
                //three or two
                hand.type = checkThree(hand.cards);
                break;
            case 4:
                hand.type = 1;
                break;
            default:
                hand.type = 0;
                break;
        }
    }

    private int checkFour(char[] cards)
    {
        int match = 0;
        for (int i = 1; i < cards.length; i++)
        {
            if (cards[i] == cards[0]) match++;
        }
        if (match == 0 || match == 3) return 5;
        return 4;
    }

    private int checkThree(char[] cards)
    {
        int match = 0;
        int highestMatch = 0;
        for (int i = 0; i < cards.length; i++)
        {
            match = 0;
            for (int j = i + 1; j < cards.length; j++)
            {
                if (cards[j] == cards[i]) match++;
            }
            if (match > highestMatch) highestMatch = match;
        }
        if (highestMatch == 2) return 3;
        return 2;
    }

    protected long part2()
    {
        StopWatch stopWatch = new StopWatch();
        List<Hand> hands = new ArrayList<>();
        conversion = Map.of(
                'T', ':',
                'J', '/',
                'Q', '<',
                'K', '=',
                'A', '>');
        for (String line: lines)
        {
            String[] input = line.split(" ");
            Hand hand = new Hand(input[0], input[1]);
            setRank2(hand);
            hands.add(hand);
        }

        Collections.sort(hands);

        long winnings = 0;
        for (int rank = 0; rank < hands.size(); rank++)
        {
            winnings += (long) hands.get(rank).bid * (rank + 1);
        }


        stopWatch.stopTime();
        return winnings;
    }

    private void setRank2(Hand hand)
    {
        Set<Character> cardSet = new HashSet<>(5);
        int jokers = 0;
        for (char c: hand.cards)
        {
            if (c == '/')
            {
                jokers++;
                continue;
            }
            cardSet.add(c);
        }

        if (jokers == 0)
        {
            switch (cardSet.size())
            {
                case 1:
                    hand.type = 6;
                    break;
                case 2:
                    // four or full house
                    hand.type = checkFour(hand.cards);
                    break;
                case 3:
                    //three or two
                    hand.type = checkThree(hand.cards);
                    break;
                case 4:
                    hand.type = 1;
                    break;
                default:
                    hand.type = 0;
                    break;
            }
            return;
        }

        int match;
        int highestMatch = 0;
        for (int i = 0; i < hand.cards.length; i++)
        {
            char card = hand.cards[i];
            if (card == '/') continue;
            match = 0;
            for (int j = i + 1; j < hand.cards.length; j++)
            {
                if (card == hand.cards[j]) match++;
            }
            if (match > highestMatch) highestMatch = match;
        }


        switch (jokers)
        {
            case 1:
                if (cardSet.size() == 4) hand.type = 1;
                else if (highestMatch == 1 && cardSet.size() == 3) hand.type = 3;
                else if (highestMatch == 1 && cardSet.size() == 2) hand.type = 4;
                else if (highestMatch == 3) hand.type = 6;
                else if (highestMatch == 2) hand.type = 5;
                break;
            case 2:
                if (highestMatch == 2) hand.type = 6;
                else if (highestMatch == 1) hand.type = 5;
                else hand.type = 3;
                break;
            case 3:
                if (highestMatch == 1) hand.type = 6;
                else hand.type = 5;
                break;
            case 4, 5:
                hand.type = 6;
                break;
            default:
                break;
        }
    }

    public void setLines(List<String> lines)
    {
        this.lines = lines;
    }

    class Hand implements Comparable<Hand>
    {
        private char[] cards;
        int type;
        int bid;

        Hand(String cards, String bid)
        {
            this.cards = cards.toCharArray();
            for (int i = 0; i < this.cards.length; i++)
            {
                char c = this.cards[i];
                this.cards[i] = conversion.getOrDefault(c, c);
            }
            this.bid = Integer.parseInt(bid);
        }


        @Override
        public int compareTo(Hand hand) {
            if (type > hand.type) return 1;
            else if (type < hand.type) return -1;
            else
            {
                for (int i = 0; i < cards.length; i++)
                {
                    if (cards[i] > hand.cards[i]) return 1;
                    else if (cards[i] < hand.cards[i]) return -1;
                }
            }
            return 0;
        }
    }
}
