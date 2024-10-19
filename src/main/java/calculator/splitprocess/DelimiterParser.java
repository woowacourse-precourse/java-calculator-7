package calculator.splitprocess;

public class DelimiterParser {
    public static String getDelimiter(String input) {
        //입력이 비어있을경우 오류처리
        if (input.isEmpty()){
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
        //커스텀 구분자가 있는경우 처리
        if (input.startsWith("//")){
            int newlineIndex = input.indexOf("\\n");
            if (newlineIndex == -1){
                throw new IllegalArgumentException("잘못된 형식의 입력입니다.");
            }
            String customDelimiter = input.substring(2, newlineIndex);
            //특수문자 처리위해 이스케이프처리
            return escapeSpecialCharacters(customDelimiter);
        }
        return ",|:";
    }
    private static String escapeSpecialCharacters(String delimiter) {
        return delimiter.replaceAll("([*+?^${}()|\\[\\]\\\\])", "\\\\$1");
    }
}
