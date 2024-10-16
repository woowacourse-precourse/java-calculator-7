package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class CalculatorController {
    private String userInput = "";
    private final String startComment = "덧셈할 문자열을 입력해 주세요.";
    private String customSeparator = ""; //사용자 커스텀 구분자
    private final String customPrefix = "//";
    private final String customSuffix = "\\n"; //todo: 정규표현식으로 custom도 만들어보기
    private final String pattern = "[,:]";
    private final String regex = "(\\d+(pattern))+\\d";
    private List<Long> nums = new ArrayList<>();

    public Long startCalculate() {
        /*
        사용자의 입력을 받는다.
        - 사용자는 계산기를 이용해 입력한 숫자의 합을 얻어낸다.
        - 사용자는 구분자와 양수로 구성된 문자열을 사용해 계산기에 입력한다.
        - 사용자는 디폴트 구분자 :와 , 를 써서 숫자를 구분할 수 있다.
        - 사용자는 커스텀 구분자도 사용할 수 있다.
        - 사용자 커스텀 구분자는 “//”, (커스텀구분자) “\\n” 사이에 위치한다.
        - 사용자가 잘못된 값을 입력하면, 계산기는 종료된다.
         */
        System.out.println(startComment);
        this.userInput = Console.readLine();
        if (userInput.startsWith(customPrefix)) {
            return customSeparator();
        }
        return defaultSeparator();
    }

    private Long defaultSeparator() {
        if (!userInput.matches(regex)) {
            throw new IllegalArgumentException();
        }
        defineNums(pattern); //todo: 디폴트 구분자가 바뀔 수도 있으니 변수 선언 필요
        CalculatingMachine calculatingMachine = new CalculatingMachine(nums);
        return calculatingMachine.calculate();
    }

    private Long customSeparator() {
        int pIndex = userInput.indexOf(customPrefix);
        int sIndex = userInput.indexOf(customSuffix);
        if (sIndex == -1 || pIndex == -1) {
            throw new IllegalArgumentException();
        }
        this.customSeparator =
                userInput.substring(pIndex + customPrefix.length(), sIndex);
        defineNums(userInput.substring(sIndex + customSuffix.length()), customSeparator);
        CalculatingMachine calculatingMachine = new CalculatingMachine(nums);
        return calculatingMachine.calculate();
    }

    private void defineNums(String str, String regex) {
        String numbers = str.replace(regex, "");
        for (int i = 0; i < numbers.length(); i++) {
            nums.add(Long.parseLong(String.valueOf(numbers.charAt(i))));
        }
    }

    private void defineNums(String regex) {
        String numbers = userInput.replaceAll(regex, "");
        for (int i = 0; i < numbers.length(); i++) {
            nums.add(Long.parseLong(String.valueOf(numbers.charAt(i))));
        }
    }
}
