package calculator;

public class Calculator {
    // 델리미터 객체, 인풋 메세지 받아서 객체 생성

    private Delimiter delimiter;
    private String input = "";
    private long result = 0L;

    public Calculator(Delimiter delimiter, String input) {
        this.delimiter = delimiter;
        this.input = input;
    }

    public long calculate() {
        if (input.isEmpty()) {
            return result;
        }

        int start = 0;
        int end = 1;

        if (delimiter.isContain(input.charAt(0))) {
            input = input.substring(1);
        }

        if (delimiter.isContain(input.charAt(input.length() - 1))) {
            input = input.substring(0, input.length() - 1);
        }

        while (end < input.length()) {
            if (delimiter.isContain(input.charAt(end))) {
                String temp = input.substring(start, end);

                try {
                    int value = Integer.parseInt(temp);
                    result += value;
                    start = end + 1;
                    end++;
                } catch (Exception e) {
                    throw new IllegalArgumentException();
                }
            }
            end++;
        }

        String temp = input.substring(start, end);

        try {
            int value = Integer.parseInt(temp);
            result += value;

        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        return result;
    }
}
