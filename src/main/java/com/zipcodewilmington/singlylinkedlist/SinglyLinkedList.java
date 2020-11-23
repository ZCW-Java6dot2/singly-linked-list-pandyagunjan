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


}



