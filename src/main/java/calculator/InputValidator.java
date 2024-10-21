package calculator;

public class InputValidator {
    String input;
    Delimiter delimiter;

    /**
     * 구성자
     * @param input 입력받은 문자열
     */
    public InputValidator(String input) {
        this.input = input;
        delimiter = new Delimiter(input);
    }

    /**
     * 구분자, 커스텀 구분자, 숫자가 아닌 값이 입력된 경우
     * 커스텀 구분자의 "//" 만 입력되고 "\n"은 입력되지 않은 경우
     * @throws IllegalArgumentException
     */
    public void isValidateInput() throws IllegalArgumentException{
        if(input.startsWith("//") && !input.contains("\\n")) {
            throw new IllegalArgumentException("커스텀 구분자의 닫는 문자열이 없습니다.");
        }

        int i = 0;
        if(input.startsWith("//")) {
            i = input.indexOf("\\n") + 2;
        }
        for(; i < input.length(); i ++) {
            if(!isNumber(input.charAt(i)) &&
                    !delimiter.isDelimiter(input.charAt(i)) &&
                    (i+delimiter.getCustomDelimiterLength() < input.length() && !delimiter.isCustomDelimiter(input.substring(i, i+delimiter.getCustomDelimiterLength())))) {
                throw new IllegalArgumentException("입력에 구분자, 숫자가 아닌 문자가 존재합니다.");
            }
        }
    }

    /**
     * 주어진 문자가 숫자인지 여부 반환
     * @param character 주어진 문자
     * @return 숫자인지 여부
     */
    private boolean isNumber(Character character) {
        return character >= '0' && character <= '9';
    }
}
