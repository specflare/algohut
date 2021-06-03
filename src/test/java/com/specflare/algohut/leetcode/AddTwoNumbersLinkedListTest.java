package com.specflare.algohut.leetcode;

import com.specflare.algohut.leetcode.util.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddTwoNumbersLinkedListTest {
    @Test
    public void test() {
        Assertions.assertEquals(AddTwoNumbersLinkedList.addTwoNumbers(
                new ListNode(2, new ListNode(4, new ListNode(3))),
                new ListNode(5, new ListNode(6, new ListNode(4)))
        ), new ListNode(7, new ListNode(0, new ListNode(8))));


        Assertions.assertEquals(AddTwoNumbersLinkedList.addTwoNumbers(
                new ListNode(0),
                new ListNode(0)
        ), new ListNode(0));

        Assertions.assertEquals(
                AddTwoNumbersLinkedList.addTwoNumbers(
                        ListNode.fromArray(new int[]{9}),
                        ListNode.fromArray(new int[]{9, 9})),
                ListNode.fromArray(new int[]{8, 0, 1})
        );

        Assertions.assertEquals(
                AddTwoNumbersLinkedList.addTwoNumbers(
                        ListNode.fromArray(new int[]{9, 9, 9, 9, 9, 9, 9}),
                        ListNode.fromArray(new int[]{9, 9, 9, 9})),
                ListNode.fromArray(new int[]{8, 9, 9, 9, 0, 0, 0, 1})
        );

        Assertions.assertEquals(
                AddTwoNumbersLinkedList.addTwoNumbers(
                        ListNode.fromArray(new int[]{8}),
                        ListNode.fromArray(new int[]{2})),
                ListNode.fromArray(new int[]{0, 1})
        );

        Assertions.assertEquals(
                AddTwoNumbersLinkedList.addTwoNumbers(
                        ListNode.fromArray(new int[]{0,0,0,0,8}),
                        ListNode.fromArray(new int[]{0,0,0,2})),
                ListNode.fromArray(new int[]{0, 0, 0, 2, 8})
        );

        Assertions.assertEquals(
                AddTwoNumbersLinkedList.addTwoNumbers(
                        ListNode.fromArray(new int[]{0,0,0,0,8}),
                        null),
                ListNode.fromArray(new int[]{0,0,0,0,8})
        );
    }
}
