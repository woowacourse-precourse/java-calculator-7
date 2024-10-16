package calculator;

public class InputInfo {

    private char separator;
    private String format;

    public char getSeparator() { return separator; }
    public String getFormat() { return format; }

    public void validateInput(String input) throws IllegalArgumentException {

        if(input.length() == 0) return;
        else if( '0' <= input.charAt(0) && input.charAt(0) <= '9') {
            // basic format

            return;
        }
        else if(input.length() >= 5
                && input.substring(0,2).equals("//") && input.substring(3,5).equals("\\n")
                && '0' <= input.charAt(2) && input.charAt(2) <= '9') {
            // custom format


            return;
        }
        else {
            throw new IllegalArgumentException("입력에서 구분자 형식을 찾을 수 없습니다.");
        }
    }
}
