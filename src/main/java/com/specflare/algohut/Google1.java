package com.specflare.algohut;

import java.util.Arrays;

// Cards game
public class Google1 {
    public static class Card implements Comparable<Card> {
        public int[] attrs = new int[4]; // possible values: 1, 2, 3

        public Card(int attr1, int attr2, int attr3, int attr4) {
            this.attrs[0] = attr1;
            this.attrs[1] = attr2;
            this.attrs[2] = attr3;
            this.attrs[3] = attr4;
        }

        @Override
        public int compareTo(Card o) {
            for (int i = 0; i < 4; i++) {
                if (attrs[i] != o.attrs[i]) {
                    return attrs[i] > o.attrs[i] ? 1 : -1;
                }
            }

            return 0;
        }
    }

    // C1(1, 2, 3)
    // C2(2, 3, 1)
    // C3(3, 1, 2)
    public boolean isSet(Card c1, Card c2, Card c3) {
        for (int i = 0; i < 4; i++) {
            boolean allEqual = false;
            boolean allDifferent = c1.attrs[i] != c2.attrs[i] || c2.attrs[i] != c3.attrs[i];

            if (c1.attrs[i] == c2.attrs[i] || c2.attrs[i] == c3.attrs[i] || c1.attrs[i] == c3.attrs[i]) {
                allEqual = true;
            }

            if (!allDifferent || !allEqual) {
                return false;
            }
        }

        return true;
    }

    int findMissingAttr(Card c1, Card c2, int attrIndex) {
        if (c1.attrs[attrIndex] == c2.attrs[attrIndex]) {
            return c1.attrs[attrIndex];
        }

        return 6 - c1.attrs[attrIndex] - c2.attrs[attrIndex];
    }

    public int binSearch(Card[] cards, Card key, int left, int right) {
        if (left > right) {
            return -1;
        }

        int middle = (left + right) / 2;

        if (cards[middle] == key) {
            return middle;
        }

        if (key.compareTo(cards[middle]) < 0) {
            return binSearch(cards, key, left, middle);
        }

        return binSearch(cards, key, middle + 1, right);
    }

    public int[] findSet(Card[] cards) {
        Arrays.sort(cards);

        for (int i = 0; i < cards.length - 1; i++) {
            for (int j = i + 1; j < cards.length; j++) {
                Card missingCard = new Card(
                        findMissingAttr(cards[i], cards[j], 0),
                        findMissingAttr(cards[i], cards[j], 1),
                        findMissingAttr(cards[i], cards[j], 2),
                        findMissingAttr(cards[i], cards[j], 3)
                );

                int pos = binSearch(cards, missingCard, j + 1, cards.length);
                if (pos != -1) {
                    return new int[] {i, j, pos};
                }
            }
        }

        return new int[] {-1, -1, -1};
    }
}
