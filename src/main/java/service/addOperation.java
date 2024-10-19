package service;

public class addOperation {
    String input;

    public addOperation(String input) {
        this.input = input;
    }

    public int add() {
        if (input == null || input.isEmpty()) { // 빈문자열일 경우 (공백이 포함되어있을 경우)
            return 0;
        }

        String delimiter = ",|:";  // 기본 구분자 쉼표와 콜론
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자가 올바르지 않습니다.");
            }
            delimiter = input.substring(2, delimiterEndIndex);
            input = input.substring(delimiterEndIndex + 1); // 구분자를 제외한 값
        }

        String[] tokens = input.split(delimiter); // 구분자 기준으로 숫자 저장하기

        int sum = 0;
        for (String token : tokens) {
            int number = Integer.parseInt(token);
            sum += number;
        }

        return sum;

    }

}
