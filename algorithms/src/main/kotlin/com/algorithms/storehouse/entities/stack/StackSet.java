package com.algorithms.storehouse.entities.stack;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;

@RequiredArgsConstructor
public class StackSet<E extends Comparable<E>> {
    private final LinkedList<StackMin<E>> stackSet = new LinkedList<>();
    @Getter
    @NonNull
    private int threshold;

    public void push(E e) {
        StackMin<E> firstStackMin;
//        check is size of first stack is equal or greater threshold - scale up
        if ((stackSet.isEmpty()) || stackSet.getFirst().size() >= threshold) {
            firstStackMin = new StackMin<>();
            stackSet.addFirst(firstStackMin);
        } else {
            firstStackMin = stackSet.getFirst();
        }
        firstStackMin.push(e);
    }

    public E pop() {
        E e = stackSet.getFirst().pop().getValue();
        if (stackSet.getFirst().size() == 0) {
            stackSet.removeFirst();
        }
        return e;
    }

    public E popAt(int stackIndex) {
//        O(N)
        if (stackIndex > stackSet.size()) {
            throw new IndexOutOfBoundsException();
        }
        StackMin<E> subStack = stackSet.get(stackIndex);
        E e = subStack.pop().getValue();
//        check if after pop substack size() = 0
        if (subStack.size() == 0) {
//            O(N)
            stackSet.remove(stackIndex);
        }
        return e;
    }

    public int numOfStacks() {
        return stackSet.size();
    }
}