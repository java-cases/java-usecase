package javax.lang;

import java.util.Optional;

public class Optionalx {

    public static <T> Optional<T> empty() {
        return Optional.empty();
    }

    public static <T> Optional<T> of(T value) {
        return Optional.of(value);
    }

    public static <T> Optional<T> ofNullable(T value) {
        return Optional.ofNullable(value);
    }
}
