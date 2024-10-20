package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static int add(String input) {
        String delimiter = "";
        String[] numbers;
        int sum = 0;
        if (input == null || input.isEmpty() || input.isBlank()) {
            return 0;
        } else if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\\n");
            if(newlineIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자를 지정할 수 없습니다.");
            }
            delimiter = input.substring(2, newlineIndex);
            input = input.substring(newlineIndex + 2);
            if(input == null || input.isEmpty() || input.isBlank()) {
                return 0;
            }
            String first = "" + input.charAt(0);
            String firstDlm = input.substring(0, delimiter.length());
            String last = "" + input.charAt(input.length()-1);
            String lastDlm = input.substring(input.length() - delimiter.length(), input.length());
            if(first.equals(":") || first.equals(",") || firstDlm.equals(delimiter)) {
                throw new IllegalArgumentException("구분자로 시작할 수 없습니다.");
            } else if(last.equals(":") || last.equals(",") || lastDlm.equals(delimiter)) {
                throw new IllegalArgumentException("구분자로 끝날 수 없습니다.");
            } else {
                numbers = split(input, delimiter);
                for(String number : numbers) {
                    int num = parseNumber(number);
                    if(num < 0) {
                        throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                    }
                    sum += num;
                }
                return sum;
            }
        } else {
            String first = "" + input.charAt(0);
            String last = "" + input.charAt(input.length()-1);
            if(first.equals(":") || first.equals(",")) {
                throw new IllegalArgumentException("구분자로 시작할 수 없습니다.");
            } else if(last.equals(":") || last.equals(",")) {
                throw new IllegalArgumentException("구분자로 끝날 수 없습니다.");
            } else {
                numbers = split(input);
                for (String number : numbers) {
                    int num = parseNumber(number);
                    if (num < 0) {
                        throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                    }
                    sum += num;
                }
                return sum;
            }
        }
    }

    private static int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(
                    "구분자나 숫자를 연속해서 입력하거나 " +
                            "구분자로 지정하지 않은 문자를 입력할 수 없습니다.");
        }
    }

    private static String[] split(String input) {
        String temp = input.replace(":", ",");
        if(!temp.contains(",")) {
            throw new IllegalArgumentException(
                    "숫자만 입력하거나 구분자로 지정하지 않은 문자를 입력할 수 없습니다.");
        }
        return temp.split(",");
    }

    private static String[] split(String input, String delimiter) {
        String temp = input.replace(delimiter, ",");
        temp = temp.replace(":", ",");
        if(!temp.contains(",")) {
            throw new IllegalArgumentException("숫자만 입력할 수 없습니다.");
        }
        return temp.split(",");
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        try {
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}

