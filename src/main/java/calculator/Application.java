package calculator;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    // 기능 1: 커스텀 구분자 확인 및 전체 구분자 정의
    private static List<Character> getSeparator(String inputString){

        // 기본 구분자
        List<Character> separatorList = new ArrayList<>();
        separatorList.add(',');
        separatorList.add(':');

        // 커스텀 구분자 찾기
        // 커스텀 구분자는 문자열 처음에 한번만 지정되거나 없다고 가정
        String s1 = inputString.substring(0,2);
        String s2 = inputString.substring(3,5);

        if (s1.equals("//") && s2.equals("\\n")){
            char customSeparator = inputString.charAt(2);
            separatorList.add(customSeparator);
        }

        return separatorList;
    }

}
