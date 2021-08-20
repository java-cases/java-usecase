package com.usecase;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class ValidatorDelegateTest {

    private ValidatorDelegate validator = new ValidatorDelegate(new ValidatorProxy());
    private ValidatorOptions options = ValidatorOptions.builder().buildDefault();

    @Test
    public void addRule() {
    }

    @Test
    public void getRule() {
    }


    @Test
    public void isValidInput() {
        String input = "xx@xxxx.com";
        Boolean r = validator.isValidInput(input, ValidatorType.EMAIL, options);

        assertThat(r, Matchers.is(true));
    }

    @Test
    public void getValidInput() {
    }

    @Test
    public void getValidDate() {
    }

    @Test
    public void getValidSafeHTML() {
    }

    @Test
    public void getValidCreditCard() {
    }

    @Test
    public void isValidDirectoryPath() {
    }

    @Test
    public void getValidDirectoryPath() {
    }

    @Test
    public void isValidFileName() {
    }

    @Test
    public void getValidFileName() {
    }

    @Test
    public void isValidNumber() {
    }

    @Test
    public void getValidNumber() {
    }

    @Test
    public void isValidInteger() {
    }

    @Test
    public void getValidInteger() {
    }

    @Test
    public void isValidDouble() {
    }

    @Test
    public void getValidDouble() {
    }

    @Test
    public void isValidFileContent() {
    }

    @Test
    public void getValidFileContent() {
    }

    @Test
    public void isValidFileUpload() {
    }

    @Test
    public void assertValidFileUpload() {
    }

    @Test
    public void isValidListItem() {
    }

    @Test
    public void isValidListItem1() {
    }

    @Test
    public void getValidListItem() {
    }

    @Test
    public void isValidHTTPRequestParameterSet() {
    }

    @Test
    public void assertValidHTTPRequestParameterSet() {
    }

    @Test
    public void isValidPrintable() {
    }

    @Test
    public void getValidPrintable() {
    }

    @Test
    public void isValidPrintable1() {
    }

    @Test
    public void getValidPrintable1() {
    }

    @Test
    public void isValidRedirectLocation() {
    }

    @Test
    public void getValidRedirectLocation() {
    }

    @Test
    public void safeReadLine() {
    }
}