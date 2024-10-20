package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        // 구분자 배열 생성 및 기본 구분자 추가
        ArrayList<Character> delimiters = new ArrayList<>();
        delimiters.add(',');
        delimiters.add(':');

        try{
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = br.readLine();

            if (input.isEmpty()){
                System.out.println(result);
                return;
            }

            boolean prev = true;
            int number = 0;
            int pos = 0;
            boolean flag = false;

            // 커스텀 구분자 지정 기능, 정상 진행시 반복문 시작점을 변경
            if (input.charAt(0) == '/'){
                flag = true;
                if (input.charAt(1) == '/'){
                    if (input.charAt(3) == '\\') {
                        if (input.charAt(4) == 'n') {
                            delimiters.add(input.charAt(2));
                            pos = 5;
                            flag = false;
                        }
                    }
                }
            }

            // 커스텀 구분자 지정중 오류 발생시 작동
            if (flag){
                throw new IllegalArgumentException("잘못된 커스텀 구분자 지정입니다.");
            }

            for (int i = pos; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (delimiters.contains(ch)) { // 현재 문자가 구분자일경우, 이전 문자가 구분자였을 시 오류 발생, 아닐 시 숫자를 결과에 더하고 초기화
                    if (prev) {
                        throw new IllegalArgumentException("구분자를 연속으로 사용했습니다.");
                    }
                    prev = true;
                    result += number;
                    number = 0;
                } else if (Character.isDigit(ch)) { // 현재 문자가 숫자일시 char값을 int로 변환하고, 기존 숫자의 자릿수를 올리고 더함
                    int num = ch - '0';
                    number = number * 10 + num;
                    prev = false;
                } else {
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }
            }

            if (prev){
                throw new IllegalArgumentException("문자열의 마지막이 구분자입니다.");
            } else { // 반복문 종료 후 남은 숫자 더하기
                result += number;
            }

        } catch (IOException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        // 결과 출력
        System.out.println("결과 : " + result);
    }
}
