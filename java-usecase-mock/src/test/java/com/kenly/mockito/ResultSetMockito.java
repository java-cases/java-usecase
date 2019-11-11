package com.kenly.mockito;

import org.mockito.Mockito;

import javax.sql.rowset.CachedRowSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultSetMockito {

    public static ResultSetMetaData mockMetaData() throws SQLException {

        ResultSetMetaData mockMetaData = Mockito.mock(ResultSetMetaData.class);

        Mockito.when(mockMetaData.getColumnCount()).thenReturn(6);

        Mockito.when(mockMetaData.getColumnName(1)).thenReturn("id");
        Mockito.when(mockMetaData.getColumnName(2)).thenReturn("last_name");
        Mockito.when(mockMetaData.getColumnName(3)).thenReturn("first_name");
        Mockito.when(mockMetaData.getColumnName(4)).thenReturn("age");
        Mockito.when(mockMetaData.getColumnName(5)).thenReturn("salary");
        Mockito.when(mockMetaData.getColumnName(6)).thenReturn("birthday");

        return mockMetaData;
    }

    public static CachedRowSet mockRowSet() throws SQLException {

        CachedRowSet rowSet = Mockito.mock(CachedRowSet.class);

        ResultSetMetaData mockMetaData = mockMetaData();
        Mockito.when(rowSet.getMetaData()).thenReturn(mockMetaData);

        Mockito.when(rowSet.next()).thenReturn(true);

        Mockito.when(rowSet.getObject(1)).thenReturn("ID1234567890");
        Mockito.when(rowSet.getObject(2)).thenReturn("lee");
        Mockito.when(rowSet.getObject(3)).thenReturn("ken");
        Mockito.when(rowSet.getObject(4)).thenReturn(Integer.valueOf(20));
        Mockito.when(rowSet.getObject(5)).thenReturn(Double.valueOf(100.5));
        Mockito.when(rowSet.getObject(6)).thenReturn(java.sql.Timestamp.valueOf("2013-09-01 10:01:01"));

        return rowSet;
    }

}
