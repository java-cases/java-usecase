package com.usecase.org.log;

import org.junit.Test;

public class ExceptionLogTest {

    @Test
    public void raiseIllegalArgumentException() {
        ExceptionLog.raiseIllegalArgumentException();
    }

    @Test
    public void raiseNumberFormatException() {
        ExceptionLog.raiseNumberFormatException();
    }
}