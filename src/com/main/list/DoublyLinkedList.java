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

        public Node(E data, Node<E> prev, Node<E> next) {

            this.data = data;
            this.prev = prev;
            this.next = next;

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

    private final Node<E> header;
    private final Node<E> trailer;
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

        Node<E> head = header.getNext();
        addBetween(data, header, head);

    }

    public void addLast(E data) {

        Node<E> tail = trailer.getPrev();
        addBetween(data, tail, trailer);

    }

    public E removeFirst() {

        Node<E> head = header.getNext();
        return remove(head);

    }

    public E removeLast() {

        Node<E> tail = trailer.getPrev();
        return remove(tail);

    }

    private void addBetween(E data, Node<E> predecessor, Node<E> successor) {

        Node<E> newest = new Node<E>(data, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);

        size++;

    }

    private E remove(Node<E> node) {

        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();

        predecessor.setNext(successor);
        successor.setPrev(predecessor);

        size--;

        return node.getData();

    }

}
