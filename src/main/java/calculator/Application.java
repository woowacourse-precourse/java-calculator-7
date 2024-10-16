package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        // Console.readLine()을 사용하여 사용자 입력 받기
        String input = Console.readLine();
        int sum = 0;   //합계
        StringBuilder number = new StringBuilder(); //숫자를 저장할 임시 변수

        for (int i = 0; i < input.length(); i++) { //input의 글자수만큼 반복
            char a = input.charAt(i);  //하나하나 확인
            if (a == ',') { // ','를만났을때
                sum += Integer.parseInt(number.toString()); //합계에 그전까지 나왔던 숫자를 더한다
                number.setLength(0);  //더한후 숫자를 저장한 임시 변수의 길이를 0으로 초기화
            } else {
                number.append(a);  //,가 나오지 않았다면 임시저장할 변수에 숫자 저장
            }
        }
        if (number.length() > 0) {
            sum += Integer.parseInt(number.toString()); //input의 길이만큼 다하고 구분자가 나오지않고 끝났을시 더한다
        }

        System.out.println(" 합계 : " + sum);

    }
}
