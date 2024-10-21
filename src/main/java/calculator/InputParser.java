package calculator;

public class InputParser {
    public static String[] stringParse(String str){
        if(str == null || str.isEmpty()){
            return new String[]{"0"};
        }

        if(str.startsWith("//")){
            return customParser(str);
        }else{
            return str.split(":|,");
        }
    }
    public static String[] customParser(String str) {
        int idx = str.indexOf("\\n");
        if (idx == -1) {
            throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
        }
        String custom = str.substring(2, idx);
        if (custom.length() != 1) {
            throw new IllegalArgumentException("커스텀 구분자는 한 글자여야 합니다.");
        }
        return str.substring(idx + 2).split("\\Q" + custom + "\\E");
    }
}
