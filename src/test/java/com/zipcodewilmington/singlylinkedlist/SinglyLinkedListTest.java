package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class SinglyLinkedListTest {
    SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
    String node1 ;
    String node2 ;
    String node3;
    @Before
    public void startup() {
        node1 = "Node1";
        node2 = "Node2";
        node3 = "Node3";
    }

    @Test
    public void addTest() {
        //Given
        //When
        singlyLinkedList.add(node1);
        singlyLinkedList.add(node2);
        singlyLinkedList.add(node3);

        //Then
        Assert.assertEquals(node1,singlyLinkedList.get(0));
        Assert.assertEquals(node2,singlyLinkedList.get(1));
        Assert.assertEquals(node3,singlyLinkedList.get(2));
    }

    @Test
    public void addAtIndexTest() {
        //Given
        singlyLinkedList.add(node1);
        //When
        singlyLinkedList.add(node2,0);
        //Then
        Object data = singlyLinkedList.get(0);
        Assert.assertEquals(node2,singlyLinkedList.get(0));
    }

    @Test
    public void getTest() {
        //Given
        singlyLinkedList.add(node1);
        //When
        singlyLinkedList.add(node2,0);
        //Then
        Assert.assertEquals(node2,singlyLinkedList.get(0));
    }
    @Test
    public void getTestNot0() {
        //Given
        //When
        singlyLinkedList.add(node2);
        singlyLinkedList.add(node1,1);
        //Then
        Assert.assertEquals(node1,singlyLinkedList.get(1));
    }
    @Test
    public void removeTest() {
        //Given

        singlyLinkedList.add(node1);
        singlyLinkedList.add(node2);
        singlyLinkedList.add(node3);
        //When
        singlyLinkedList.remove(1);
        //Then
        Assert.assertEquals(node2,singlyLinkedList.get(1));
//        Assert.assertEquals(2,singlyLinkedList.size());
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
    //When
    singlyLinkedList.clear();
    singlyLinkedList.add(node1);
    singlyLinkedList.add(node2);
    singlyLinkedList.add(node3);

    int actual = singlyLinkedList.size();
    //Then
    Assert.assertEquals(3,actual);

}
    @Test
    public void copyTest() {
        //When
        singlyLinkedList.clear();
        singlyLinkedList.add(node1);
        singlyLinkedList.add(node2);
        singlyLinkedList.add(node3);

        SinglyLinkedList actual =  singlyLinkedList.copy();
        //Then
        Assert.assertEquals(singlyLinkedList.get(0), actual.get(0));
        Assert.assertEquals(singlyLinkedList.get(1), actual.get(1));
        Assert.assertEquals(singlyLinkedList.get(2), actual.get(2));

    }
    @Test
    public void findTest() {
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
        int actual = singlyLinkedList.find(node2);
    //    Boolean actual1 = singlyLinkedList.contains(node4);
        //Then
        Assert.assertEquals(2,actual);
      //  Assert.assertEquals(false,actual1);
    }
    @Test
    public void sliceTest() {
        //When
        singlyLinkedList.clear();
        singlyLinkedList.add(node1);
        singlyLinkedList.add(node2);
        singlyLinkedList.add(node3);
        String node4 = "Node4";
        singlyLinkedList.add(node4);
        String node5 = "Node5";
        singlyLinkedList.add(node5);
        SinglyLinkedList actual = singlyLinkedList.slice(2, 4);
        //Then
        Assert.assertEquals(singlyLinkedList.get(2), actual.get(0));
        Assert.assertEquals(singlyLinkedList.get(3), actual.get(1));
    }
        @Test
        public void sortTest() {
            //When
            singlyLinkedList.add(node1);
            singlyLinkedList.add(node2);
            String node4 = "Node4";
            singlyLinkedList.add(node4);
            singlyLinkedList.add(node3);
            String node5 = "Node5";
            singlyLinkedList.add(node5);


          //  SinglyLinkedList actual =
            singlyLinkedList.sort(singlyLinkedList);
            SinglyLinkedList expected=new SinglyLinkedList();;
            expected.add(node1);
            expected.add(node2);
            expected.add(node3);
            expected.add(node4);
            expected.add(node5);
            //Then
            Assert.assertEquals(singlyLinkedList.get(2), expected.get(2));
            Assert.assertEquals(singlyLinkedList.get(3), expected.get(3));

    }

}