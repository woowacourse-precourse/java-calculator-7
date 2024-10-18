package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final String DELIMITER = ",|:";
        String numRegEx = "[0-9]+"; //^[0-9]*$


        String[] splitNumbers = new String[]{};
        int[] num = new int[]{};
        int sum = 0;

        // 문자열 입력
        // - 안내문 출력
        System.out.println("덧셈할 문자열을 입력해주세요.");
        // - 입력 받기
        String numbers = Console.readLine();
        // - 예외처리
        // -- 숫자와 구분자만 포함하는지 판단

        // 숫자 추출
        // 정규 표현식 패턴 컴파일
        Pattern pattern = Pattern.compile(DELIMITER);
        Matcher matcher = pattern.matcher(numbers);

        // - 지정 구분자로 분리
        if (matcher.find()) {
            Pattern patternNum = Pattern.compile(numRegEx);
            Matcher matcherNum = patternNum.matcher(numbers);
            if (matcherNum.find()) { // 문자 형태의 숫자를 검토해야하는 거였음
                splitNumbers = numbers.split(DELIMITER);
                num = Arrays.stream(splitNumbers).mapToInt(Integer::parseInt).toArray();
                for (int i : num) {
                    sum += i;
                }
            }
        }
        System.out.println("결과 : " + sum);

        // - 커스텀 구분자

        // 문자 -> 숫자 형변환

        // 계산 기능 구현

        // 결과 출력
    }
}
