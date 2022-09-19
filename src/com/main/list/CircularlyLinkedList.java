package com.main.list;

public class CircularlyLinkedList<E> {

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

    //head == tail.getNext()
    //head = node; == tail.setNext(node);
    private Node<E> tail;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        return isEmpty() ? null : tail.getNext().getData();
    }

    public E last() {
        return isEmpty() ? null : tail.getData();
    }

    public void addFirst(E data) {
        Node<E> newest = new Node<>(data);

        if(isEmpty())
            tail = newest;

        newest.setNext(tail.getNext());
        tail.setNext(newest);

        size++;
    }

    public void addLast(E data) {

        addFirst(data);
        tail = tail.getNext();

    }

    public E removeFirst() {
        if(isEmpty())
            return null;

        Node<E> head = tail.getNext();

        if(head == tail)
            tail = null;
        else
            tail.setNext(head.getNext());

        size--;

        return head.getData();
    }

    public void rotate() {
        if(!isEmpty())
            tail = tail.getNext();
    }


}
