package com.main.list;

public class SinglyLinkedList<E> {

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

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        return isEmpty() ? null : head.getData();
    }

    public E last() {
        return isEmpty() ? null : tail.getData();
    }

    public void addFirst(E data) {
        head = new Node<>(data, head);

        if(isEmpty())
            tail = head;

        size++;
    }

    public void addLast(E data) {
        Node<E> newest = new Node<>(data);

        if(isEmpty())
            head = newest;
        else
            tail.setNext(newest);

        tail = newest;

        size++;
    }

    public E removeFirst() {
        if(isEmpty())
            return null;

        E removedData = head.getData();
        head = head.getNext();

        if(head == null)
            tail = null;

        size--;

        return removedData;
    }

}
