package com.usecase.hr.service;

import com.usecase.dao.MockDBMapper;
import com.usecase.hr.model.DBModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({MockServiceImpl.class})
@PowerMockIgnore("javax.management.*")
public class MockServiceImplTest {

    @Mock
    private MockDBMapper mockMockMapper;

    @InjectMocks
    private MockServiceImpl mockServiceImplUnderTest;

    @Test
    public void testCount() {
        // Setup
        final DBModel model = new DBModel();
        model.setUUID("UUID");

        when(mockMockMapper.count(any(DBModel.class))).thenReturn(0);

        // Run the test
        final int result = mockServiceImplUnderTest.count(model);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testRemove() {
        // Setup

        // Run the test
        mockServiceImplUnderTest.remove();

        // Verify the results
    }
}
