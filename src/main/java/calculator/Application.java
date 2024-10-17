package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    // 구분자로 나누어 배열로 저장
    public String[] splitNumbers(String input){
        if(input == null || input.isEmpty()){
            throw new IllegalArgumentException("입력 값이 비어있습니다.");
        }
        String delimiter = ",|:";
        String numbers = input;

        // 커스텀 구분자 처리("//"으로 시작하는 값)
        if(input.startsWith("//")) {
            int customIndex = input.indexOf("\\n");
            // 커스텀 구분자가 없을 때 예외 처리
            if (customIndex == -1) {
                throw new IllegalArgumentException("잘못된 형식입니다. 알맞는 커스텀 형식을 입력해주세요.");
            }
            // 커스텀 문자 추출하여 구분자에 추가
            String customDelimiter = input.substring(2, customIndex);
            delimiter = delimiter + "|" + customDelimiter;
            numbers = input.substring(customIndex + 2); // 커스텀 뒷 부분 추출
        }
        return numbers.split(delimiter);
    }

    // 나누어진 배열의 합 구하기
    public int sumNumbers(String[] numbers){
        int sum = 0;
        for (String number: numbers){
            if(!number.matches("\\d+")){ // 양수만 허용
                throw new IllegalArgumentException("올바른 형식으로 입력해주세요.");
            }
            int num = Integer.parseInt(number);
            sum += num;
        }
        return sum;
    }

    // 문자열 덧셈 계산기
    public int calculate(String input) {
        // 2. 사용자 입력 구분자 기준 배열로 나누기
        String[] numbers = splitNumbers(input);

        // 3. 나누어진 배열 값 더하기
        return sumNumbers(numbers);
    }


    public static void main(String[] args) {
        Application application = new Application();

        // 1. 입력 받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 문자열 덧셈 계산 결과
        int result = application.calculate(input);

        System.out.println("결과 : " + result);
    }
}
