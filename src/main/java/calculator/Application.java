package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        try {
            // 콘솔로부터 입력을 받기 위해 BufferedReader 사용
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine(); // 한 줄의 입력을 읽어옵니다.

            int result = 0; // 결과 값을 저장할 변수

            // 입력이 null이거나 공백으로만 이루어진 경우
            if (input == null || input.trim().isEmpty()) {
                result = 0; // 결과를 0으로 설정
            } else {
                String numbersStr = input; // 숫자들이 포함된 문자열
                String delimiter = "[,:]"; // 기본 구분자: 쉼표 또는 콜론

                // 입력이 "//"로 시작하면 커스텀 구분자를 사용
                if (input.startsWith("//")) {
                    int delimiterEndIndex = input.indexOf("\n"); // 구분자 끝 위치 찾기
                    if (delimiterEndIndex == -1) {
                        // 개행 문자가 없으면 예외 발생
                        throw new IllegalArgumentException("입력 오류: 커스텀 구분자 후에 개행 문자가 필요합니다.");
                    }
                    delimiter = input.substring(2, delimiterEndIndex); // 커스텀 구분자 추출
                    if (delimiter.isEmpty()) {
                        // 커스텀 구분자가 비어 있으면 예외 발생
                        throw new IllegalArgumentException("입력 오류: 커스텀 구분자가 비어 있습니다.");
                    }
                    delimiter = Pattern.quote(delimiter); // 구분자를 정규식 패턴으로 변환
                    numbersStr = input.substring(delimiterEndIndex + 1); // 숫자 부분 추출
                }

                // 구분자를 기준으로 문자열 분리
                String[] tokens = numbersStr.split(delimiter);

                // 분리된 문자열을 순회하며 합산
                for (String token : tokens) {
                    if (token.isEmpty()) {
                        // 빈 문자열이면 예외 발생
                        throw new IllegalArgumentException("입력 오류: 비어 있는 숫자가 있습니다.");
                    }
                    try {
                        int num = Integer.parseInt(token); // 문자열을 정수로 변환
                        if (num < 0) {
                            // 음수이면 예외 발생
                            throw new IllegalArgumentException("입력 오류: 음수는 허용되지 않습니다.");
                        }
                        result += num; // 결과에 합산
                    } catch (NumberFormatException e) {
                        // 숫자로 변환할 수 없으면 예외 발생
                        throw new IllegalArgumentException("입력 오류: 숫자가 아닌 값이 포함되어 있습니다.");
                    }
                }
            }

            // 최종 결과 출력
            System.out.println("결과 : " + result);
        } catch (IOException e) {
            // 입력을 읽는 중 오류가 발생한 경우 예외 처리
            System.out.println("입력 오류: 입력을 읽는 중 오류가 발생했습니다.");
        }
    }
}
