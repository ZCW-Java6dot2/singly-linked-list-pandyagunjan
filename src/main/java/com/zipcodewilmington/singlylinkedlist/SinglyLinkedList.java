package com.zipcodewilmington.singlylinkedlist;

import javax.swing.*;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList {

    private static int counter;

    // Inner class Node with getter and setter for the data and next
    class Node {
        Object data;
        Node next;

        public Node(Object dataValue) {
            next = null;
            data = dataValue;
        }

        public Node(Object dataValue, Node nextValue) {
            next = nextValue;
            data = dataValue;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }


    }

    private Node head;

    // Default constructor
    public SinglyLinkedList() {

    }

    //counter handling
    private static int getCounter() {
        return counter;
    }

    private static void incrementCounter() {
        counter++;
    }

    private void decrementCounter() {
        counter--;
    }

    public void add(Object data) {
        //if no node in linkedlist , create and make new as head
        if (head == null) {
            head = new Node(data);
        }
        Node tempNode = new Node(data);
        Node currentNode = head;

        //if first node present , loop through the list will getNext== null , and then setNext to the tempNode created with new data
        if (currentNode != null) {
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(tempNode);
        }
        //increment counter , which will help us to get size
        incrementCounter();
    }

    public void add(Object data, int index) {
        //if no node in linkedlist , create and make new as head
        if (head == null) {
            head = new Node(data);
        }
        Node tempNode = new Node(data);
        Node currentNode = head;

        //if first node present , loop through the list will getNext== null and i < index
        if (currentNode != null) {
            for (int i = 0; i < index && currentNode.getNext() != null; i++) {

                currentNode = currentNode.getNext();
            }
            //set the node's next node reference to current node's next ref.
            tempNode.setNext(currentNode.getNext());
            //set current node's next to new node.
            currentNode.setNext(tempNode);

        }
        //increment counter , which will help us to get size
        incrementCounter();
    }


    public Object get(int index)
    // returns the element at the specified position in this list.
    {
        if (head == null) {
           return null;
        }
        Node currentNode = head;
        if (head != null) {
            currentNode = head;
            for (int i = 0; i <= index ; i++) {
                if(currentNode.getNext()!= null) {
                    currentNode = currentNode.getNext();
                }

            }
            Object obj=currentNode.getData();
            return obj;
        }
        return null;
    }

}

