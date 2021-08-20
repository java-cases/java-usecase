package com.usecase.hamcrestmatcher;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
public class NumberMatcher {

    //数值相关匹配符
    @Test
    public void assertCases() {
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
