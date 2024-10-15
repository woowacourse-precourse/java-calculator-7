package util;

public class DelimiterParser {
    // 구분자를 반환하는 메서드
    public String getDelimiter(String input) throws IllegalArgumentException{
        isValidDelimiter(input);

        // 커스텀 구분자가 있는 경우
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\\n");
            String customDelimiter = input.substring(2, newlineIndex);
            return customDelimiter + "|,|:";
        }

        // 커스텀 구분자가 없을 경우 기본 구분자만 반환
        return ",|:";  // 기본 구분자
    }

    public String getNumbersString(String input) {
        if (input.startsWith("//")) {
            return input.substring(input.indexOf("\\n") + 2);  // 줄바꿈 이후의 문자열 반환
        }
        return input;
    }

    public void isValidDelimiter(String input) throws IllegalArgumentException{
        if(input.startsWith("//")){
            int newlineIndex = input.indexOf("\\n");
            if(newlineIndex == -1) {
                throw new IllegalArgumentException("\n 없음");
            }
        }
    }
}
