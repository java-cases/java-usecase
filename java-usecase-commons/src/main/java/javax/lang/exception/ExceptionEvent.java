package javax.lang.exception;

import java.util.Arrays;

public class ExceptionEvent {


    public static void raiseArrayIndexOutOfBoundsException() throws CustomizdException {
        int[] numbers = new int[10];
        Arrays.fill(numbers, 0);

        try {
            int first = numbers[-1];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new CustomizdException(e.getMessage(), ExceptionType.ArrayIndexOutOfBounds);
        }

        try {
            int last = numbers[10];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new CustomizdException(e.getMessage(), ExceptionType.ArrayIndexOutOfBounds);
        }
    }

    public static void raiseStringIndexOutOfBoundsException() throws CustomizdException {
        int[] numbers = new int[10];
        Arrays.fill(numbers, 0);

        try {
            char c = "text".charAt(-1);
        } catch (StringIndexOutOfBoundsException e) {
            throw new CustomizdException(e.getMessage(), ExceptionType.StringIndexOutOfBounds);
        }

        try {
            char c = "text".charAt(4);
        } catch (StringIndexOutOfBoundsException e) {
            throw new CustomizdException(e.getMessage(), ExceptionType.StringIndexOutOfBounds);
        }
    }

    public static void raiseArithmeticException() throws CustomizdException {

        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            throw new CustomizdException(e.getMessage(), ExceptionType.Arithmetic);
        }

    }

    public static void raiseNullPointerException() throws CustomizdException {

        try {
            String s = null;
        } catch (NullPointerException e) {
            throw new CustomizdException(e.getMessage(), ExceptionType.NullPointer);
        }

    }

    public static void raiseClassNotFoundException() throws CustomizdException {

        try {
            Class.forName("ExceptionEvent");
        } catch (ClassNotFoundException e) {
            throw new CustomizdException(e.getMessage(), ExceptionType.ClassNotFound);
        }

    }

    private static void illegalArgumentMethod(int arg) {
        if (arg < 0) {
            throw new IllegalArgumentException("arg");
        }
    }

    public static void raiseIllegalArgumentException() throws CustomizdException {

        try {
            illegalArgumentMethod(-1);
        } catch (IllegalArgumentException e) {
            throw new CustomizdException(e.getMessage(), ExceptionType.IllegalArgument);
        }

    }

    public static void raiseNumberFormatException() throws CustomizdException {

        try {
            Integer.parseInt("1s");
        } catch (NumberFormatException e) {
            throw new CustomizdException(e.getMessage(), ExceptionType.NumberFormat);
        }

    }

    public static void raiseClassCastException() throws CustomizdException {

        try {
            Object obj = "1s";
            Integer i = (Integer) obj;
        } catch (ClassCastException e) {
            throw new CustomizdException(e.getMessage(), ExceptionType.ClassCast);
        }

    }
}
