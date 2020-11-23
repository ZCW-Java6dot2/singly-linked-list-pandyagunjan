package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class SinglyLinkedListTest {

    @Test
    public void addTest() {
        //Given
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        String expected = "Node1";
        //When
        singlyLinkedList.add(expected);
        //Then
        Assert.assertEquals(expected,singlyLinkedList.get(0));
    }

    @Test
    public void addAtIndexTest() {
        //Given
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        String node1 = "Node1";
        String expected = "Node2";
        singlyLinkedList.add(node1);
        //When
        singlyLinkedList.add(expected,0);
        //Then
        Assert.assertEquals(expected,singlyLinkedList.get(0));
    }

    @Test
    public void getTest() {
        //Given
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        String node1 = "Node1";
        String expected = "Node2";
        singlyLinkedList.add(node1);
        //When
        singlyLinkedList.add(expected,0);
        //Then
        Assert.assertEquals(expected,singlyLinkedList.get(0));
    }

    @Test
    public void removeTest() {
        //Given
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        String node1 = "Node1";
        String node2 = "Node2";
        String node3 = "Node3";
        singlyLinkedList.add(node1);
        singlyLinkedList.add(node2);
        singlyLinkedList.add(node3);

        //When
        singlyLinkedList.remove(1);
        //Then
        Assert.assertEquals(node3,singlyLinkedList.get(1));
    }
    @Test
    public void containsTest() {
        //Given
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        String node1 = "Node1";
        String node2 = "Node2";
        String node3 = "Node3";
        String node4 = "Node4";
        singlyLinkedList.add(node1);
        singlyLinkedList.add(node2);
        singlyLinkedList.add(node3);

        //When
        Boolean actual = singlyLinkedList.contains(node2);
        Boolean actual1 = singlyLinkedList.contains(node4);
        //Then
        Assert.assertEquals(true,actual);
        Assert.assertEquals(false,actual1);
    }

    @Test
    public void sizeTest() {
        //Given
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        String node1 = "Node1";
        String node2 = "Node2";
        String node3 = "Node3";
        singlyLinkedList.add(node1);
        singlyLinkedList.add(node2);
        singlyLinkedList.add(node3);

        //When
        int actual = singlyLinkedList.size();

        //Then
        Assert.assertEquals(3,actual);

    }

}