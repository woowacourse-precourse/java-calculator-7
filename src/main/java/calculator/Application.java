package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Character> inputList = new ArrayList<>();
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();
        int sum = 0;

        if (input.isEmpty()) {
            System.out.println("결과 : " + sum);
            Console.close();
            return;
        }
        for (char c : input.toCharArray()) {
            inputList.add(c);
        }

        if (inputList.getFirst() == '/' && inputList.size() > 4) {
            sum = handleCustomDelimiter(inputList);
        } else if (Character.isDigit(inputList.getFirst())) {
            sum = handleDefaultDelimiters(inputList);
        } else {
            throw new IllegalArgumentException();
        }

        System.out.println("결과 : " + sum);
    }

    private static int handleCustomDelimiter(List<Character> inputList) {
        List<Character> dividerList = new ArrayList<>();
        List<Integer> tmpNum = new ArrayList<>();
        int countOfDivider = 0;
        int sum = 0;

        if (inputList.get(1) == '/' && inputList.get(3) == '\\' && inputList.get(4) == 'n') {
            if (Character.isDigit(inputList.get(2))
                    || inputList.get(2).equals(':')
                    || inputList.get(2).equals(',')) {
                System.out.println("구분자에 콤마, 콜론, 숫자를 사용한 경우");
                throw new IllegalArgumentException();
            } else if (inputList.size() == 5) {
                System.out.println("//[커스텀 구분자]\\n만 입력한 경우");
                return sum;
            }

            dividerList.add(inputList.get(2));
            System.out.println("커스텀 구분자 : "+inputList.get(2));
            inputList = inputList.subList(5, inputList.size());

            sum = processNumbers(inputList, dividerList, tmpNum, countOfDivider);
        } else {
            throw new IllegalArgumentException();
        }

        return sum;
    }
    private static int handleDefaultDelimiters(List<Character> inputList) {
        List<Character> dividerList = Arrays.asList(':', ',');
        List<Integer> tmpNum = new ArrayList<>();
        int countOfDivider = 0;

        return processNumbers(inputList, dividerList, tmpNum, countOfDivider);
    }

    private static int processNumbers(List<Character> inputList, List<Character> dividerList,
                                      List<Integer> tmpNum, int countOfDivider) {
        // TODO
        System.out.println("아직 processNumbers 기능이 구현되지 않았습니다. 임시결과로 999가 출력됩니다.");
        return 999;
    }
}
