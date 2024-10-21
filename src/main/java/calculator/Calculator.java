package calculator;

public class Calculator {

    public int calculator(String input) {

        // input없으면 0을 리턴
        if (input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";
        String numberString = input;

        // "//"로 시작하고 "\n"으로끝나는 문자열일 시 그 사이값 구하기
        if (input.startsWith("//")) {

            int delimiterIndex = input.indexOf("\\n");
            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
            }
            delimiter = input.substring(2, delimiterIndex);
            numberString = input.substring(delimiterIndex + 2);
        }

        //String delimiter로 자르기
        String[] numbers = numberString.split(delimiter);

        //공백 제거
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i].trim();
        }
        return sumString(numbers);
    }

    //잘린 String 더하기
    private int sumString(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            try {
                if(number.isEmpty()){
                    continue;
                }
                int num = Integer.parseInt(number);

                //음수면 예외발생
                if (num < 0) {
                    throw new IllegalArgumentException("양수를 입력 해 주세요:" + number);
                }
                sum += num;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자 형식입니다: " + number);
            }
        }
        return sum;
    }
}
