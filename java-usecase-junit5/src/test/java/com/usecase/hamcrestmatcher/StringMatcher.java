package com.usecase.hamcrestmatcher;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThat;

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
