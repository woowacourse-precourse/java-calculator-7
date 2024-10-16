package calculator;

public class Separator {

    private static char CUSTOM_SEPARATOR;
    //private static Integer CUSTOM_SEPARATOR_START_INDEX;
    //private static Integer CUSTOM_SEPARATOR_END_INDEX;
    private final String LEFT_SEPARATOR = "//";
    private final String RIGHT_SEPARATOR = "\\n";
    private final char COMMA = ',';
    private final char COLON = ':';


    public Boolean isContain(char text) { // 여기서 받는 값을 char
        if (text == COLON) {
            return true;
        }
        if (text == COMMA) {
            return true;
        }
        if (text == CUSTOM_SEPARATOR){
            return true;
        }
        return false;
    }

//    public Boolean isContain(String text) {
//        findCustomSeparator(text);
//        if (text == CUSTOM_SEPARATOR) {
//            return true;
//        }
//        return false;
//    }

    public Boolean isContainCustomSeparator(String text) {
        if ((text.contains(LEFT_SEPARATOR)) || (text.contains(RIGHT_SEPARATOR))) {
            return true;
        }
        return false;
    }


    // 커스텀 구분자 제외하고 순수 문자열과 커스텀 구분자로 구성된 문자열 리턴해주는 메서드
    public String findCustomSeparator(String inputText) {
        Integer startIndex = inputText.indexOf(LEFT_SEPARATOR);
        Integer lastIndex = inputText.indexOf(RIGHT_SEPARATOR) + 2;
        CUSTOM_SEPARATOR = inputText.charAt(startIndex + 2);
        System.out.println(CUSTOM_SEPARATOR);
        String text = inputText.substring(startIndex, lastIndex);
        String result = inputText.replace(text, "");
        return result;
    }


}
