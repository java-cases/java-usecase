package com.kenly.powermock;

import com.kenly.util.MockUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({MockUtil.class}) //所有需要测试的类列在此处，适用于模拟final类或有final, private, static, native方法的类
@PowerMockIgnore("javax.management.*")
public class MockUtilTest {

    @Test
    public void nextInt() {
        PowerMockito.mockStatic(MockUtil.class);
        PowerMockito.when(MockUtil.nextInt(10)).thenReturn(7);

        Assert.assertEquals(7, MockUtil.nextInt(10));
    }
}