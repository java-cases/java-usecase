package com.usecase.apache.commons.lang;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsDelegate {

    private static final int STRING_BUILDER_SIZE = 256;

    public static final String SPACE = " ";

    public static final String EMPTY = "";

    public static final String LF = "\n";

    public static final String CR = "\r";

    public static final int INDEX_NOT_FOUND = -1;

    /**
     * <p>The maximum size to which the padding constant(s) can expand.</p>
     */
    private static final int PAD_LIMIT = 8192;


    public static boolean isEmpty(final CharSequence cs) {
        return StringUtils.isEmpty(cs);
    }

    public static boolean isNotEmpty(final CharSequence cs) {
        return StringUtils.isNotEmpty(cs);
    }

    public static boolean isAnyEmpty(final CharSequence... css) {
        return StringUtils.isAnyEmpty(css);
    }

    public static boolean isNoneEmpty(final CharSequence... css) {
        return StringUtils.isNoneEmpty(css);
    }

    public static boolean isAllEmpty(final CharSequence... css) {
        return StringUtils.isAllEmpty(css);
    }

    public static boolean isBlank(final CharSequence cs) {
        return StringUtils.isBlank(cs);
    }

}
