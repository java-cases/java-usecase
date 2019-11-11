package com.kenly.mockito;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

public class MockitoVerifyTest {

    @Test
    public void verify() {
        List mockedList = Mockito.mock(List.class);

        mockedList.add("item0");
        mockedList.clear();

        Mockito.verify(mockedList).add("item0");
        Mockito.verify(mockedList).clear();
    }
}
