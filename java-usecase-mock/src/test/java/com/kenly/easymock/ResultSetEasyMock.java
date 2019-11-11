package com.kenly.easymock;

import org.easymock.EasyMock;

import javax.sql.rowset.CachedRowSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultSetEasyMock {

    public static ResultSetMetaData mockMetaData() throws SQLException {

        ResultSetMetaData mockMetaData = EasyMock.createMock(ResultSetMetaData.class);

        EasyMock.expect(mockMetaData.getColumnCount()).andReturn(6).anyTimes();

        EasyMock.expect(mockMetaData.getColumnName(1)).andReturn("id").anyTimes();
        EasyMock.expect(mockMetaData.getColumnName(2)).andReturn("last_name").anyTimes();
        EasyMock.expect(mockMetaData.getColumnName(3)).andReturn("first_name").anyTimes();
        EasyMock.expect(mockMetaData.getColumnName(4)).andReturn("age").anyTimes();
        EasyMock.expect(mockMetaData.getColumnName(5)).andReturn("salary").anyTimes();
        EasyMock.expect(mockMetaData.getColumnName(6)).andReturn("birthday").anyTimes();

        EasyMock.replay(mockMetaData);

        return mockMetaData;
    }

    public static CachedRowSet mockRowSet() throws SQLException {

        CachedRowSet rowSet = EasyMock.createMock(CachedRowSet.class);

        ResultSetMetaData mockMetaData = mockMetaData();
        EasyMock.expect(rowSet.getMetaData()).andReturn(mockMetaData).anyTimes();

        EasyMock.expect(rowSet.next()).andReturn(true).times(4).andReturn(false);

        EasyMock.expect(rowSet.getObject(1)).andReturn("ID1234567890").anyTimes();
        EasyMock.expect(rowSet.getObject(2)).andReturn("lee").anyTimes();
        EasyMock.expect(rowSet.getObject(3)).andReturn("ken").anyTimes();
        EasyMock.expect(rowSet.getObject(4)).andReturn(Integer.valueOf(20)).anyTimes();
        EasyMock.expect(rowSet.getObject(5)).andReturn(Double.valueOf(100.5)).anyTimes();
        EasyMock.expect(rowSet.getObject(6)).andReturn(java.sql.Timestamp.valueOf("2013-09-01 10:01:01")).anyTimes();
        EasyMock.replay(rowSet);

        return rowSet;
    }

}
