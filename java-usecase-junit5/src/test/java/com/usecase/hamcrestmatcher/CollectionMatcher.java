package com.usecase.hamcrestmatcher;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
public class CollectionMatcher {

    //collection相关匹配符
    @Test
    public void assertCases() {
        Map<String, String> mapObject = new HashMap<>();
        mapObject.put("key", "value");

        List<String> iterableObject = new ArrayList<>();
        iterableObject.add("element");

        // hasEntry匹配符表明如果测试的Map对象mapObject含有一个键值为"key"对应元素值为"value"的Entry项则测试通过
        assertThat(mapObject, Matchers.hasEntry("key", "value"));

        // hasItem匹配符表明如果测试的迭代对象iterableObject含有元素“element”项则测试通过
        assertThat(iterableObject, Matchers.hasItem("element"));

        // hasKey匹配符表明如果测试的Map对象mapObject含有键值“key”则测试通过
        assertThat(mapObject, Matchers.hasKey("key"));

        // hasValue匹配符表明如果测试的Map对象mapObject含有元素值“value”则测试通过
        assertThat(mapObject, Matchers.hasValue("value"));
    }
}
