package com.kenly.powermock;

import com.kenly.service.MockServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;

@RunWith(PowerMockRunner.class)
@PrepareForTest({MockServiceImpl.class}) // 所有需要测试的类列在此处，适用于模拟final类或有final, private, static, native方法的类
@PowerMockIgnore("javax.management.*")
public class MockServiceImplNewObjectTest {

    // 将@Mock注解的示例注入进来
    @InjectMocks
    private MockServiceImpl mockService;

    @Test
    public void makeFile() throws Exception {
        File file = PowerMockito.mock(File.class);

        PowerMockito.whenNew(File.class).withArguments("path").thenReturn(file);
        PowerMockito.when(file.exists()).thenReturn(true);

        Assert.assertTrue(mockService.makeFile("path"));
    }
}