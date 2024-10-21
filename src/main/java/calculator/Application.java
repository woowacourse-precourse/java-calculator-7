package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;


public class Application {
    public static void main(String[] args) {
        String str = "//a\n12a3;4"; // 테스트용 문자열
        StringBuilder delimiters = new StringBuilder("[,;"); // 커스텀 구분자가 존재할 경우 추가하고 str.split에 사용할 수 있게 StringBuilder 타입으로

        // 커스텀 구분자 체크 및 문자열 정리
        if (str.matches("//\\D\\n.*")) {  // "//숫자가 아닌 문자\n" 형식 체크

            // "//"와 "\n" 이후의 부분만 가져옴
            String cusDelimiter = str.substring(2, 3); // 2번째 인덱스에서 단일 문자 구분자 추출
            delimiters.append(Pattern.quote(cusDelimiter)); // 커스텀 구분자 추가
            str = str.substring(str.indexOf('\n') + 1); // 숫자만 계산하기 위해 '\n' 이후의 부분만 사용
        }

        delimiters.append("]"); //  delimiters의 대괄호 닫기

        // 문자열을 구분자로 split
        String[] num = str.split(delimiters.toString());

        //계산
        int sum = 0;
        for (String cal : num) {
            sum += Integer.parseInt(cal);
        }

        System.out.println("합계: " + sum);
    }
}
