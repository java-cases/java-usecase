package javax.org.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.lang.exception.CustomizdException;
import javax.lang.exception.ExceptionEvent;
import javax.lang.exception.ExceptionType;

public class ExceptionLog {

    private static final Logger log = LoggerFactory.getLogger(ExceptionEvent.class);

    private static void illegalArgumentMethod(int arg) {
        if (arg < 0) {
            throw new IllegalArgumentException("arg");
        }
    }

    public static void raiseIllegalArgumentException() {

        try {
            illegalArgumentMethod(-1);
        } catch (IllegalArgumentException e) {
            log.error(new CustomizdException(e.getMessage(), ExceptionType.IllegalArgument).toString());
        }

    }

    public static void raiseNumberFormatException() {

        try {
            Integer.parseInt("1s");
        } catch (NumberFormatException e) {
            log.error(new CustomizdException(e.getMessage(), ExceptionType.NumberFormat).toString());
        }

    }
}
