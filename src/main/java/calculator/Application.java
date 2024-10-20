package calculator;

public class Application {

    public static String findCustomDelimiter(String input) {
        int startIndex;
        int endIndex;

        if (input.contains("//") && input.contains("\\n")) {
            startIndex = input.indexOf("//") + 2;
            endIndex = input.indexOf("\\n");
            if (startIndex == endIndex) {
                throw new IllegalArgumentException("구분자를 입력해주세요.");
            }
            return input.substring(startIndex, endIndex);
        }
        return "";
    }

    public static int add(String[] nums) {
        int sum = 0;

        for (String num : nums) {
            sum += parseNumber(num);
        }
        return sum;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}