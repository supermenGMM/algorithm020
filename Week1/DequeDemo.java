package com.ryx.sms;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {
    @Test
    public void deque() {
        Deque deque = new LinkedList();

        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");
        System.out.println(deque);

        Object peek = deque.getFirst();
        System.out.println(peek);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.pollFirst());
        }

        System.out.println(deque);
        deque.pollFirst();
        deque.removeFirst();
    }
}
