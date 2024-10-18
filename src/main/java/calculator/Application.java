package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input = getInput(); // 문자열 입력 받기
        String delimiter = getCustomDelimiter(input);
    }

    private static String getInput() {
        System.out.print("덧셈할 문자열을 입력해 주세요: ");
        String input = Console.readLine();
        validation(input);//유효한지 검사
        return input;
    }
    private static void validation(String input) {
        if (input == null || input.isEmpty()) { // 비어 있는지 확인
            throw new IllegalArgumentException("문자열이 비어있습니다.");
        }
    }
    private static String getCustomDelimiter(String input){
        if(input.startsWith("//")){
            int Nindex = input.indexOf("\\n");
            return input.substring(2,Nindex);//커스텀 구분자
        }
        return "[,;]";//기본 구분자
    }





}
