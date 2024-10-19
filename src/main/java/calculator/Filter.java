package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Filter {
    public static void main(String[] args) {
        System.out.println(doFilter("//a\n1,2,3"));
    }

    //기존 구분자
    private static List<String> delimiterList = new ArrayList<String>(Arrays.asList(",", ":"));
    //커스텀 구분자
    private static List<String> customDelimiterList = new ArrayList<String>();

    public static List<Integer> doFilter(String input) {
        //TODO input 데이터를 필터를 통해 정제하여 List<Integer>로 return 해주는 메서드
        //custom 구분자 추출 문자열 맨 앞에 위치한 "//" 과 "\n" 사이에 있는 문자를 추출해서 커스텀 구분자에 넣기

        // 커스텀 구분자 자체가 없을 수도 있음.. 그래서 있다면? 커스텀 구분자를 뽑아내기
        Pattern pattern = Pattern.compile("^//([a-zA-Z])\n");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            customDelimiterList.add(matcher.group(1));
        }

        /*
          TODO 커스텀 구분자 + 구분자를 기준으로 filter 처리를 통해 정제된 값 List<Integer> 리턴 (throws 예외)
          - String에서 // Str \n  <- 이 형태가 있다면 이걸 커스텀 구분자에 추가하고, String에서는 제거
          - replace 함수를 통해 String에 있는 구분자, 커스텀 구분자를 전부 공백으로 대체
          - 공백을 기준으로 문자 형태의 숫자들을 담기(문자가 있다면 예외 처리 -> 구분자,커스텀 구분자가 아닌 문자가 있었다는 것)
          - List<String> 형태에서 List<Integer>형태로 변환
          */

        // String 에서 //~\n이 있다면 //~\n은 제거
        if (input.matches("^//[a-zA-Z]\\n.*")) {
            // 해당 패턴을 제거하여 문자열 반환
            input = input.replaceFirst("^//[a-zA-Z]\\n", "");
        }
        
        //공백이 있으면 예외 처리 -> 모든 구분자를 ' ' 공백으로 만들기
        // -> replace 함수가 전체를 돌면서 바꾼 String을 새로 만들어서 return , 성능쪽에서 더 좋은 방법이 있을 수도..
        for (String delimiter : delimiterList) {
            input = input.replace(delimiter, " ");
        }

        //여기까지 도달했을 때, 숫자와 공백만 있어야 하는데 -> 문자가 있다면 예외..
        //공백을 기준으로 문자 형태의 숫자를 담아서 List<String> 형태에서 List<Integer>형태로 변환

        return Stream.of(input.split(" "))
                .map(Integer::valueOf)
                .toList();
    }


}
