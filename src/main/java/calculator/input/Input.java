package calculator.input;

import calculator.utils.NumUtil;
import java.util.Arrays;
import java.util.List;

public class Input {

    private static final String SEPARATOR_COMMA = ",";
    private static final String SEPARATOR_COLON = ":";
    private static final String REGEX_OR = "|";

    private final String[] strNums;
    private List<Long> numList;

    protected Input(String[] strNums) {
        this.strNums = strNums;
        initNumList(strNums);
    }

    protected Input(String strNums) {
        this(strNums.split(SEPARATOR_COMMA + REGEX_OR + SEPARATOR_COLON));
    }

    public static Input from(String value) {
        return InputFilter.parseInput(value);
    }

    private void initNumList(String[] strNums) {
        if (isZeroInput(strNums)) {
            this.numList = List.of(0L);
            return;
        }
        this.numList = null;
    }

    private static boolean isZeroInput(String[] strNums) {
        return strNums.length == 1 && strNums[0].isEmpty();
    }

    protected boolean matchesSeparator(String separator) {
        return SEPARATOR_COLON.equals(separator) || SEPARATOR_COMMA.equals(separator);
    }

    public final List<Long> toLongList() {
        if (this.numList == null) {
            this.numList = Arrays.stream(strNums).mapToLong(NumUtil::toLong).boxed().toList();
        }
        return this.numList;
    }
}
