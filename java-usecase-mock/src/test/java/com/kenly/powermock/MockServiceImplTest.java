package com.kenly.powermock;

import com.kenly.dao.MockDBMapper;
import com.kenly.model.DBModel;
import com.kenly.service.MockServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore("javax.management.*")
public class MockServiceImplTest {

    // 将@Mock注解的示例注入进来
    @InjectMocks
    private MockServiceImpl mockService;

    @Mock
    private MockDBMapper mockMapper;

    @Test
    public void count() {
        DBModel model = new DBModel();
        PowerMockito.when(mockMapper.count(model)).thenReturn(2);

        Assert.assertEquals(2, mockService.count(model));
    }
}