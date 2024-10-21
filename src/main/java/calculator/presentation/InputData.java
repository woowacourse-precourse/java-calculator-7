package calculator.presentation;

import static calculator.global.AffixConst.SUFFIX_CUSTOM_SEPARATOR;

public final class InputData {

    public final String value;

    public InputData(String value) {
        this.value = value;
    }

    public int lastIndexOfCustomInfo() {
        int lastIndex = value.lastIndexOf(SUFFIX_CUSTOM_SEPARATOR);
        return (lastIndex == -1) ? lastIndex : lastIndex + SUFFIX_CUSTOM_SEPARATOR.length();
    }

    public String substringBefore(final int endIndex) {
        if (endIndex == -1) {
            return "";
        }
        return value.substring(0, endIndex);
    }

    public String substringAfter(final int startIndex) {
        if (startIndex == -1) {
            return value;
        }
        return value.substring(startIndex);
    }
}
