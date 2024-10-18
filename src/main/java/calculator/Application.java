package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input = getInput(); // 문자열 입력 받기
        String delimiter = getCustomDelimiter(input);
        String[] numbers = splitString(input, delimiter);
        int sum = calculateSum(numbers);
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

    private static String[] splitString(String input, String delimiter){
        if(delimiter.equals("[,;]")) return input.split(delimiter); // 기본 구분자로 분리
        else {
            int NIndex = input.indexOf("\\n");
            String newInput = input.substring(NIndex+2); // 문자열에서 커스텀 구분자 이후 부분 추출
            return newInput.split(delimiter); // 커스텀 구분자로 분리
        }
    }

    private static int calculateSum(String[] numbers) {
        int sum = 0;

        for (String number : numbers) {
            validateNumber(number); // 숫자 유효성 검사
            sum += Integer.parseInt(number.trim()); // 숫자로 변환하여 합계 계산
        }

        return sum; // 최종 합계 반환
    }

    private static void validateNumber(String number) {
        if (number.isEmpty() || !number.matches("\\d+")) { // 숫자 유효성 검사
            throw new IllegalArgumentException("유효하지 않은 숫자입니다.");
        }
    }






}
