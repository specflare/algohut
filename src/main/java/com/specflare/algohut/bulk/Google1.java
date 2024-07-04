package com.specflare.algohut.bulk;

import java.util.Arrays;
import java.util.Comparator;

// Cards game
public class Google1 {
    // total number of different cards 3 ^ 4 = 81.
    public static class Card {
        int attr1, attr2, attr3, attr4; // values can be 1, 2, 3.
        public Card(int a1, int a2, int a3, int a4) {
            attr1 = a1;
            attr2 = a2;
            attr3 = a3;
            attr4 = a4;
        }
    }

    Comparator<Card> cardsComp = Comparator.comparingInt((Card c) -> c.attr1)
            .thenComparingInt((Card c) -> c.attr2)
            .thenComparingInt((Card c) -> c.attr3)
            .thenComparingInt((Card c) -> c.attr4);

    // C1(1, 2, 3, 1)
    // C2(2, 3, 1, 3)
    // C3(3, 1, 2, 2)
    public boolean isSet(Card c1, Card c2, Card c3) {
        if (c1.attr1 == c2.attr1 || c2.attr1 == c3.attr1 || c1.attr1 == c3.attr1) {
            return false;
        }

        if (c1.attr2 == c2.attr2 || c2.attr2 == c3.attr2 || c1.attr2 == c3.attr2) {
            return false;
        }

        if (c1.attr3 == c2.attr3 || c2.attr3 == c3.attr3 || c1.attr3 == c3.attr3) {
            return false;
        }

        if (c1.attr4 == c2.attr4 || c2.attr4 == c3.attr4 || c1.attr4 == c3.attr4) {
            return false;
        }

        return true;
    }

    public int binSearch(Card[] cards, Card key, int left, int right) {
        if (left > right) {
            return -1;
        }

        int middle = (left + right) / 2;

        if (cards[middle] == key) {
            return middle;
        }

        if (cardsComp.compare(key, cards[middle]) < 0) {
            return binSearch(cards, key, left, middle);
        }

        return binSearch(cards, key, middle + 1, right);
    }

    public Card getMissingCard(Card c1, Card c2) {
        return new Card(6 - c1.attr1 - c2.attr1,
                6 - c1.attr2 - c2.attr2,
                6 - c1.attr3 - c2.attr3,
                6 - c1.attr4 - c2.attr4);
    }

    public int[] findSet(Card[] cards) {
        Arrays.sort(cards, cardsComp);

        for (int i = 0; i < cards.length - 2; i++) {
            for (int j = i + 1; j < cards.length - 1; j++) {
                int k = binSearch(cards, getMissingCard(cards[i], cards[j]), j + 1, cards.length);
                if (k != -1) {
                    return new int[] {i, j, k};
                }
            }
        }

        return new int[] {-1, -1, -1};
    }
}
