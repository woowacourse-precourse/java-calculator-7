package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {

        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();
            //입력이 0일 경우, 결과는 0을 출력
            if(input.equals(""))
            {
                System.out.printf("결과 : 0\n");
                return;
            }

            // 첫 글자와 마지막 글자가 1~9 사이인지 확인 ==> 커스텀 구분자 지정이 없는 경우
            if (BetweenOneAndNine(input.charAt(0)) && BetweenOneAndNine(input.charAt(input.length() - 1))) {

                String[] splitInput = input.split("[:,]");
                int sum = 0;

                for (String value : splitInput) {
                    try{
                        int number = Integer.parseInt(value);
                        if (number < 1 || number > 9) { // 1~9 사이에 있는지 확인 -> 양수 외에 잘못된 입력을 체크
                            throw new IllegalStateException("1부터 9까지의 범위 외의 숫자가 포함되어 있습니다: " + number);
                        }
                        sum += number;
                    }catch(Exception e){
                        throw new IllegalStateException("잘못된 결과");
                    }
                }
                System.out.printf("결과: %d\n", sum); // 합계 출력
            //커스텀 구분자 지정이 있는 경우
            } else if (input.startsWith("//") && input.contains("\\n")) {
                // 커스텀 구분자 추출



            } else { //잘못된 입력일 경우
                throw new IllegalStateException("잘못된 형식의 입력입니다.");
            }

        } catch (IllegalStateException e) {
            throw new IllegalArgumentException();
        }
    }

    // 1~9 사이의 숫자인지 확인하는 메서드
    private static boolean BetweenOneAndNine(char ch) {
        return ch >= '1' && ch <= '9';
    }

    // 커스텀 구분자를 추출하는 메서드
    public static String extractDelimiter(String text) {
        // 찾고자 하는 시작 패턴과 끝 패턴
        String startPattern = "//";
        String endPattern = "\\n";

        // 시작 패턴과 끝 패턴의 위치를 찾기
        int startIndex = text.indexOf(startPattern);
        int endIndex = text.indexOf(endPattern);

        if (startIndex != -1 && endIndex != -1 && endIndex > startIndex) {
            // 시작 패턴 바로 뒤부터 끝 패턴 전까지의 문자열 추출
            return text.substring(startIndex + startPattern.length(), endIndex);
        } else {
            // 패턴이 없거나 잘못된 경우 null 반환
            return null;
        }
    }



}
