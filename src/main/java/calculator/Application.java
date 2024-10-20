package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(); // 정규식 넣을 stringBuilder;

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String s = Console.readLine();  // 문자열 입력받기
        if (s.startsWith("//")) { // "//"로 시작했을 때
            int start = 2; // "//" 이후 시작 위치
            int end = s.indexOf("\\n"); // 첫 번째 "\n"을 찾고 '\'의 위치 반환
            if (end == -1) { // "\n"가 없다면
                throw new IllegalArgumentException("Invalid input."); //예외상황
            }

            String customSeparator = s.substring(start, end); // //와 \n사이 커스텀문자열
            String tail = s.substring(end + 2); // \n뒤에 문자열
            if (tail.isEmpty()) {
                System.out.print("결과 : 0");
                return;
            }
            expressionProcessing(sb, customSeparator);
            sb.deleteCharAt(sb.length() - 1); // 마지막 | 제거
            String[] split = tail.split(sb.toString());
            System.out.print("결과 : " + sumNumber(split));
        } else {
            if (s.isEmpty()) {
                System.out.print("결과 : 0");
                return;
            }
            expressionProcessing(sb, ":");
            expressionProcessing(sb, ",");
            sb.deleteCharAt(sb.length() - 1); // 마지막 | 제거
            String[] split = s.split(sb.toString());
            System.out.print("결과 : " + sumNumber(split));
        }
    }

    /*
     숫자 합 method : string[]에 있는 것들을 int로 바꾸어서 합산
     ref) integer가 아닌게 있으면 예외상황
     */
    public static int sumNumber(String[] strings) throws IllegalArgumentException {
        return Arrays.stream(strings)
                .filter(str -> !str.isEmpty()) // 빈 문자열 필터링 -> 빈 문자열은 sum이 0(조건)
                .mapToInt(str -> {
                    if (!isNumeric(str)) {
                        throw new IllegalArgumentException("Invalid input.");
                    }
                    return Integer.parseInt(str);
                })
                .sum();
    }

    /*
     숫자 확인 method : 양수인지 확인
     */
    public static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    /*
     정규식처리 method : 구분자 정규식 처리
     */
    public static void expressionProcessing(StringBuilder sb, String s) {
        String quote = Pattern.quote(s);
        sb.append(quote).append("|");
    }
}



