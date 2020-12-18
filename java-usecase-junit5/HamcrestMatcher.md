```java
public class HamcrestMatcher {

    //一般匹配符
    @Test
    void assertCases() {Integer testedNumber = 9;

        // allOf匹配符表明如果接下来的所有条件必须都成立测试才通过，相当于“与”（&&）
        assertThat(testedNumber, Matchers.allOf(greaterThan(8), lessThan(16)));

        // anyOf匹配符表明如果接下来的所有条件只要有一个成立则测试通过，相当于“或”（||）
        assertThat(7, Matchers.anyOf(greaterThan(16), lessThan(8)));

        // anything匹配符表明无论什么条件，永远为true
        assertThat(testedNumber, Matchers.anything());

        // is匹配符表明如果前面待测的object等于后面给出的object，则测试通过
        assertThat("developerWorks", Matchers.is("developerWorks"));

        // not匹配符和is匹配符正好相反，表明如果前面待测的object不等于后面给出的object，则测试通过
        assertThat("is not developerWorks", Matchers.not("developerWorks"));
        
    }
}
```

```java
public class StringMatcher {

    //数值相关匹配符
    @Test
    void assertCases() {
        String testedString = "developerWorks";

        // containsString匹配符表明如果测试的字符串testedString包含子字符串"developerWorks"则测试通过
        assertThat(testedString, Matchers.containsString("developerWorks"));

        // endsWith匹配符表明如果测试的字符串testedString以子字符串"developerWorks"结尾则测试通过
        assertThat(testedString, Matchers.endsWith("developerWorks"));

        // startsWith匹配符表明如果测试的字符串testedString以子字符串"developerWorks"开始则测试通过
        assertThat(testedString, Matchers.startsWith("developerWorks"));

        // equalTo匹配符表明如果测试的testedValue等于expectedValue则测试通过，equalTo可以测试数值之间，字
        //符串之间和对象之间是否相等，相当于Object的equals方法
        assertThat(testedString, Matchers.equalTo("developerWorks"));

        // equalToIgnoringCase匹配符表明如果测试的字符串testedString在忽略大小写的情况下等于
        //"developerWorks"则测试通过
        assertThat(testedString, Matchers.equalToIgnoringCase("developerWorks"));

        // equalToIgnoringWhiteSpace匹配符表明如果测试的字符串testedString在忽略头尾的任意个空格的情况下等
        //于"developerWorks"则测试通过，注意：字符串中的空格不能被忽略
        assertThat(testedString, Matchers.equalToIgnoringWhiteSpace("developerWorks"));
    }
}
```

```java
public class NumberMatcher {

    //数值相关匹配符
    @Test
    void assertCases() {
        double testedDouble = 20.4;
        double testedNumber = 20.4;

        // closeTo匹配符表明如果所测试的浮点型数testedDouble在20.0±0.5范围之内则测试通过
        assertThat(testedDouble, Matchers.closeTo(20.0, 0.5));

        // greaterThan匹配符表明如果所测试的数值testedNumber大于16.0则测试通过
        assertThat(testedNumber, Matchers.greaterThan(16.0));

        // lessThan匹配符表明如果所测试的数值testedNumber小于16.0则测试通过
        assertThat(15.5, Matchers.lessThan(16.0));

        // greaterThanOrEqualTo匹配符表明如果所测试的数值testedNumber大于等于16.0则测试通过
        assertThat(16.0, Matchers.greaterThanOrEqualTo(16.0));

        // lessThanOrEqualTo匹配符表明如果所测试的数值testedNumber小于等于16.0则测试通过
        assertThat(16.0, Matchers.lessThanOrEqualTo(16.0));
    }
}
```

```java
public class CollectionMatcher {

    //collection相关匹配符
    @Test
    void assertCases() {
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
```