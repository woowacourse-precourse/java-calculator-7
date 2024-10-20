package calculator;

import java.util.regex.Pattern;

public class SplitText {
    public static String[] textSplit(String text) {
        int firstGubunja = text.split("//").length;
        int secondGubunja = text.split("\\\\n").length;
        if (firstGubunja > 1 && secondGubunja > 1) {
            String[] textSplitFirst = text.split("//");
            String[] textSplitSecond = textSplitFirst[1].split("\\\\n");
            String gubunja = textSplitSecond[0];
            return textSplitSecond[1].split(Pattern.quote(gubunja));
        } else if (firstGubunja > 1 && secondGubunja == 1) {
            throw new IllegalArgumentException("입력된 구분자가 잘못 입력되었습니다. 확인 후 다시 입력해주세요.");
        } else if (firstGubunja == 1 && secondGubunja > 1) {
            throw new IllegalArgumentException("입력된 구분자가 잘못 입력되었습니다. 확인 후 다시 입력해주세요.");
        } else {
            return text.split("[:,]");
        }
    }
}
