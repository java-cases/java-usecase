package com.usecase.lang.exception;

import org.junit.Assert;
import org.junit.Test;

public class ExceptionEventTest {

    @Test
    public void raiseArrayIndexOutOfBoundsException() {
        try {
            ExceptionEvent.raiseArrayIndexOutOfBoundsException();
        } catch (CustomizdException e) {
            System.out.println(e);

            Assert.assertEquals(ExceptionType.ArrayIndexOutOfBounds, e.getExceptionType());
        }

    }

    @Test
    public void raiseStringIndexOutOfBoundsException() {
        try {
            ExceptionEvent.raiseStringIndexOutOfBoundsException();
        } catch (CustomizdException e) {
            System.out.println(e);

            Assert.assertEquals(ExceptionType.StringIndexOutOfBounds, e.getExceptionType());
        }
    }

    @Test
    public void raiseArithmeticException() {
        try {
            ExceptionEvent.raiseArithmeticException();
        } catch (CustomizdException e) {
            Assert.assertEquals(ExceptionType.Arithmetic, e.getExceptionType());
        }
    }

    @Test
    public void raiseNullPointerException() {
        try {
            ExceptionEvent.raiseNullPointerException();
        } catch (CustomizdException e) {
            Assert.assertEquals(ExceptionType.NullPointer, e.getExceptionType());
        }
    }

    @Test
    public void raiseClassNotFoundException() {
        try {
            ExceptionEvent.raiseClassNotFoundException();
        } catch (CustomizdException e) {
            System.out.println(e);
            Assert.assertEquals(ExceptionType.ClassNotFound, e.getExceptionType());
        }
    }

    @Test
    public void raiseIllegalArgumentException() {
        try {
            ExceptionEvent.raiseIllegalArgumentException();
        } catch (CustomizdException e) {
            System.out.println(e);
            Assert.assertEquals(ExceptionType.IllegalArgument, e.getExceptionType());
        }
    }

    @Test
    public void raiseNumberFormatException() {
        try {
            ExceptionEvent.raiseNumberFormatException();
        } catch (CustomizdException e) {
            System.out.println(e);
            Assert.assertEquals(ExceptionType.NumberFormat, e.getExceptionType());
        }
    }

    @Test
    public void raiseClassCastException() {
        try {
            ExceptionEvent.raiseClassCastException();
        } catch (CustomizdException e) {
            System.out.println(e);
            Assert.assertEquals(ExceptionType.ClassCast, e.getExceptionType());
        }
    }

}