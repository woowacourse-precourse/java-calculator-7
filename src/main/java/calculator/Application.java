package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        /** 기능 1 구현 */
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        /** 기능 2 구현 */
        String inputData = Console.readLine();

        /** 기능 3-1 구현
         * 빈 값의 경우
         */
        if (inputData.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }

        /** 기능 3-2 구현 */
        String basicDelimiter = ",|:";

        int sum = 0;

        /** 기능 3-3 구현
         * 커스텀 구분자의 경우
         */
        if (inputData.startsWith("//") && (inputData.contains("\\n"))) {
            /** "\n" 문자열의 시작 위치를 index 변수에 저장 */
            int index = inputData.indexOf("\\n");

            /** 커스텀 구분자 초기화 */
            String customDelimiter = inputData.substring(2, index);
            /** System.out.println("사용자가 설정한 커스텀 구분자는 : " + customDelimiter);    에러검증 코드 */

            /** (\n) 뒤에 있는 입력값만 분리해 realData 에 저장 */
            String realData = inputData.substring(index + 2);

            /** realData 를 커스텀 구분자를 기준으로 분리 */
            String[] separatedData = realData.split(Pattern.quote(customDelimiter));

            for (String token : separatedData) {
                List<Integer> numbers = extractPositiveInteger(token);      /** 양수 추출 메소드 호출 */
                for (int number : numbers) {
                    sum += number;
                }
            }
            System.out.println("결과 : " + sum);
        }
        /** 기능 3-4 구현
         *  기본 구분자의 경우
         */
        else if ((inputData.contains(",") || inputData.contains(":"))) {
            /** 기본 구분자를 기준으로 입력값 분리 */
            StringTokenizer seperatedData = new StringTokenizer(inputData, basicDelimiter);

            while (seperatedData.hasMoreTokens()) {
                String token = seperatedData.nextToken();
                List<Integer> numbers = extractPositiveInteger(token);          /** 양수 추출 메소드 호출 */
                for (int number : numbers) {
                    sum += number;
                }
            }
            System.out.println("결과 : " + sum);
        }
        /** 기능 3-5 구현
         * 구분자 없을 경우
         */
        else {
            if (inputData.matches("\\d+")) {                             /** 0~9의 양의 정수 형태 정규표현식 */
                System.out.println("결과 : " + inputData);
            } else {
                throw new IllegalArgumentException("잘못된 값이 입력되었습니다. 프로그램을 종료합니다.");
            }
        }
    }

    /**
     * 기능 4 구현
     */
    public static List<Integer> extractPositiveInteger(String token) {
        /** 정수 리스트 선언 */
        List<Integer> list = new ArrayList<>();

        /** 토큰이 0~9의 양의 정수이면 리스트에 추가 */
        if (token.matches("\\d+")) {
            list.add(Integer.parseInt(token));
        } else {
            /** 음수 또는 실수 발견 시 예외 발생 */
            throw new IllegalArgumentException("잘못된 값이 입력되었습니다. 프로그램을 종료합니다.");
        }

        /** 리스트를 반환 */
        return list;
    }
}