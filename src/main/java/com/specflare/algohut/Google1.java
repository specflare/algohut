package com.specflare.algohut;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Cards game
// Each card has 4 attributes, and each attribute has 3 possible values. 3^4 different cards = 81.
// Ask 1: Given 3 cards, return true if they form a set.
//      A set contains cards whose attributes have different values 1 by 1.

// Ask 2: Given an array of cards, find 3 cards that form a set and return their indices in the array.
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

    // Valid set (ask 1)
    // C1(1, 2, 3, 3)
    // C2(2, 3, 1, 2)
    // C3(3, 1, 2, 1)
    public boolean isSet(Card c1, Card c2, Card c3) {
        for (int i = 0; i < 4; i++) {
            Set<Integer> s = new HashSet<>();
            s.add(c1.attrs[i]);
            s.add(c2.attrs[i]);
            s.add(c3.attrs[i]);

            // the same attribute must be different for each of the 3 cards.
            if (s.size() != 3) {
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
