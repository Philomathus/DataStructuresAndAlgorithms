package com.main.list;

/**
 * Uses a head sentinel node.
 * Does not have an explicit head reference.
 * @param <E>
 */
public class SinglyLinkedListV2<E> {

    private static class Node<E> {

        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public Node(E data) {
            this.data = data;
        }

        public Node() {

        }

        public void setData(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getNext() {
            return next;
        }

    }

    /**
     * Sentinel node
     */
    private final Node<E> header;
    private Node<E> tail;
    private int size;

    public SinglyLinkedListV2() {

        header = new Node<>();

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        return isEmpty() ? null : header.getNext().getData();
    }

    public E last() {
        return isEmpty() ? null : tail.getData();
    }

    public void addFirst(E data) {
        Node<E> newFirst = new Node<>(data);
        addAfter(header, newFirst);

        if(isEmpty())
            tail = newFirst;
    }

    public void addLast(E data) {
        Node<E> newNext = new Node<>(data);
        addAfter(isEmpty() ? header : tail, newNext);
        tail = newNext;
    }

    public E removeFirst() {
        if(isEmpty())
            return null;

        Node<E> head = header.getNext();
        header.setNext(head.getNext());
        size--;

        if(isEmpty())
            tail = null;

        return head.getData();
    }

    private void addAfter(Node<E> predecessor, Node<E> node) {

        node.setNext(predecessor.getNext());
        predecessor.setNext(node);
        size++;

    }
}
