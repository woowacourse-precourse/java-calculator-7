package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Application {
    public static void main(String[] args) {
        String a = Console.readLine();

        String separator1 = ","; // 구분자 설정
        String separator2 = ":"; // 구분자 설정2
        String separator3 = ""; // 커스텀 구분자 추가 설정, 공백으로 초기화
        String[] sepArr;
        int sum = 0;


        Pattern pattern = Pattern.compile("//(.*?)\\\\n");
        ;// "//", "\n" 사이의 문자 추출
        Matcher matcher = pattern.matcher(a);

        if (matcher.find()) {
            separator3 = matcher.group(1); // 추출된 문자가 존재한다면 구분자로 지정
            a = a.substring(matcher.end()).trim();
        }
        if (separator3.isEmpty()) {
            sepArr = a.split(separator1 + "|" + separator2); // 구분자가 없을 때
        } else {
            sepArr = a.split(separator1 + "|" + separator2 + "|" + Pattern.quote(separator3)); // 모든 구분자로 나누기
        }

        System.out.println("나뉜 이후 문자열: " + a);

        for (String numStr : sepArr) {
            try {
                sum += Integer.parseInt(numStr.trim()); // 공백 제거 후 파싱
            } catch (NumberFormatException e) {
                System.out.println("유효하지 않은 문자열이 포함되어 있습니다");
            }
        }
        System.out.println("#" + " " + sum);
    }
}
