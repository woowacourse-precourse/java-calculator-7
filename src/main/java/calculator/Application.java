package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);

        System.out.println("덧셈할 문자열을 입력해 주세요.\n");
        String input = scanner.nextLine();

        // 커스텀 구분자 추출
        String delimiter = "[,:]";  // 기본 구분자
        if (input.startsWith("//")) {
            String[] splitInput = input.split("\\\\n");  // "\n"을 기준으로 두 부분으로 분리

            if (splitInput.length < 2) {
                throw new IllegalArgumentException("입력값 에러 발생: \\n이 누락되었습니다.");
            }

            String customDelimiter = splitInput[0].substring(2);  // "//" 이후 구분자 추출
            delimiter = "[" + customDelimiter + ",:]";  // 구분자 설정
            input = splitInput[1];  // 본문 추출
        }

        String[] parts = input.split(delimiter);
        int sum = 0;

        for(String part : parts) {
            try {
                //숫자라면 더하기
                if(Integer.parseInt(part) < 0) {
                    throw new IllegalArgumentException("입력값 에러 발생 : 양수만 입력 가능합니다.");
                }else {
                    sum += Integer.parseInt(part);
                }
            } catch (NumberFormatException e ) {
                //숫자가 아니라면 에러 처리
                throw new IllegalArgumentException("입력값 에러 발생 : " + part + "는 숫자가 아닙니다.");
            }
        }
        System.out.println("결과 : " + sum);
    }

}
