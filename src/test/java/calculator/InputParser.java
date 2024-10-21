package calculator;

public class InputParser {
    public int[] parse(String input) {
        String delimiter = "[,|:]"; // 기본 구분자
        String[] tokens = input.split(delimiter);
        int[] numbers = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = Integer.parseInt(tokens[i]);  // 각각의 토큰을 int 로 변환
        }

        return numbers;
    }
}
