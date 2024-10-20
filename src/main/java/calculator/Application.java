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
            String[] s = input.split("");
            if((s[3].equals("\\")) && (s[4].equals("n"))) {
                delimiter += input.charAt(2);
                if(input.length() == 5) {
                    return 0;
                }
                input = input.substring(5);
                if(input == null || input.isEmpty() || input.isBlank()) {
                    return 0;
                }
                String first = "" + input.charAt(0);
                String last = "" + input.charAt(input.length()-1);
                if(first.equals(":") || first.equals(",") || first.equals(delimiter)) {
                    throw new IllegalArgumentException("구분자로 시작할 수 없습니다.");
                } else if(last.equals(":") || last.equals(",") || last.equals(delimiter)) {
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
                throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
            }
        } else {
            String first = "" + input.charAt(0);
            String last = "" + input.charAt(input.length()-1);
            if(first.equals(":") || first.equals(",") || first.equals(delimiter)) {
                throw new IllegalArgumentException("구분자로 시작할 수 없습니다.");
            } else if(last.equals(":") || last.equals(",") || last.equals(delimiter)) {
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

