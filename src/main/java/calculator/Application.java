package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int sum = 0;
        char c;
        char customSep;

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputStr = readLine();

        // 정상적인 커스텀 구분자 입력이 있을 때
        Pattern customSepPattern = Pattern.compile("//.\\\\n");
        Matcher m = customSepPattern.matcher(inputStr);
        boolean isCustomForm = m.find();

        if (isCustomForm) {
            customSep = inputStr.charAt(5);
            inputStr = inputStr.substring(5);

            for (int i = 0; i < inputStr.length(); i++) {
                c = inputStr.charAt(i);

                if (i % 2 == 0) {
                    if (GetNumException.isNotNumber(inputStr) &&
                            GetNumException.isNegative(inputStr)) {
                        throw new IllegalArgumentException();
                    }

                    sum += Character.getNumericValue(c);
                }

                if (i % 2 == 1) {
                    if (GetSepException.isNotCustomSep(inputStr, String.valueOf(customSep))) {
                        throw new IllegalArgumentException();
                    }
                }
            }
        }

        if (!isCustomForm) {
            for (int i = 0; i < inputStr.length(); i++) {
                c = inputStr.charAt(i);

                if (i % 2 == 0) {
                    if (GetNumException.isNotNumber(inputStr) &&
                            GetNumException.isNegative(inputStr)) {
                        throw new IllegalArgumentException();
                    }

                    sum += Character.getNumericValue(c);
                }

                if (i % 2 == 1) {
                    if (GetSepException.isNotOriginSep(inputStr)) {
                        throw new IllegalArgumentException();
                    }
                }
            }
        }

        System.out.println("결과 : " + sum);
    }
}
