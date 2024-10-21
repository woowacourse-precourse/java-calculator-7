package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Filter {

    //기존 구분자
    public static List<String> delimiterList = new ArrayList<String>(Arrays.asList(",", ":"));
    //커스텀 구분자
    public static List<String> customDelimiterList = new ArrayList<String>();

    public static List<Integer> doFilter(String input) {
        //TODO input 데이터를 필터를 통해 정제하여 List<Integer>로 return 해주는 메서드

        /*
          TODO 커스텀 구분자 + 구분자를 기준으로 filter 처리를 통해 정제된 값 List<Integer> 리턴 (throws 예외)
          - String 에서 // ? \n  <- 이 형태가 있다면 이걸 커스텀 구분자에 추가하고, String 에서는 제거
          - replace 함수를 통해 String 에 있는 구분자, 커스텀 구분자를 전부 공백으로 대체
          - 공백을 기준으로 문자 형태의 숫자들을 담기(문자가 있다면 예외 처리 -> 구분자,커스텀 구분자가 아닌 문자가 있었다는 것)
          - List<String> 형태에서 List<Integer>형태로 변환
          */

        System.out.println(input);



        //custom 구분자 추출 문자열 맨 앞에 위치한 "//" 과 "\n" 사이에 있는 문자를 추출해서 커스텀 구분자에 넣기
        // 커스텀 구분자 자체가 없을 수도 있음.. 그래서 있다면? 커스텀 구분자를 뽑아내기
        Pattern pattern = Pattern.compile("^//([^\\d])\\\\n");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            // String 에서 //~\n이 있다면 //~\n은 제거
            input = input.replaceAll("^//[^\\d]\\\\n", "");
            customDelimiterList.add(matcher.group(1));
        }

        //input 으로 빈 값 혹은 구분자 형태를 제거한 후가 빈 값인 경우 0으로 변환
        if (input.isEmpty()) {
            return List.of(0);
        }
        // 만약, 커스텀 구분자가 " "(공백)이 아닌데 공백이 나온다면? 예외 발생
        if (!customDelimiterList.contains(" ") && input.contains(" ")) {
            throw new IllegalArgumentException("커스텀 구분자가 공백이 아닌 경우 공백은 포함될 수 없습니다.");
        }

        // -> replace 함수가 전체를 돌면서 바꾼 String을 새로 만들어서 return , 성능쪽에서 더 좋은 방법이 있을 수도..
        for (String delimiter : delimiterList) {
            input = input.replace(delimiter, " ");
        }
        for (String customDelimiter : customDelimiterList) {
            input = input.replace(customDelimiter, " ");
        }

        //문자열의 맨 앞, 맨 뒤가 공백이라는 것은 구분자의 앞 뒤로 숫자가 없는 경우를 의미
        if (input.startsWith(" ") || input.endsWith(" ")) {
            throw new IllegalArgumentException("구분자의 앞 뒤로는 숫자가 존재해야 합니다.");
        }

        //여기까지 도달했을 때, 숫자와 공백만 있어야 하는데 -> 문자가 있다면 예외..
        if (!input.matches("[0-9 ]*")) {
            throw new IllegalArgumentException("구분자가 아닌 문자가 포함되어 있습니다.");
        }
        // 두 개 이상의 연속된 공백을 찾음 -> 연속해서 나온 구분자는 예외 처리
        if (input.contains("  ")) {
            throw new IllegalArgumentException("구분자는 연속해서 2개 이상 올 수 없음.");
        }

        //공백을 기준으로 문자 형태의 숫자를 담아서 List<String> 형태에서 List<Integer>형태로 변환
        return Stream.of(input.split(" "))
                .map(Integer::valueOf)
                .toList();
    }


}
