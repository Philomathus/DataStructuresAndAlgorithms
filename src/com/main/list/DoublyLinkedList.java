package com.main.list;

public class DoublyLinkedList<E> {

    private static class Node<E> {

        private E data;
        private Node<E> prev;
        private Node<E> next;

        public Node() {}

        public Node(E data) {
            this.data = data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getNext() {
            return next;
        }

    }

    private Node<E> header;
    private Node<E> trailer;
    private int size;

    public DoublyLinkedList() {
        header = new Node<>();
        trailer = new Node<>();
        header.setNext(trailer);
        trailer.setPrev(header);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        return header.getNext().getData();
    }

    public E last() {
        return trailer.getPrev().getData();
    }

    public void addFirst(E data) {

        Node<E> newest = new Node<E>(data);
        Node<E> head = header.getNext();

        newest.setPrev(header);
        newest.setNext(head);

        header.setNext(newest);
        head.setPrev(newest);

        size++;

    }

    public void addLast(E data) {

        Node<E> newest = new Node<E>(data);
        Node<E> tail = trailer.getPrev();

        newest.setPrev(tail);
        newest.setNext(trailer);

        trailer.setPrev(newest);
        tail.setNext(newest);

    }

    public E removeFirst() {

        E headData = header.getNext().getData();




    }

}
