package datastructures.sequential;

import java.util.EmptyStackException;

public class Stack<E> implements LIFOQueue<E> {
    private SNode<E> topNode;
    private int size;

    public Stack() {
        topNode = null;
        size = 0;
    }

    @Override
    public E pop() {
        if (size == 0)
            throw new EmptyStackException();

        size--;
        E data = topNode.getData(); // store data of the node to be removed
        if (size == 0) // no more nodes lower on the stack, stack has been cleared
            topNode = null;
        else // set top node to the node immediately below the one getting removed
            topNode = topNode.getNext();

        return data;
    }

    @Override
    public void push(E element) {
        size++;
        SNode<E> newNode = new SNode<>(element);
        newNode.setNext(topNode); // put newNode on top of the previous topNode
        topNode = newNode;
    }

    @Override
    public E peek() {
        if (size == 0)
            throw new EmptyStackException();

        return topNode.getData();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
