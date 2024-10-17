package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();
        input = input.isEmpty() ? "0" : input;
        String delimiter = "";


        if(input.contains("\\n")) {
            delimiter = getDelimiter(input.substring(0, input.indexOf("\\n") + 2) );
            //System.out.println(input.indexOf("\\\\n"));
            input = input.substring(input.indexOf("\\n") + 2);
        } else {
           delimiter = getDelimiter("");
        }

        int answer = 0;
        String[] nums = input.split(delimiter);

        try {
            for (String str : nums) {
                //양수가 아니면 예외 처리
                int i = Integer.parseInt(str);
                if(i < 0) {
                    throw new IllegalArgumentException();
                }
                answer += i;
            }
            System.out.printf("결과 : %d\n", answer);
        } catch (Exception e) {
            System.out.println("잘못된 값을 입력하셨습니다");
            throw new IllegalArgumentException();
        }
    }

    // 여기 matcher 오류 났던거 있었음 => match find안해서
    public static String getDelimiter(String input) {

        List<String> delimiters = new ArrayList<>(List.of(",", ":"));

        Pattern pattern = Pattern.compile("//([^.$|()\\[\\]\\\\{^?*+]+)\\\\n");
        //Pattern pattern = Pattern.compile("//(.+)\\n");

        //Pattern pattern = Pattern.compile("//([^.$|()\\[\\]\\\\{^?*+]+)\\n", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(input);
        //System.out.println("Pattern: " + pattern.toString());
        if (matcher.find()) {
            //System.out.println(matcher.group(0)); // 매칭된 전체 문자열 출력
            //System.out.println("매칭된 문자열 " + matcher.group(1)); // 캡처된 그룹(abc) 출력
            String group = matcher.group(1);
            delimiters.addAll(List.of(group.split("")));
            //System.out.println(matcher.group(2)); // 캡처된 그룹(abc) 출력
        }

        //Pattern pattern = Pattern.compile("//([^.$|()\\[\\]\\\\{^?*+]+)\n");

        /*Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String group = matcher.group(1);
            delimiters.addAll(List.of(group.split("")));
        }*/
        return String.join("|", delimiters);
    }
}
