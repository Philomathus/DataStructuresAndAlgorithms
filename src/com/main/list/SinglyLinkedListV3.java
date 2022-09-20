package com.main.list;

/**
 * Uses a head sentinel node.
 * Does not have a tail reference.
 * @param <E>
 */
public class SinglyLinkedListV3<E> {

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
    private int size;

    public SinglyLinkedListV3() {

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
        return lastNode().getData();
    }

    public void addFirst(E data) {
        addAfter(header, data);
    }

    public void addLast(E data) {
        addAfter(lastNode(), data);
    }

    public E removeFirst() {
        if(isEmpty())
            return null;

        Node<E> head = header.getNext();
        header.setNext(head.getNext());
        size--;

        return head.getData();
    }

    private void addAfter(Node<E> predecessor, E data) {

        Node<E> node = new Node<>(data);
        node.setNext(predecessor.getNext());
        predecessor.setNext(node);
        size++;

    }

    /**
     * Gives back the header sentinel node if the list is empty.
     * @return
     */
    private Node<E> lastNode() {

        Node<E> currentNode = header;
        while(currentNode.getNext() != null)
            currentNode = currentNode.getNext();

        return currentNode;
    }

}
