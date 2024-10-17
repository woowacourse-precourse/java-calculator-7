package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        // Console.readLine()을 사용하여 사용자 입력 받기
        String input = Console.readLine(); //입력받을 문자열

        int sum = 0;   //합계를 저장할 변수
        int startindex = 0; // 시작인덱스
        char custom = 0; //커스텀을 저장할 인덱스
        StringBuilder number = new StringBuilder(); //임시로 숫자를 저장할 변수

        if (input.startsWith("//") && input.charAt(3) == '\\' && input.charAt(4) == 'n') {
            custom = input.charAt(2); //커스텀구분자를 지정
            startindex = 5;  //커스텀구분자가 있을시 시작인덱스를 //;\n 을 스킵
        }
        for (int i = startindex; i < input.length(); i++) { // input 문자열의 길이만큼 반복
            char a = input.charAt(i);  // 현재 문자를 하나씩 가져온다
            if (a == ',' || a == ':' || a == custom) { // 구분자를 만났을 때
                sum += Integer.parseInt(number.toString()); // 지금까지 저장한 숫자를 정수로 변환 후 합계에 더한다
                number.setLength(0);   // 숫자를 저장하던 임시 변수를 초기화
            } else {
                number.append(a);  // 구분자가 아니라면 임시 변수에 숫자를 이어 붙인다
            }
        }
        if (number.length() > 0) { // 마지막 숫자가 남아 있을 경우 처리
            sum += Integer.parseInt(number.toString()); // 마지막 남은 숫자를 합계에 더한다
        }

        System.out.println(" 합계 : " + sum); // 최종 합계를 출력

    }
}
