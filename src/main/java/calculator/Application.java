package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args){
        // TODO: 프로그램 구현

        // 입력을 요청하는 문자열 출력
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        // 입력 받아서 String에 저장
        String string = Console.readLine();

        // custom 구분자를 저장할 char 변수 선언 후 임의의 문자 1로 초기화
        char custom = '1';

        // custom 구분자가 주어진다는 표식이 있을 경우 custom 변수에 custom 구분자를 저장하고 문자열은 구분자 관련 문자 이후로 자름
        if (string.charAt(0)=='/') {
            custom = string.charAt(2);
            string = string.substring(5);
        }

        // 만약 커스텀 구분자가 할당되지 않고 초기 값인 1인 경우 원래 있는 구분자인 : 로 다시 지정(이렇게 하면 뒤의 로직에서 중복 체크해도 됨)
        if (custom=='1') {
            custom = ':';
        }

        // 답을 저장할 int 변수 생성
        int answer = 0;

        // 여러 자리 숫자일 수도 있으니 숫자를 만들 StringBuilder 선언
        StringBuilder sb = new StringBuilder();

        // 문자열 순회하며 검사
        for (int i=0;i<string.length();i++) {
            char c= string.charAt(i);
            int n = c-'0';
            // 숫자일 경우 StringBuilder에 넣음
            if (0<=n && n<=9) {
                sb.append(c);
                // 구분자일 경우 지금까지 만든 숫자를 결과값에 더함
            } else if (c==',' || c==':' || c==custom){
                if (!sb.isEmpty()) {
                    answer += Integer.parseInt(sb.toString());
                    sb = new StringBuilder();
                }
                // 둘 다 아닐 경우 에러 발생
            } else {
                throw new IllegalArgumentException();
            }
        }
        // 마지막에 만들어진 숫자 결과값에 더하기
        if (!sb.isEmpty()) {
            answer += Integer.parseInt(sb.toString());
        }

        // 결과값 출력
        System.out.println(answer);
    }
}
