package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayFunction {
    public static int[] parseNumbersFromString(String inputVal) {

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

        int[] numberArray = new int[parseArray.length];
        for (int i = 0; i < numberArray.length; i++) {
            try {
                numberArray[i] = Integer.parseInt(parseArray[i].trim());
            } catch (NumberFormatException numberFormatException) { // 숫자에 지정기호 외 값이 있다! / 음수는 통과돼야함
                throw new IllegalArgumentException("숫자 사이에 지정하지 않은 기호가 있습니다.");
            }
        }

        return numberArray;
    }

}
