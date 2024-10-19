package calculator;

public class Calculator {

    public static int stringSum(String input) {

        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiters = checkDelimiter(input);

        return -1;
    }

    private static String checkDelimiter(String input) {
        
        StringBuilder delimiters = new StringBuilder(); 
        
        //기본 구분자
        delimiters.append(",").append(":");

        // 커스텀 구분자
        if (input.startsWith("//")) {
            int start = 2;
            int end = input.indexOf('\n', start);

            while (end != -1) {
                String customDelimiter = input.substring(start, end);
                delimiters.append(customDelimiter);
                start = end + 1;

                if (input.startsWith("//", start)) {
                    start += 2;
                    end = input.indexOf('\n', start);
                } else {
                    break;
                }
            }
        }

        return delimiters.toString();
    }

}
