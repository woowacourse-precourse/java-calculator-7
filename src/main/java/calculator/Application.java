package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = readLine();
        try {
            // 결과 출력
            System.out.printf("결과 : %d%n", createSeparator(inputString));
        } catch (IllegalArgumentException e){
            System.err.println("예외 발생: " + e.getMessage());
        }
    }

    private static int createSeparator(String inputString){
        // 입력값이 없을 경우
        if (inputString.length() == 0){
            return 0;
        }

        // 정규표현식 생성 및 입력 값과 일치하는 부분 찾기
        Pattern pattern = Pattern.compile("//(.*?)\n");
        Matcher matcher = pattern.matcher(inputString.replace("\\n", "\n"));

        // 구분자 ArrayList 생성 및 기본 구분자 추가
        ArrayList<String> separatorList = new ArrayList<>();
        separatorList.add(":");
        separatorList.add(",");

        // 커스텀 구분자 공백으로 대체 및 커스텀 구분자 추가
        while (matcher.find()) {
            inputString = inputString.replace(matcher.group(0).replace("\n", "\\n"), " ");
            separatorList.add(matcher.group(1));
        }

        // 구분자를 공백으로 대체
        for (String i : separatorList){
            inputString = inputString.replace(i, " ");
        }

        // 공백기준으로 배열 생성
        String[] calArray = inputString.split(" ");

        // 음수가 배열에 남아있는 경우 예외처리
        if (inputString.contains("-")){
            throw new IllegalArgumentException("음수가 포함되어 있으면 안 됩니다.");
        }

        // 0이 배열에 남아있는 경우 예외처리
        boolean hasZero = Arrays.asList(calArray).contains("0");
        if (hasZero){
            throw new IllegalArgumentException("0이 포함되어 있으면 안 됩니다.");
        }

        // 숫자들의 합
        int sumNumbers = 0;

        // 구분자가 아닌 문자가 배열에 남아있는 경우 예외처리
        for (String i : calArray){
            for (char j : i.toCharArray()){
                if (!Character.isDigit(j)){
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
