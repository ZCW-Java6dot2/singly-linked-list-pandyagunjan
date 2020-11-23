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


        public Node(Object dataValue) {
            next = null;
            data = dataValue;
        }
         public Node(Object dataValue,Node nextValue) {
            next = nextValue;
            data = dataValue;
        }

 }

    private Node head;

    // Default constructor
    public SinglyLinkedList() {

    }

    // appends the specified element to the end of this list.
    public void add(Object data) {

        // Initialize Node only in case of 1st element , hence checks with null
        if (head == null) {
            head = new Node(data);
        }
      //save new node with data in tempNode to append
        Node TempNode = new Node(data);
        Node currentNode = head;

        // Let's check for NPE before iterate over currentNode
        if (currentNode != null) {

            // starting at the head node, crawl to the end of the list and then add element after last node
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }

            // the last node's "next" reference set to our new node
            currentNode.setNext(TempNode);
        }

        // increment the number of elements variable
        incrementCounter();
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

    // inserts the specified element at the specified position in this list
    public void add(Object data, int index) {
        Node TempNode = new Node(data);
        Node currentNode = head;

        // Let's check for NPE before iterate over singlyLinkedCurrent
        if (currentNode != null) {
            // loop to the requested index or the last element in the list, whichever comes first
            for (int i = 0; i < index && currentNode.getNext() != null; i++) {
                currentNode = currentNode.getNext();
            }
        }

        // set the new node's next-node reference to current node's next-node reference
        TempNode.setNext(currentNode.getNext());

        // now set current node's next-node reference to the new node
        currentNode.setNext(TempNode);

        // increment the number of elements variable
        incrementCounter();
    }

    public Object get(int index)
    // returns the element at the specified position in this list.
    {
        // index must be 1 or higher
        if (index < 0)
            return null;
        Node currentNode = null;
        if (head != null) {
            currentNode = head.getNext();
            for (int i = 0; i < index; i++) {
                if (currentNode.getNext() == null)
                    return null;

                currentNode = currentNode.getNext();
            }
            return currentNode.getData();
        }
        return currentNode;

    }

    // removes the element at the specified position in this list.
    public boolean remove(int index) {

        // if the index is out of range, exit
        if (index < 1 || index > size())
            return false;

        Node currentNode = head;
        if (head != null) {
            for (int i = 0; i < index; i++) {
                if (currentNode.getNext() == null)
                    return false;

                currentNode = currentNode.getNext();
            }
            currentNode.setNext(currentNode.getNext().getNext());

            // decrement the number of elements variable
            decrementCounter();
            return true;

        }
        return false;
    }

    // returns the number of elements in this list.
    public int size() {
        return getCounter();
    }

public Boolean contains(Object o)
// returns the element at the specified position in this list.
{
    Node currentNode = head;
    for (int i = 0; i < getCounter(); i++) {

        if (currentNode.getNext() != null)
            if(currentNode.getNext().getData().equals(o))
            {
                return true;
            }
        else
            currentNode=currentNode.getNext();

    }
    return false;
    }

}



