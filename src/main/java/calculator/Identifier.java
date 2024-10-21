package calculator;

public class Identifier {
    Validator validator = new Validator();

    /**
     * 커스텀 구분자 처리를 위한 이스케이프 문자와 특수문자를 담은 문자열
     */
    static final String SPECIAL_LETTERS = "+-*/%=><'\"\\.";
    static String identifier = ",|:"; // 구분자를 모아놓은 문자열

    public String customIdentifierProcess(String str) {
        if (str.startsWith("//")) {
            int lastIndex = str.indexOf("\\n");
            validator.invalidCustomIdentifierCheck(lastIndex);
            addCustomIdentifier(str.substring(2, lastIndex));
            str = str.substring(lastIndex + 2); // 커스텀 구분자 문자열을 삭제
        }
        return str;
    }

    public void addCustomIdentifier(String custom) {
        for (char c : custom.toCharArray()) {
            if (SPECIAL_LETTERS.contains(c + "")) {
                identifier += "|\\" + c; // 특수문자는 이스케이프 처리
            } else {
                identifier += "|" + c; // 일반문자는 그대로 추가
            }
        }
    }
}
