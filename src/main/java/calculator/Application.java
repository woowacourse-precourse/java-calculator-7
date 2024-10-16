package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    static String sepeartor = ",|:";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 문자열 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();

        // 커스텀 구분자
        boolean isCustomSeparator = false;
        if (str.contains("//") && str.contains("\\n")) {
            isCustomSeparator = getCustomSeparator(str);
        }

        // 숫자 추출
        str = getNumbers(str);

        // 결과 출력
        System.out.println("결과 : " + str);
    }

    /**
     * 커스텀 구분자를 추출하는 함수 정규식을 활용함
     *
     * @param str 입력받은 문자열
     * @return 커스텀 구분자의 유무
     */
    private static boolean getCustomSeparator(String str) {
        Pattern pattern = Pattern.compile("//(.*?)\\\\n");
        Matcher matcher = pattern.matcher(str);

        boolean found = false;

        while (matcher.find()) { //일치하는 게 있다면
            found = true;

            sepeartor += "|" + matcher.group(1);
            //System.out.println("추출된 구분자: " + sepeartor);
        }
        return found;
    }

    private static String getNumbers(String str) {
        return str;
    }
}
