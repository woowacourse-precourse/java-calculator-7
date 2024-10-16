package calculator;

public class CalculatorService {
    public int returnAnswer(String answer) {
        if (answer == "") {
            return 0;
        }
        return -1;
    }

    public String getDelimiter(String input) {
        String delimiter = ",|:";
        if (input.startsWith("//") && input.contains("\n")) {
            delimiter = input.substring(2, input.indexOf("\n"));
            return delimiter;
        }
        return delimiter;
    }

    public int[] splitByDefaultDelimiter(String input) {
        String[] stringArray = input.split(getDelimiter(input));
        int[] intArrays = new int[stringArray.length];
        for (int i = 0; i < intArrays.length; i++) {
            intArrays[i] = Integer.parseInt(stringArray[i]);
        }
        return intArrays;
    }

    public int[] splitByCustomDelimiter(String input) {
        String exceptDelimiter = input.substring(input.indexOf("\n") + 1);
        String[] stringArray = exceptDelimiter.split(getDelimiter(input));
        int[] intArrays = new int[stringArray.length];
        for (int i = 0; i < intArrays.length; i++) {
            intArrays[i] = Integer.parseInt(stringArray[i]);
        }
        return intArrays;
    }

    public int plus(int[] input) {
        int sum = 0;
        for (int i : input) {
            sum += i;
        }
        return sum;
    }

    public void ensureValidInput(String input) {
        //구분자가 존재하지 않는 경우
        if (!input.contains(getDelimiter(input))) {
            throw new IllegalArgumentException("구분자가 존재하지 않습니다.");
        }
        //커스텀 구분자 중 \n을 사용하지 않음
        if (input.startsWith("//") && !input.contains("\n")) {
            throw new IllegalArgumentException("커스텀 구분자 사용이 잘못되었습니다.");
        }
        //문자열 시작이 숫자 혹은 // 이 아닌 경우
        if (Character.isDigit(input.charAt(0)) || input.startsWith("//")) {
            throw new IllegalArgumentException("잘못된 문자열 입력입니다.");
        }
        //문자열 중 구분자와 다른 문자가 섞여있을 경우
    }

}
