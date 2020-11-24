package com.zipcodewilmington.singlylinkedlist;

import javax.swing.*;
import java.util.LinkedList;

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
        // Initialize Node only incase of 1st element
        if (head == null) {
            head = new Node(data);
        }

        Node temp = new Node(data);
        Node current = head;

        // Let's check for Null before iterate over Current
        if (current != null) {

            // starting at the head node, crawl to the end of the list and then add element after last node
            while (current.getNext() != null) {
                current = current.getNext();
            }

            // the last node's "next" reference set to our new node
            current.setNext(temp);
        }

        // increment the number of elements variable
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
            for (int i = 0; i <= index; i++) {
                if (currentNode.getNext() != null) {
                    currentNode = currentNode.getNext();
                }

            }
            Object obj = currentNode.getData();
            return obj;
        }
        return null;
    }


    public int size() {
        return getCounter();
    }

    public void remove(int index) {
        Node currentNode;
        if (head != null) {
            currentNode = head;
            for (int i = 0; i <= index; i++) {
                if (currentNode.getNext() != null) {
                    currentNode = currentNode.getNext();
                }

            }
            currentNode.setNext(currentNode.getNext().getNext());
            // return obj;
        }
        decrementCounter();


    }

    public Boolean contains(Object o) {
        Node currentNode;
        if (head != null) {
            currentNode = head;
            for (int i = 0; i <= size() && currentNode.getNext() != null; i++) {
                if (currentNode.getData().equals(o)) {

                    return true;
                }
                currentNode = currentNode.getNext();
            }

        }
        return false;
    }

    public SinglyLinkedList copy() {
        SinglyLinkedList copyList = new SinglyLinkedList();
        Object tempNode = null;
        Node currentNode =head.getNext();
      //  copyList.head =  head.getNext();
        //if first node present , loop through the list will getNext== null , and then setNext to the tempNode created with new data
            if (currentNode != null) {
                //currentNode=currentNode.getNext();
                while (currentNode.getNext() != null) {
                    tempNode=currentNode.getData();
                    copyList.add(tempNode);
                   currentNode = currentNode.getNext();
                }
               // currentNode.setNext(tempNode);
            }
                return copyList;
     }


        public void clear()
        {
            head = null;
            counter = 0;
        }


}

