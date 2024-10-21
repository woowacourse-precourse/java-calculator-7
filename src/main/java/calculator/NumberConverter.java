package calculator;

public class NumberConverter {
    private static NumberConverter instance;

    private NumberConverter() {}

    public static NumberConverter getInstance() {
        if (instance == null) {
            instance = new NumberConverter();
        }
        return instance;
    }

    public int[] convertToNumberArray(String[] strings) {
        int[] arr = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            isNumeric(strings[i]);
            arr[i] = Integer.parseInt(strings[i]);
        }
        return arr;
    }

    private void isNumeric(String str) {
        if (str == null || !str.matches("\\d+")) {
            throw new IllegalArgumentException("올바르지 않은 문자가 포함되어 있습니다: " + str);
        }
    }
}
