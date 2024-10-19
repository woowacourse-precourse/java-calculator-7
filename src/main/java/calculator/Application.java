package calculator;
import java.lang.System;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // 구분자 목록
        String custom_seperators;
        // 구분자로 나눠진 문자 배열
        String[] splited_by_seperators;

        // 1. 구분자를 인식하는 기능 - 커스텀 구분자가 있다면 구분자 목록에 추가
        // 2. 구분자 목록을 기반으로 입력된 문자열을 나누는 기능
        String input_string = args[0];
        String[] splited_string = input_string.split("\\\\n");
        // 커스텀 구분자가 있는 경우
        if (splited_string.length > 1 && splited_string[0].startsWith("//")){
            String separator = splited_string[0].substring(2);
            custom_seperators = ",|:|" + separator;
            splited_by_seperators = splited_string[1].split(custom_seperators);
        }
        // 커스텀 구분자가 없는 경우
        else if (splited_string.length == 1){
            custom_seperators = ",|:";
            splited_by_seperators = splited_string[0].split(custom_seperators);
        } else {
            // '\n'은 등장했으나 '//' 은 등장하지 않은 상황으로 에러처리
            throw new IllegalArgumentException("값이 잘못되었습니다");
        }
//        System.out.println(Arrays.toString(splited_string));
//        System.out.println(Arrays.toString(custom_seperators));
        System.out.println(Arrays.toString(splited_by_seperators));
    }
}
