package calculator;

public class Application {
    private static final String DEFAULT_SEPARATOR = "[,:]";
    private static final String CUSTOM_SEPARATOR_START_VALUE = "//";
    private static final String CUSTOM_SEPARATOR_END_VALUE = "\\n";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static int sumInputValue(String input) {
        boolean isCustomSeparator = input.startsWith(CUSTOM_SEPARATOR_START_VALUE);
        String separator = DEFAULT_SEPARATOR;

        if(isCustomSeparator) {
            int i = input.indexOf(CUSTOM_SEPARATOR_END_VALUE);
            if(i == -1) {
                throw new IllegalArgumentException();
            }

            separator =  input.substring(CUSTOM_SEPARATOR_START_VALUE.length(), i);
            input = input.substring(i + CUSTOM_SEPARATOR_END_VALUE.length());
        }

        String[] stringNumbers = input.split(separator);
        int sum = 0;

        for (String s : stringNumbers) {
            try {
                int num = Integer.parseInt(s);

                if(num < 0) {
                    throw new IllegalArgumentException();
                }

                sum += num;
            } catch (NumberFormatException e){
                throw new IllegalArgumentException();
            }
        }
        return sum;
    }
}
