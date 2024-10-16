package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    // 입력 문자열에서 구분자를 추출
    public static String[] extractSeparators(String input){
        String[] separators = new String[]{"."}; // . 으로 기본 구분자 설정
        if(customSeparators(input)){
            // 사용자 정의 구분자가 있는 경우 구분자 추가
            separators = new String[]{".",input.substring(2,3)};
        }
        return separators;
    }

    // 입력 문자열이 사용자 정의 구분자 형식을 포함 하는지 확인하는 메서드
    public static boolean customSeparators(String input){
        return input.startsWith("//") && input.contains("\\n");
    }



    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();

        // 입력이 비어있을 경우 0출력
        if(input.isEmpty()){
            System.out.println("결과:"+0);
            return;
        }

        // 구분자 추출
        String[] separators = extractSeparators(input);

    }
}
