package orgx.spring.boot.util;

import com.google.gson.Gson;

import java.text.Normalizer;
import java.util.Objects;
import java.util.Optional;

public final class Serialization {

    public static Optional<String> toJson(Object obj) {
        Objects.requireNonNull(obj);

        Gson gson = new Gson();
        return Optional.ofNullable(gson.toJson(obj));
    }

    public static <T> Optional<T> fromJson(String json, Class<T> clazz) {
        Objects.requireNonNull(json);
        Objects.requireNonNull(clazz);

        Gson gson = new Gson();
        return Optional.ofNullable(gson.fromJson(json, clazz));
    }

    public static String normalize(CharSequence src) {
        Objects.requireNonNull(src);

        return Normalizer.normalize(src, Normalizer.Form.NFKC);
    }
}
