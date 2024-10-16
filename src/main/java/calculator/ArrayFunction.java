package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayFunction {
    public static String[] parseNumbersFromString(String inputVal) {

            String[] parseArray;
            String customSymbol = "";
            if(inputVal.startsWith("//")){// 커스텀 기호 포함!
                // 우선 특수기호를 구한다.
                Pattern pattern = Pattern.compile("//(.*?)\\\\n");
                Matcher matcher = pattern.matcher(inputVal);

                while (matcher.find()) {
                    customSymbol = matcher.group(1);
                }

                inputVal = inputVal.replaceAll("//.*?\\\\n", "");
            }

            if(customSymbol.equals("")){
                parseArray = inputVal.split("[:|,]");
            }else{
                parseArray = inputVal.split("[:|,|"+ customSymbol + "]");
            }

            return parseArray;
        }

}
