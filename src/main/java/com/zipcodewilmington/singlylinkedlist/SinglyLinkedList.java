package com.zipcodewilmington.singlylinkedlist;

import javax.swing.*;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList implements Comparable {

    private static int counter;

    @Override
    public int compareTo(Object o) {
        return 0;
    }


    // Inner class Node with getter and setter for the data and next
    class Node {
        Object data;
        Node next;
//test
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
        // Initialize Node only when first node
        if (head == null) {
            head = new Node(data);
        }

        Node temp = new Node(data);
        Node current = head;


        if (current != null) {

          //Browse through elements to reach the end
            while (current.getNext() != null) {
                current = current.getNext();
            }

            // Finally add the last node
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
    public int find(Object o) {
        Node currentNode;
        if (head != null) {
            currentNode = head;
            for (int i = 0; i <= size() && currentNode.getNext() != null; i++) {
                if (currentNode.getData().equals(o)) {

                    return i;
                }
                currentNode = currentNode.getNext();
            }

        }
        return 0;
    }
    public SinglyLinkedList copy() {
        SinglyLinkedList copyList = new SinglyLinkedList();
        Object tempNode = null;
        Node currentNode =head.getNext();

            if (currentNode != null) {
                //currentNode=currentNode.getNext();
                while (currentNode.getNext() != null) {
                    tempNode=currentNode.getData();
                    copyList.add(tempNode);
                   currentNode = currentNode.getNext();
                }
                copyList.add(currentNode.getData());
            }
                return copyList;
     }

    public SinglyLinkedList slice(int start ,int end) {
        SinglyLinkedList sliceList = new SinglyLinkedList();
        Object tempNode = null;
        Node currentNode =head.getNext();

        if (currentNode != null) {
             for(int i=0 ;i <end  ;i++) {
                 if(i >= start) {
                     tempNode = currentNode.getData();
                     sliceList.add(tempNode);
                     currentNode = currentNode.getNext();
                 }
                 else
                 {
                     currentNode = currentNode.getNext();
                 }
            }

        }
        return sliceList;
    }

    public SinglyLinkedList sort() {
        SinglyLinkedList copyList = new SinglyLinkedList();
        Object tempNode = null;
        Node currentNode =head.getNext();

        if (currentNode != null) {
            //currentNode=currentNode.getNext();
            while (currentNode.getNext() != null) {
             //   tempNode=currentNode;
                currentNode = currentNode.getNext();

              if(tempNode.compare(currentNode))

                copyList.add(tempNode);
                currentNode = currentNode.getNext();
            }
            copyList.add(currentNode.getData());
        }
        return copyList;


    }

        public void clear()
        {
            head = null;
            counter = 0;
        }

}

