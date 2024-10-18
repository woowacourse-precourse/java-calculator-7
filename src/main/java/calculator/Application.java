package calculator;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();

        if (inputString.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }

        long sum = 0;

        if (inputString.contains("//") && inputString.contains("\\n")) {
            String[] result = SplitStringUsingSeparators(inputString);
            sum = checkIfStringHasNegativeAndCalculateSum(result);

        } else {
            String[] inputNumber = inputString.split(",|:");

            try {

                for (int i = 0; i < inputNumber.length; i++) {
                    String str = inputNumber[i];
                    Pattern pattern1 = Pattern.compile("([a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣])");
                    Matcher matcher1 = pattern1.matcher(inputString);

                    if (matcher1.find()) {
                        System.out.println(matcher1.group(1));
                        throw new IllegalArgumentException("b");
                    }

                    Pattern pattern = Pattern.compile("([0-9]+)");
                    Matcher matcher = pattern.matcher(str);
                    if (matcher.find()) {
                        System.out.println(matcher.group(1));
                        break;
                    } else {
                        if (i == (inputNumber.length - 1)) {
                            throw new IllegalArgumentException("a");
                        }
                    }
                }
                sum = checkIfStringHasNegativeAndCalculateSum(inputNumber);


            } catch (IllegalArgumentException e) {
                if (e.getMessage().equals("양수를 입력하세요.")) {
                    throw new IllegalArgumentException();
                }
                if (e.getMessage().equals("a")) {
                    sum = 0;
                }
                if (e.getMessage().equals("b")) {
                    throw new IllegalArgumentException();

                }
            }
        }
        System.out.println("결과 : " + sum);
    }

    private static int calculateSum(String inputNumberString[]) {
        int sum = 0;
        for (int i = 0; i < inputNumberString.length; i++) {
            sum += Integer.parseInt(inputNumberString[i]);
        }
        return sum;
    }


    private static Map<List<String>, String> findSeparatorAndRemove(String inputString) {
        List<String> customizedSeparators = new ArrayList<>();
        String updatedInputString = inputString;

        while (true) {
            try {
                Matcher matcher = findCustomizedSeparator(updatedInputString); // 매칭 및 추출
                String customizedSeparator = extractCustomizedSeparator(matcher);
                customizedSeparators.add(customizedSeparator);
                updatedInputString = generateStringOfRemovingCustom(updatedInputString, customizedSeparator);

                System.out.println("구분자: " + customizedSeparator);
                System.out.println("구분자가 삭제된 문자열: " + updatedInputString);
            } catch (IllegalArgumentException e) {
                break;  // 더 이상 커스텀 구분자가 없을 때 반복 종료
            }
        }

        Map<List<String>, String> SeparatorAndString = new HashMap<>();
        SeparatorAndString.put(customizedSeparators, updatedInputString);
        return SeparatorAndString;
    }

    private static Matcher findCustomizedSeparator(String inputString) {
        Pattern pattern = Pattern.compile("//(.)*\\\\n");
        Matcher matcher = pattern.matcher(inputString);

        if (matcher.find()) {
            return matcher;
        } else {
            throw new IllegalArgumentException();
        }
    }


    private static String extractCustomizedSeparator(Matcher matcher) {
        return matcher.group(1);
    }

    private static String generateStringOfRemovingCustom(String inputString, String customizedSeparator) {
        String stringOfRemovingCustom = inputString.replaceAll(
                "//" + Pattern.quote(customizedSeparator) + "\\\\n", "");
        return stringOfRemovingCustom;
    }

    private static void checkInputStringHasDash(String inputString[]) {
        for (int i = 0; i < inputString.length; i++) {
            String inputCharacter = inputString[i];
            if (inputCharacter.contains("-")) {
                throw new IllegalArgumentException("양수를 입력하세요.");
            }
        }
    }

    private static String[] SplitStringUsingSeparators(String inputString) {
        Map<List<String>, String> separatorAndString = findSeparatorAndRemove(inputString);

        List<String> Separators = separatorAndString.keySet().iterator().next();
        String beforeCaculateString = separatorAndString.values().iterator().next();

        String regex = Separators.stream().map(Pattern::quote).reduce((a, b) -> a + "|" + b).orElse("");
        String[] result = beforeCaculateString.split(regex);
        return result;
    }

    private static int checkIfStringHasNegativeAndCalculateSum(String[] result) {
        checkInputStringHasDash(result);
        return calculateSum(result);
    }


}
