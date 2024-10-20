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

        // 추출한 커스텀 구분자와 숫자부분을 리스트에 담음
        if (matcher.matches()){

            result.add(matcher.group(1));
            result.add(matcher.group(2));
            return result;
        }


        return result;
    }

    //문자 나누기기
    public List<String> splitNumber(String input){
        String delimiter = DEFAULT_DELIMITER;
        //커스텀 구분자가 존재하면  커스텀 구분자 파싱 실행
        if (input.startsWith("//")){

            List<String> customDelimiterParse = customDelimiterParse(input);
            delimiter += "|";
            delimiter += customDelimiterParse.get(0);
            input = customDelimiterParse.get(1);
        }

        String[] tokens = input.split(delimiter);

        List <String> result =new ArrayList<>();

        for (String token : tokens) {
            if (!token.isEmpty()) {
                result.add(token);
            }
        }

        return result;


    }



}
