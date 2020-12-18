package com.usecase.hamcrestmatcher;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

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
