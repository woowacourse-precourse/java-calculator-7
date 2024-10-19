package calculator;

import java.io.IOError;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) throws IOError {
        Set<String> set = new HashSet<>(new ArrayList<>(List.of(":", ",")));

        //시작 문자열
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = readLine();

        //해당 regex가 만족하지 않는 경우 IllegalArgumentException 예외 발생
        if(!str.matches("(//\\D\\\\n)*([0-9]+)(\\D[0-9]+)*")) throw new IllegalArgumentException("입력값이 맞지 않습니다.");

        //첫 부분 패턴이 있을 경우 해당 구분자를 출력해 set에 저장
        Pattern pattern = Pattern.compile("//\\D\\\\n");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String match = matcher.group();
            String delimiter = match.replaceAll("(//|\\\\n)", "");
            //만약 구분자가 "\"인 경우 regex에서는 "\\"여야 하기 때문에 아래의 조건문 추가
            if(delimiter.startsWith("\\")) {
                set.add("\\" + delimiter);
            } else {
                set.add(delimiter);
            }
        }

        //구분자 추가하는 문자열을 전부 제거 -> 뒤에 있는 숫자 + 구분자 형식의 문자열만 남게된다.
        String removePattern = str.replaceAll("//\\D\\\\n", "");

        // set에 있는 구분자들을 이용해 regex를 만드는 과정 -> set이 [:, ., ;]인 경우 [:.;] 출력하도록 구현
        String regex = "[" + set.stream().map(String::valueOf).collect(Collectors.joining("")) + "]";

        //regex를 이용해 구분자 split을 구현
        String[] value = removePattern.split(regex);

        //try - catch 문 사용 이유: 숫자 변환 시 에러가 발생할 경우 IllegalArgumentException 예외가 발생하도록 구현.
        try{
            int sum = 0;
            for (String v : value) {
                sum += Integer.parseInt(v);
            }
            System.out.println("결과 : " + sum);
        } catch (Exception e) {
            throw new IllegalArgumentException("구분자가 포함되어 있습니다", e);
        }
    }
}
