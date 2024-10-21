package calculator;

public class Parsing {
    private String defaultDelimiter = "[,:]";//기본 구분자

    public int[] parseInput(String input) {
        String[] tokens;
        String delimiter = defaultDelimiter;

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException();//구분자 형식 잘못됨
            }

            delimiter = input.substring(2, delimiterEndIndex);  //커스텀 구분자 추출

            if (delimiter.isEmpty()) {
                throw new IllegalArgumentException(); //구분자가 공백으로 입력 안된경우
            }

            delimiter = defaultDelimiter + "|" + delimiter;


            input = input.substring(delimiterEndIndex + 2);  //구분자를 제외하고 실제 숫자 부분 추출
        }

        tokens = input.split(delimiter, -1);
        return convertToIntArray(tokens);
    }

    private int[] convertToIntArray(String[] tokens) {
        int[] numbers = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].trim().isEmpty()) {  //빈 값 또는 공백인 경우
                numbers[i] = 0;  //빈 값은 0으로 처리
            } else {
                try {
                    numbers[i] = Integer.parseInt(tokens[i].trim());
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException();//잘못된 숫자가 포함
                }
            }
        }
        return numbers;
    }
}

