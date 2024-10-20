package calculator.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

    // 디폴트 구분자
    private static final String DEFAULT_DELIMITER= ",|:";
    // 커스텀 구분자를 추출하는 정규식 패턴
    private static final Pattern CUSTOM_DELIMITER_PATTERN= Pattern.compile("//(.)\\\\n(.*)");

    // 커스텀 구분자를 추출하고 숫자 부분과 커스텀 구분자를 반환
    public List<String> customDelimiterParse(String input){
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        String customDelimiter= "";
        List<String> result = new ArrayList<>();
        System.out.println(matcher.matches());

        if (matcher.matches()){

            result.add(matcher.group(1));
            result.add(matcher.group(2));
            return result;
        }


        return result;
    }




}
