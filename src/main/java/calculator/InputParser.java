package calculator;

public class InputParser {
    public static String[] stringParse(String str){
        if(str == null || str.isEmpty()){
            return new String[]{"0"};
        }

        if(str.startsWith("//")){
            return customParser(str);
        }else{
            return str.split(":|;");
        }
    }
    public static String[] customParser(String str){
        int idx = str.indexOf("\n");
        if(idx == -1){
            throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
        }
        String custom = str.substring(2, idx);

        return str.substring(idx + 1).split("custom");
    }
}
