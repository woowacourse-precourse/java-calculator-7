package calculator.calculator.utils;

public class NumberExtractor {

    public static final String DEFAULT_SEPARATOR = "[,:]+";

    public int[] extractNumbersWithDefaultSeparator(String source) throws IllegalArgumentException{
        if (source.equals("")) {
            return new int[1];
        }

        String[] extractNumbers = source.split(DEFAULT_SEPARATOR);

        int size = extractNumbers.length;
        int[] numbers = new int[size];
        try {
            for (int i = 0; i < size; i++) {
                int number = Integer.parseInt(extractNumbers[i]);
                if(number < 0) throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
                numbers[i] = number;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }

        return numbers;
    }


    public int[] extractNumbersWithCustomSeparator(String source) throws IllegalArgumentException{
        int start = source.indexOf("//") + 2;
        int end = source.indexOf("\\n");

        String delimiter = "";
        if (start != -1 && end != -1) {
            delimiter = source.substring(start, end);
        } else {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }

        String customRegex = new StringBuilder().append("[").append(delimiter).append("]+").toString();

        String validSource = source.substring(end + 2);
        String[] extractNumbers = validSource.split(customRegex);

        int size = extractNumbers.length;
        int[] numbers = new int[size];
        try {
            for (int i = 0; i < size; i++) {
                int number = Integer.parseInt(extractNumbers[i]);
                if(number < 0) throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
                numbers[i] = number;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }

        return numbers;
    }
}
