package calculator;

public class InputValidator {
    public void validateCustomDelimiterFormat(int startIndex, int endIndex) {
        if(startIndex+2 != endIndex-1) {
            throw new IllegalArgumentException("커스텀 구분자는 //문자\\n 형식이어야 합니다.");
        }
    }

    public void validateCustomDelimiterPosition(int startIndex, int endIndex) {
        if(startIndex != 0 || endIndex != 3) {
            throw new IllegalArgumentException("커스텀 구분자는 앞에 위치해야 합니다.");
        }
    }

    public void validateUnspecifiedCharacters(String[] splitResults) {
        for(String s : splitResults) {
            try {
                Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(e + " 숫자와 구분자만 입력할 수 있습니다.");
            }
        }
    }
}
