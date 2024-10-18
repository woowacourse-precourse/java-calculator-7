package calculator;

public class CustomDelimeterParser {
    public static void parse(String inputStr, String delimiter) {
        if(inputStr.startsWith("//")){
            String[] split_str = inputStr.split("\\\\n");
            if(split_str.length ==2){
                String customDelimiter = split_str[0].substring(2);
                delimiter += "|" + customDelimiter;
                inputStr = split_str[1];
            }else {
                throw new IllegalArgumentException("커스텀 구분자는 //와 \\n사이에 존재해야합니다. ");
            }
        }
    }
}
