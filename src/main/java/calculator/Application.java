package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {
    public static void main(String[] args) {
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
        Console.close();
    }

    private static int handleCustomDelimiter(List<Character> inputList) {
        List<Character> dividerList = new ArrayList<>();
        List<Integer> tmpNum = new ArrayList<>();
        int countOfDivider = 0;
        int sum = 0;

        if (inputList.get(1) == '/' && inputList.get(3) == '\\' && inputList.get(4) == 'n') {
            if (Character.isDigit(inputList.get(2)) || inputList.get(2).equals(':') || inputList.get(2).equals(',')) {
                throw new IllegalArgumentException();
            } else if (inputList.size() == 5) {
                return sum;
            }

            dividerList.add(inputList.get(2));
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
        int sum = 0;

        for (Character character : inputList) {
            if (countOfDivider > 1) {
                throw new IllegalArgumentException();
            }

            if (Character.isDigit(character)) {
                countOfDivider = 0;
                tmpNum.add(Character.getNumericValue(character));
            } else if (dividerList.contains(character)) {
                sum += parseStringToInt(tmpNum);
                tmpNum.clear();
                countOfDivider++;
            } else {
                throw new IllegalArgumentException();
            }
        }

        if (countOfDivider != 0) {
            throw new IllegalArgumentException();
        }
        sum += parseStringToInt(tmpNum);
        return sum;
    }

    private static int parseStringToInt(List<Integer> tmpNum) {
        int sum = 0;
        Collections.reverse(tmpNum);
        for (int i = 0; i < tmpNum.size(); i++) {
            sum += (int) (tmpNum.get(i) * Math.pow(10, i));
        }

        return sum;
    }
}
