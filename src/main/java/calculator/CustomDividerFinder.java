package calculator;

import java.awt.*;
import java.util.List;

/**
 * 커스텀 문자는 문자열 맨 앞에 입력된다.
 * 커스텀 문자만 찾아낸다.
 * 문자열 아님 문자임
 */
public class CustomDividerFinder {
    private final static String OPENER = "//";
    private final static String CLOSER = "\n"; //todo \\n
    private final static Integer OPENER_INDEX = 0;
    private final static Integer CLOSER_INDEX = 3;
    private final static Integer CUSTOM_DIVIDER_INDEX = 2;

    public void findCustomDividers(String input, Divider divider) {
        int openerIndex = input.indexOf(OPENER);
        int closerIndex = input.indexOf(CLOSER);

        if (openerIndex == OPENER_INDEX && closerIndex == CLOSER_INDEX) {
            char charCustomDivider = input.charAt(CUSTOM_DIVIDER_INDEX);
            divider.setCustomDivider(String.valueOf(charCustomDivider));
        }
    }




}
