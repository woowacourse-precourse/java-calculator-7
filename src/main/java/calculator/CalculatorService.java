package calculator;

public class CalculatorService {
    public int ensureValidInput(String input) {
        //숫자를 안 쓰거나 구분자 없이 그냥 숫자 하나만 작성할 경우
        if (emptyOrSingleNumberInput(input) != -1) {
            return emptyOrSingleNumberInput(input);
        }
        //기본 구분자가 존재하지 않는 경우
        if (!defaultDelimiterExistCheck(input)) {
            throw new IllegalArgumentException("구분자가 존재하지 않습니다.");
        }
        //커스텀 구분자 중 \n을 사용하지 않음
        if (input.startsWith("//") && !input.contains("\\n")) {
            throw new IllegalArgumentException("커스텀 구분자 사용이 잘못되었습니다.");
        }
        //구분자 연달아 중복 사용
        if (!duplicateUseDelimiter(input)) {
            throw new IllegalArgumentException("구분자를 연달아 사용하는 것은 불가능합니다.");
        }
        //문자열 시작이 숫자 혹은 // 이 아닌 경우
        if (!Character.isDigit(input.charAt(0)) && !input.startsWith("//")) {
            throw new IllegalArgumentException("잘못된 문자열 입력입니다.");
        }
        //문자열 중 구분자와 다른 문자가 섞여있을 경우
        if (!isArrayNumeric(input)) {
            throw new IllegalArgumentException("잘못된 문자열 입력입니다.");
        }

        if (isArrayNumeric(input)) {
            return plus(convertIntArray(splitInputByDelimiter(input)));
        }
        throw new IllegalArgumentException("오류 발생");
    }

    private int emptyOrSingleNumberInput(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        if (Character.isDigit(input.charAt(0)) && input.length() == 1) {
            return Integer.parseInt(input);
        }
        if (input.startsWith("//") && input.contains("\\n")) {
            String exceptDelimiter = input.substring(input.indexOf("n") + 1);
            if (exceptDelimiter.isEmpty()) {
                return 0;
            }
            if (exceptDelimiter.length() == 1) {
                return Integer.parseInt(exceptDelimiter);
            }
        }
        return -1;
    }

    public String getDelimiter(String input) {
        String delimiter = ",|:";
        if (input.startsWith("//") && input.contains("\\n")) {
            delimiter = input.substring(2, input.indexOf("\\n"));
            return delimiter;
        }
        return delimiter;
    }

    private boolean defaultDelimiterExistCheck(String input) {
        if (Character.isDigit(input.charAt(0))) {
            return input.contains(",") || input.contains(":");
        }
        if (input.startsWith("//") && input.contains("\\n")) {
            String exceptDelimiter = input.substring(input.indexOf("\\n") + 1);
            return exceptDelimiter.contains(getDelimiter(input));
        }
        return true;
    }

    private String[] splitInputByDelimiter(String input) {
        if (Character.isDigit(input.charAt(0))) {
            return splitByDefaultDelimiter(input);
        }
        if (input.startsWith("//") && input.contains("\\n")) {
            return splitByCustomDelimiter(input);
        }
        throw new IllegalArgumentException("잘못된 입력 형식입니다.");
    }

    private String[] splitByDefaultDelimiter(String input) {
        return input.split(getDelimiter(input));
    }

    private String[] splitByCustomDelimiter(String input) {
        String exceptDelimiter = input.substring(input.indexOf("n") + 1);
        return exceptDelimiter.split(getDelimiter(input));
    }

    private boolean duplicateUseDelimiter(String input) {
        for (String s : splitInputByDelimiter(input)) {
            if (s.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public int[] convertIntArray(String[] stringArray) {
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

    private boolean isArrayNumeric(String input) {
        String[] stringArray = splitInputByDelimiter(input);
        for (String s : stringArray) {
            if (!numberCheck(s)) {
                return false;
            }
        }
        return true;
    }

    private boolean numberCheck(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
