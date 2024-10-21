package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.math.BigInteger;
import java.util.Set;

import static calculator.separatorParser.SeparatorParser.parseSeparator;
import static calculator.endIndexFinder.EndIndexFinder.findSeparatorEndIndex;
import static calculator.add.Add.processNumber;

public class Application {

    public static void main(String[] args) {
        String input = Console.readLine(); // 입력
        int endIndex = findSeparatorEndIndex(input); // 커스텀 구분자 입력의 끝부분('\n' 다음 인덱스)
        Set<String> separatorSet = parseSeparator(input, endIndex); // 구분자를 전부 모아놓을 Set
        String afterSeparator = endIndex <= input.length() - 1 ? input.substring(endIndex) : ""; // 커스텀 구분자 입력 이후의 문자열

        BigInteger ans = processNumber(afterSeparator, separatorSet); // 합을 저장할 결과값
        System.out.println("결과 : " + ans); // 출력
    }
}
