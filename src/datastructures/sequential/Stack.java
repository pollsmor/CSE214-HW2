package datastructures.sequential;

import java.util.EmptyStackException;

/**
 * This class is a custom-made implementation of the Stack abstract data type, and is a dependency
 * for many of the other classes in the applications.arithmetic package.
 * @author Kevin Li
 */
public class Stack<E> implements LIFOQueue<E> {
    private SNode<E> topNode;
    private int size;

    public Stack() {
        topNode = null;
        size = 0;
    }

    /*
    @SuppressWarnings("StringConcatenationInLoop")
    @Override
    public String toString() {
        String output = "";
        SNode<E> curr = topNode;
        while (curr != null) {
            output += (curr.getData() + " ");
            curr = curr.getNext();
        }

        return output;
    }
     */

    /**
     * Retrieves and removes the element at the top of this stack.
     *
     * @return the element at the top of this stack.
     * @throws EmptyStackException if the stack is empty.
     */
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

    /**
     * Pushes the specified element onto the top of this stack.
     *
     * @param element the element to be pushed onto the top of this stack.
     */
    @Override
    public void push(E element) {
        size++;
        SNode<E> newNode = new SNode<>(element);
        newNode.setNext(topNode); // put newNode on top of the previous topNode
        topNode = newNode;
    }

    /**
     * Retrieves, but does not remove, the element at the top of this stack.
     *
     * @return the element at the top of this stack.
     * @throws EmptyStackException if the stack is empty.
     */
    @Override
    public E peek() {
        if (size == 0)
            throw new EmptyStackException();

        return topNode.getData();
    }

    /**
     * Returns the number of elements in this sequence.
     *
     * @return the number of elements in this sequence
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @return <code>true</code> if and only if the sequence contains no elements, <code>false</code> otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
