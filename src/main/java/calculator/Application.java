package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    private static final String CUSTOM_SEPARATOR_REGEX = "//(.*?)\\\\n";

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        String[] splitArr = splitInput(input);
        for (int i = 0; i < splitArr.length; i++) {
            System.out.print(splitArr[i] + " ");
        }

    }

    private static String[] splitInput(String input) {
        String separator1 = ","; // 구분자 설정
        String separator2 = ":"; // 구분자 설정2
        String separator3 = ""; // 커스텀 구분자 추가 설정, 공백으로 초기화

        Pattern pattern = Pattern.compile(CUSTOM_SEPARATOR_REGEX); // "//", "\n" 사이의 문자 추출
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            separator3 = matcher.group(1); // 추출된 문자가 존재한다면 구분자로 지정
            input = input.substring(matcher.end()).trim(); // 구분자 지정하는 구간 삭제
        }

        if (separator3.isEmpty()) { // 커스텀 구분자가 있는 경우, 없는 경우 나눠서 return
            return input.split(separator1 + "|" + separator2); // 구분자가 없을 때
        } else {
            return input.split(separator1 + "|" + separator2 + "|" + Pattern.quote(separator3)); // 모든 구분자로 나누기
        }

    }
}