package calculator;
import java.lang.System;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // 구분자 목록
        String[] custom_seperators;

        // 1. 구분자를 인식하는 기능 - 커스텀 구분자가 있다면 구분자 목록에 추가
        String input_string = args[0];
        String[] splited_string = input_string.split("\\\\n");
        if (splited_string.length > 1 && splited_string[0].startsWith("//")){
            String seperator = splited_string[0].substring(2);
            custom_seperators = new String[]{",", ":", seperator};
        } else if (splited_string.length == 1){
            custom_seperators = new String[]{",", ":"};
        } else {
            // '\n'은 등장했으나 '//' 은 등장하지 않은 상황으로 에러처리
            throw new IllegalArgumentException("값이 잘못 되었습니다.");
        }
//        System.out.println(Arrays.toString(splited_string));
//        System.out.println(Arrays.toString(custom_seperators));
//        System.out.println(input_string);
    }
}
