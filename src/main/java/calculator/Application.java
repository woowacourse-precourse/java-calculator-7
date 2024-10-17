package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.lang.reflect.Array;
import java.util.*;

// 생각해야 할 경우의 수
// 아무 입력 없으면 0 출력
// 커스텀 구분자만 있고 출력 없으면 0 출력?
// 음수, 0 입력 시 예외처리 후 앱 종료


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // - 구분자를 제외한 숫자들의 ArrayList
        List<Integer> numArrayList = new ArrayList<>();
        // - 구분자들의 ArrayList
        List<String> divider = new ArrayList<>();
        // - 입력받는 문자열
        String inputString = "";
        // - 커스텀 구분자
        String customDivider = "";


        // divier에 기본 구분자 추가
        divider.add(":"); divider.add(",");

        // - 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        inputString = Console.readLine();

        // - custom 구분자를 찾아 추가
        customDivider = findDivider(inputString);
        if (customDivider != null) {
            // \n 다음의 숫자 부분 추출
            String tmpNum = inputString.substring(inputString.indexOf("\\n") + 2);

            divider.add(customDivider);
            // 구분자로 문자열 분리
            // customDivider를 기준으로 문자열을 분리

            String combinedDividers = String.join("|", divider) + "|" + customDivider;
            String[] numbers = tmpNum.split(combinedDividers);

            // 각 숫자를 정수로 변환하여 리스트에 추가
            for (String number : numbers) {
                numArrayList.add(Integer.parseInt(number.trim()));
            }

        }

        // - 출력
        System.out.println("결과 : " + inputString);
        System.out.println(divider);
        System.out.println(numArrayList);

        // Scanner 자원 해제
        Console.close();
    }

    // - 정수, 구분자를 구분하는 함수
    public static String findDivider(String input) {
        if (input.startsWith("//")) {
            int lastLineIndex = input.indexOf("\\n");
            System.out.println("lastLineIndex>>" + lastLineIndex);
            // 커스텀 구분자가 char가 아닐수 있음(2자 이상)
            if (lastLineIndex != -1 && lastLineIndex > 2) {

                return input.substring(2, lastLineIndex);
            }
        }
        return null;
    }
}
