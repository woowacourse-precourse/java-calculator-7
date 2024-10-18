package calculator;

import java.util.regex.Pattern;

public class constants {
    public static final int ZERO = 0;
    public static final String default_words = ",|:";
    public static final Pattern number_Range = Pattern.compile("^[1-9]*$");
    public static final String prefix_custom = "//";
    public static final String postfix_custom = "\\n";
    public static final String minus_Check = "-";
    public static final int start_idx = 2;
    public static final int end_idx = 3;
    public static final int number_idx = 5;
    public static final String InputMessage = "덧셈할 문자열을 입력해 주세요.";
    public static final String OutputMessage = "결과 : ";
    public static final String ErrorMessage = "사용자가 잘못된 값을 입력하였습니다.";
}
