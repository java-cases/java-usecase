package com.usecase.mockito;

import com.usecase.hr.service.MockServiceImpl;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class MokitoStubTest {

    @Mock
    MockServiceImpl serviceImpl;

    @Test
    public void thenReturn() {
        LinkedList mockedList = Mockito.mock(LinkedList.class);

        //调用返回
        Mockito.when(mockedList.get(0)).thenReturn("item1");

        assertEquals("item1", mockedList.get(0));
        assertEquals("item1", mockedList.get(0));

        assertEquals(null, mockedList.get(1));
        assertEquals(null, mockedList.get(2));
    }

    @Test
    public void thenReturnTwice() {
        LinkedList mockedList = Mockito.mock(LinkedList.class);

        //第一次调用返回和第二次调用返回
        Mockito.when(mockedList.get(0)).thenReturn("item1").thenReturn("item2");

        assertEquals("item1", mockedList.get(0));
        assertEquals("item2", mockedList.get(0));

        assertEquals(null, mockedList.get(1));
        assertEquals(null, mockedList.get(2));
    }

    @Test(expected = RuntimeException.class)
    public void thenThrowAndRaiseException() {
        LinkedList mockedList = Mockito.mock(LinkedList.class);

        //对被测试的方法强行抛出异常
        Mockito.when(mockedList.get(0)).thenThrow(new RuntimeException());

        assertEquals(null, mockedList.get(0));
    }

    @Test(expected = RuntimeException.class)
    public void thenThrowAndThenReturn() {
        LinkedList mockedList = Mockito.mock(LinkedList.class);

        //对被测试的方法强行抛出异常
        Mockito.when(mockedList.get(0)).thenReturn("RuntimeException").thenThrow(new RuntimeException());

        assertEquals("RuntimeException", mockedList.get(0));

        assertEquals(null, mockedList.get(0));
    }

    @Test
    public void doNothing() {

        MockServiceImpl serviceImpl = Mockito.mock(MockServiceImpl.class);

        //模拟测试无返回值的方法
        Mockito.doNothing().when(serviceImpl).remove();
    }
}
