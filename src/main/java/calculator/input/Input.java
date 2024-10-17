package calculator.input;

import calculator.utils.NumUtil;
import java.util.ArrayList;
import java.util.List;

public class Input {

    private static final char SEPARATOR_COMMA = ',';
    private static final char SEPARATOR_COLON = ':';

    private final String nums;
    private List<Long> numList = null;

    protected Input(String nums) {
        this.nums = nums;
    }

    public static Input of(String input) {
        return InputFilter.from(input);
    }

    protected boolean isSeparatorEqual(char ch) {
        return ch == SEPARATOR_COLON || ch == SEPARATOR_COMMA;
    }

    public final List<Long> toLongList() {
        if (this.numList != null) {
            return this.numList;
        }
        this.numList = new ArrayList<>();
        long cur = 0L;
        boolean isPrevSeparator = false;
        for (int i = 0; i < nums.length(); i++) {
            char ch = nums.charAt(i);
            if (isSeparatorEqual(ch) && !isPrevSeparator) {
                this.numList.add(cur);
                cur = 0L;
                isPrevSeparator = true;
                continue;
            }
            cur *= 10;
            cur += NumUtil.toInt(ch);
            isPrevSeparator = false;
        }
        this.numList.add(cur);
        return this.numList;
    }
}
