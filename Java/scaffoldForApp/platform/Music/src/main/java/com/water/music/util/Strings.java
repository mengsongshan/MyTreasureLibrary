package com.water.music.util;

import java.util.Collection;

public final class Strings {

    public static String nullToEmpty(String string) {
        return string == null ? "" : string;
    }

    public static String emptyToNull(String string) {
        return isNullOrEmpty(string) ? null : string;
    }

    public static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static boolean notInCollection(String source, Collection<String> targetList){
        return targetList.contains(source);
    }
}
