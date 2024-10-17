package calculator.input;

import calculator.utils.NumUtil;
import java.util.ArrayList;
import java.util.List;

public class Input {

    private static final char SEPARATOR_COMMA = ',';
    private static final char SEPARATOR_COLON = ':';

    private final String numStr;
    private List<Long> numList = null;

    protected Input(String numStr) {
        this.numStr = numStr;
    }

    public static Input from(String value) {
        return InputFilter.parseInput(value);
    }

    protected boolean matchesSeparator(char ch) {
        return ch == SEPARATOR_COLON || ch == SEPARATOR_COMMA;
    }

    public final List<Long> toLongList() {
        if (this.numList != null) {
            return this.numList;
        }
        this.numList = new ArrayList<>();
        long cur = 0L;
        boolean isLastSeparator = false;
        for (int i = 0; i < numStr.length(); i++) {
            char ch = numStr.charAt(i);
            if (matchesSeparator(ch) && !isLastSeparator) {
                this.numList.add(cur);
                cur = 0L;
                isLastSeparator = true;
                continue;
            }
            cur *= 10;
            cur += NumUtil.toInt(ch);
            isLastSeparator = false;
        }
        this.numList.add(cur);
        return this.numList;
    }
}
