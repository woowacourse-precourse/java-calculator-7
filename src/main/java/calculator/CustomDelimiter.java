package calculator;

import java.util.regex.Pattern;

public class CustomDelimiter extends BasicDelimiter{

    @Override
    public String[] splitInput(String input){
        if(input.startsWith("//")){
            int delimiterEndIdx = input.indexOf("\\n"); // "\n" 위치 찾기
            String customDelimiter = input.substring(2, delimiterEndIdx); // 커스텀 구분자 추출

            if(input.length() <= delimiterEndIdx + 1) { // "\n" 이후 계산할 부분 없으면 빈문자열 return
                return new String[]{""};
            }

            String calculatePart = input.substring(delimiterEndIdx + 2);  // 계산할 부분 추출

            return calculatePart.split(getBasicDelimiter() + "|" + Pattern.quote(customDelimiter));
            // Pattern.quote : 특수 문자 이스케이프 처리
        }

        // 커스텀 구분자가 없는 경우
        return super.splitInput(input);
    }
}
