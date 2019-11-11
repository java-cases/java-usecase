package org.owasp.esapi;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.owasp.ValidatorType;

import static org.junit.Assert.*;

public class ValidatorDelegateTest {

    private ValidatorDelegate validator = new ValidatorDelegate(new ValidatorProxy());
    private ValidatorOptions options = ValidatorOptions.builder().buildDefault();

    @Ignore
    @Test
    public void addRule() {
    }

    @Ignore
    @Test
    public void getRule() {
    }

    @Ignore
    @Test
    public void isValidInput() {
        String input = "xx@xxxx.com";
        Boolean r = validator.isValidInput(input, ValidatorType.EMAIL, options);

        Assert.assertTrue(r);
    }

    @Ignore
    @Test
    public void getValidInput() {
    }

    @Ignore
    @Test
    public void getValidDate() {
    }

    @Ignore
    @Test
    public void getValidSafeHTML() {
    }

    @Ignore
    @Test
    public void getValidCreditCard() {
    }

    @Ignore
    @Test
    public void isValidDirectoryPath() {
    }

    @Ignore
    @Test
    public void getValidDirectoryPath() {
    }

    @Ignore
    @Test
    public void isValidFileName() {
    }

    @Ignore
    @Test
    public void getValidFileName() {
    }

    @Ignore
    @Test
    public void isValidNumber() {
    }

    @Ignore
    @Test
    public void getValidNumber() {
    }

    @Ignore
    @Test
    public void isValidInteger() {
    }

    @Ignore
    @Test
    public void getValidInteger() {
    }

    @Ignore
    @Test
    public void isValidDouble() {
    }

    @Ignore
    @Test
    public void getValidDouble() {
    }

    @Ignore
    @Test
    public void isValidFileContent() {
    }

    @Ignore
    @Test
    public void getValidFileContent() {
    }

    @Ignore
    @Test
    public void isValidFileUpload() {
    }

    @Ignore
    @Test
    public void assertValidFileUpload() {
    }

    @Ignore
    @Test
    public void isValidListItem() {
    }

    @Ignore
    @Test
    public void isValidListItem1() {
    }

    @Ignore
    @Test
    public void getValidListItem() {
    }

    @Ignore
    @Test
    public void isValidHTTPRequestParameterSet() {
    }

    @Ignore
    @Test
    public void assertValidHTTPRequestParameterSet() {
    }

    @Ignore
    @Test
    public void isValidPrintable() {
    }

    @Ignore
    @Test
    public void getValidPrintable() {
    }

    @Ignore
    @Test
    public void isValidPrintable1() {
    }

    @Ignore
    @Test
    public void getValidPrintable1() {
    }

    @Ignore
    @Test
    public void isValidRedirectLocation() {
    }

    @Ignore
    @Test
    public void getValidRedirectLocation() {
    }

    @Ignore
    @Test
    public void safeReadLine() {
    }
}