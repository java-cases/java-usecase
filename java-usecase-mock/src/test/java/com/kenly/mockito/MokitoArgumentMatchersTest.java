package com.kenly.mockito;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MokitoArgumentMatchersTest {

    @Test
    public void thenReturnWithAnyInt() {
        LinkedList mockedList = Mockito.mock(LinkedList.class);

        //stubbing
        Mockito.when(mockedList.get(Mockito.anyInt())).thenReturn(1);

        assertEquals(1, mockedList.get(0));
        assertEquals(1, mockedList.get(1));
        assertEquals(1, mockedList.get(2));
    }

    @Test
    public void thenReturnWithAnyString() {
        Map<String, Integer> mockedList = Mockito.mock(HashMap.class);

        //stubbing
        Mockito.when(mockedList.get(Mockito.anyString())).thenReturn(1);

        assertEquals(Integer.valueOf(1), mockedList.get("1"));
        assertEquals(Integer.valueOf(1), mockedList.get("2"));
        assertEquals(Integer.valueOf(1), mockedList.get("3"));
    }

}
