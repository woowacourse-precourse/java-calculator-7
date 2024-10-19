package calculator;
import java.lang.System;
import java.util.regex.Pattern;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 구분자 목록
        String custom_seperators;
        // 구분자로 나눠진 문자 배열
        String[] splited_by_seperators;

        // 사용자 input 받는 부분
        System.out.println("덧셈할 문자열을 입력해 주세요. ");

        // 1. 구분자를 인식하는 기능 - 커스텀 구분자가 있다면 구분자 목록에 추가
        // 2. 구분자 목록을 기반으로 입력된 문자열을 나누는 기능
        String input_string = Console.readLine();
        String[] splited_string = input_string.split("\\\\n");
        // 커스텀 구분자가 있는 경우
        if (splited_string.length > 1 && splited_string[0].startsWith("//")){
            String separator = splited_string[0].substring(2);
            custom_seperators = ",|:|" + separator;
            splited_by_seperators = splited_string[1].split(custom_seperators);
        }
        // 커스텀 구분자가 없는 경우
        else if (splited_string.length == 1){
            custom_seperators = "[,:]";
            splited_by_seperators = splited_string[0].split(custom_seperators);
        } else {
            // '\n'은 등장했으나 '//' 은 등장하지 않은 상황으로 에러처리
            throw new IllegalArgumentException("값이 잘못되었습니다");
        }

        // 3. 덧셈을 하는 기능
        int sum = 0;
        if (splited_by_seperators.length == 1 && splited_by_seperators[0].isEmpty()){
            System.out.println("결과 : " + sum);
        } else {
            for (String num: splited_by_seperators) {
                if (Pattern.matches("^[0-9]*$", num)){
                    sum += Integer.parseInt(num);
                } else {
                    // 양수를 제외한 다른 것이 나왔을 때 에러처리
                    throw new IllegalArgumentException("덧셈은 양수만 가능합니다 또는 구분자가 잘못되었습니다");
                }
            }
            System.out.println("결과 : " + sum);
        }
    }
}
