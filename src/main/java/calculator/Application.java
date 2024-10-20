package calculator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = readLine();
        System.out.printf("결과 : %d%n", createSeparator(inputString));
    }

    private static int createSeparator(String inputString){
        // 입력값이 없을 경우
        int lenString = inputString.length();
        if (lenString == 0) {
            return 0;
        }

        // 커스텀 구분자를 찾기 위한 정규표현식 생성
        Pattern pattern = Pattern.compile("//(.*?)\n");
        Matcher matcher = pattern.matcher(inputString.replace("\\n", "\n"));

        // 구분자 ArrayList 생성 및 기본 구분자 추가
        ArrayList<String> separatorList = new ArrayList<>();
        separatorList.add(":");
        separatorList.add(",");

        // 커스텀 구분자 ,로 대체 및 커스텀 구분자 추가
        while (matcher.find()) {
            inputString = inputString.replace(matcher.group(0).replace("\n", "\\n"), ",");
            separatorList.add(matcher.group(1));
        }

        // 모든 구분자를 ,로 대체
        for (String i : separatorList) {
            inputString = inputString.replace(i, ",");
        }

        // 음수가 문자열에 남아있는 경우 예외처리
        if (inputString.contains("-")) {
            throw new IllegalArgumentException("음수가 포함되어 있으면 안 됩니다.");
        }

        // 0이 문자열에 남아있는 경우 예외처리
        if (inputString.matches(".*\\b0\\b.*")) {
            throw new IllegalArgumentException("0이 포함되어 있으면 안 됩니다.");
        }

        // "," 기준으로 숫자 배열 만들기
        String[] calArray = inputString.split(",");

        // 숫자들의 합
        int sumNumbers = 0;

        // 구분자가 아닌 문자가 배열에 남아있는 경우 예외처리 및 숫자들의 합 계산
        for (String i : calArray) {
            for (char j : i.toCharArray()) {
                if (!Character.isDigit(j)) {
                    throw new IllegalArgumentException("구분자가 아닌 문자가 포함되어 있으면 안 됩니다.");
                }
            }
            if (i.length() != 0) {
                sumNumbers += Integer.parseInt(i);
            }
        }
        return sumNumbers;
    }
}
