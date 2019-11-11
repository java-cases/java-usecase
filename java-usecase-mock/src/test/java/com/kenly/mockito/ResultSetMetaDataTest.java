package com.kenly.mockito;

import org.junit.Test;

import javax.sql.rowset.CachedRowSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class ResultSetMetaDataTest {

    @Test
    public void mockResultSetMetaData() throws SQLException {
        ResultSetMetaData mockMetaData = ResultSetMockito.mockMetaData();

        assertEquals(6, mockMetaData.getColumnCount());

        assertEquals("id", mockMetaData.getColumnName(1));
        assertEquals("last_name", mockMetaData.getColumnName(2));
        assertEquals("first_name", mockMetaData.getColumnName(3));
        assertEquals("age", mockMetaData.getColumnName(4));
        assertEquals("salary", mockMetaData.getColumnName(5));
        assertEquals("birthday", mockMetaData.getColumnName(6));
    }

    @Test
    public void mockCachedRowSet() throws SQLException {
        CachedRowSet mockCachedRowSet = ResultSetMockito.mockRowSet();

        assertEquals(true, mockCachedRowSet.next());

        assertEquals("ID1234567890", mockCachedRowSet.getObject(1));
        assertEquals("lee", mockCachedRowSet.getObject(2));
        assertEquals("ken", mockCachedRowSet.getObject(3));

        assertEquals(Integer.valueOf(20), mockCachedRowSet.getObject(4));
        assertEquals(Double.valueOf(100.5), mockCachedRowSet.getObject(5));

        assertEquals(java.sql.Timestamp.valueOf("2013-09-01 10:01:01"),
                mockCachedRowSet.getObject(6));
    }

}
