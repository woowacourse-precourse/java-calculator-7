package calculator;


import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        // Console.readLine()으로 사용자로부터 입력 받기
        String input = Console.readLine();

        String separator = "[,:]";
        String numbers_string = input;

        // 커스텀 구분자가 있는지 확인
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\n"); // 첫 번째 줄바꿈 문자의 인덱스 찾기
            if (newlineIndex != -1) {  // 줄바꿈 문자가 있는 경우에만
                // 커스텀 구분자 추출 및 숫자 부분 분리
                separator = input.substring(2, newlineIndex); //줄바꿈 전까지의 문자열을 구분자로 설정
                numbers_string = input.substring(newlineIndex + 1);
            }
            // 숫자 배열 생성
            String[] tokens = numbers_string.split(separator);
            int[] numbers = getNumbers(tokens);
        }


    }

    private static int[] getNumbers(String[] tokens) {
        int[] numbers = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = Integer.parseInt(tokens[i]);
        }
        return numbers;
    }
}
