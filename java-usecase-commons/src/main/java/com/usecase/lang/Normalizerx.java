package com.usecase.lang;

import java.text.Normalizer;

public class Normalizerx {

    public static String normalize(CharSequence src) {
        return Normalizer.normalize(src, Normalizer.Form.NFKC);
    }

    public static boolean isNormalized(CharSequence src) {
        return Normalizer.isNormalized(src, Normalizer.Form.NFKC);
    }
}
