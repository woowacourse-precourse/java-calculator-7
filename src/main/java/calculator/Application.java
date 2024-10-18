package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        //입력 받는 객체 scanner 생성
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();

        //구분자 추가하기
        ArrayList<String> seperatorList = new ArrayList<String>();
        seperatorList.add(",");
        seperatorList.add(":");
        String op = ",|:";
        //새로 등록할 구분자 있나 확인
        if (input.length() >= 5) {
            String front = input.substring(0, 2);
            String back = input.substring(3, 5);
            //제대로된 형식 사이에 구분자가 끼어있는지 verify
            if (front.equals("//") && back.equals("\\n")) {
                seperatorList.add(Character.toString(input.charAt(2)));
                op += "|";
                op += Character.toString(input.charAt(2));
                input = input.substring(5);
            }
        }

        // 구분자 제외하고 남은 숫자 배열에 담는 기능
        String[] number = input.split(op);
        ArrayList<String> numbers = new ArrayList<>();

        for(int i = 0; i < number.length; i++) {
            if(!number[i].equals("")){
                numbers.add(number[i]);
            }
        }

        // 배열에 담겨있는 숫자 더하는 기능
        stringCal cal = new stringCal();
        String sum = "0";
        for (String i : numbers) {
            sum = cal.numCal(sum, i);
        }

        //출력 로직
        System.out.println("결과 : " + sum);
    }
}
