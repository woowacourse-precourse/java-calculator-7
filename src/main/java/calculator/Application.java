package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) throws IOException {
        // 버퍼리더 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        int sum = 0;

        System.out.println("덧셈할 문자열을 입력해 주세요");
        str = br.readLine();  // 한 줄 입력받기

        // 빈 문자열인 경우 합계 0 처리
        if (str.trim().isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }

        // 기본 구분자 (, :)
        String separator = "[,:]+";

        // 커스텀 구분자 처리
        if (str.startsWith("//")) {
            // 커스텀 구분자가 포함된 부분 추출
            int newlineIndex = str.indexOf("\\n"); // 문자로서 \n 위치 찾기

            // \n이 없으면 에러 처리
            if (newlineIndex == -1) {
                throw new IllegalArgumentException();
            }

            String customDelimiter = str.substring(2, newlineIndex); // "//"와 "\n" 사이의 구분자 추출

            str = str.substring(newlineIndex + 2); // 본문 문자열만 남기기 (\\n 문자 제거)

            // 기본 구분자에 커스텀 구분자를 추가
            separator = separator + "|" + customDelimiter;
        }

        // 문자열을 구분자로 분리
        String[] numbers = str.split(separator);

        // 숫자들의 합 계산
        try {
            for (String num : numbers) {
                sum += Integer.parseInt(num.trim()); // 각 숫자를 합산
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
            //return;
        }

        // 합계 출력
        System.out.println("결과 : " + sum);
    }
}
