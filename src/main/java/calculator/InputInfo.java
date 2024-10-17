package calculator;

public class InputInfo {

    private String separator;
    private String format;

    public String getSeparator() { return separator; }
    public String getFormat() { return format; }

    public void validateFormat(String input) throws IllegalArgumentException {

        if(input.length() == 0) {
            separator = "";
            format = "basic";
        }

        if(input.length() > 5 && input.substring(0,2).equals("//") && input.substring(3,5).equals("\\n")) {
            /* custom format */
            separator = input.substring(2,3);
            format = "custom";
            validateNumbers(input.substring(5));
        } else {
            /* basic format */
            separator = ",:";
            format = "basic";
            validateNumbers(input);
        }
    }

    private void validateNumbers(String str) throws IllegalArgumentException {
        /*
         * [예외 발생]
         * 알맞은 구분자와 숫자 이외의 문자가 들어온 경우
         * 양의 정수가 아닌 수가 들어오는 경우
         */

        if(!str.matches("[0-9" + separator + "]+")) {
            throw new IllegalArgumentException("구분자와 숫자만 입력할 수 있습니다.");
        }

        String[] numbers = str.split("[" + separator + "]");

        for(String number : numbers) {
            System.out.println(number);
            if (!number.isEmpty()) {
                int num = Integer.parseInt(number);
                if (num <= 0) throw new IllegalArgumentException("양의 정수만 가능합니다.");
            } else {
                throw new IllegalArgumentException("구분자의 위치가 적절하지 않습니다.");
            }
        }
    }
}
