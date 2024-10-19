package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 사용자 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();

        // 기능 1: 커스텀 구분자 확인 및 전체 구분자 정의
        List<Character> seperators = getSeparator(inputString);

        // 기능 2: 사용자의 입력값 검증
        inputString = validateInputString(inputString, seperators);

        // 기능 3: 구분자를 기준으로 덧셈
        int result = sum(inputString, seperators);

        // 출력
        System.out.println("결과 : "+ result);
    }

    private static List<Character> getSeparator(String inputString){
        // 기본 구분자
        List<Character> separatorList = new ArrayList<>();
        separatorList.add(',');
        separatorList.add(':');

        // 커스텀 구분자 찾기
        String s1 = inputString.substring(0,2);
        String s2 = inputString.substring(3,5);

        if (s1.equals("//") && s2.equals("\\n")){
            char customSeparator = inputString.charAt(2);
            separatorList.add(customSeparator);
        }

        return separatorList;
    }

    private static String validateInputString(String inputString, List<Character> separators){
        // 커스텀 구분자가 있는 경우
        // 숫자인지 확인 및 커스텀 문구 삭제
        if (separators.size() == 3){
            char customSeparator = separators.get(2);

            if (Character.isDigit(customSeparator)){
                throw new IllegalArgumentException("커스텀 구분자는 숫자로 지정할 수 없습니다.");
            }
            inputString = inputString.substring(5);
        }

        // 전체 구분자 이외의 숫자가 아닌 문자 유무
        for (char c : inputString.toCharArray()){
            if (!(Character.isDigit(c) || separators.contains(c))){
                throw new IllegalArgumentException("구분자 이외의 문자가 포함되어 있습니다: "+c);
            }
        }

        return inputString;
    }

    private static int sum(String inputString, List<Character> separators){
        String[] splits =  inputString.split(separators.toString());

        int sum = 0;
        for (int i=0; i<splits.length ; i++){
            sum += Integer.parseInt(splits[i]);
        }

        return sum;
    }
}
