package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine(); // 사용자입력

        // 입력을 구분자로 나누기
        try {
            String[] parts = splitInput(input); // 입력된 숫자들의 배열값
            isNum(parts); // 배열 내부가 전부 숫자인지 확인.. false시 에러
            Long sum = sumNumbers(parts); // 전체 배열 내 합 구하기
            isMinus(sum);
            System.out.println("결과 : " + sum); // 결과
        } catch (IllegalArgumentException e) {
        }

    }

    // 입력된 문자열을 구분자로 나누는 메서드
    public static String[] splitInput(String input) {
        String numbers = removeCDelimiter(input);// 입력값의 커스텀 입력부 삭제

        return numbers.split(delimiter(input)); // 콤마와 콜론, 커스텀 구분자로 사용하여 문자열을 나눔
    }

    // 나눠진 문자를 합하는 메서드
    public static Long sumNumbers(String[] parts) {
        long sum = 0;

        //배열 내부 숫자화와 합
        for (String part : parts) {
            sum += Long.parseLong(part);
        }
        return sum;
    }


    // 나눠진 문자들이 합당한지 확인하는 메서드
    public static void isNum(String[] parts) {
        checkOnlySpace(parts[0]);   //만약 전부 공백이면 여기에서 0으로 걸러짐

        for (String part : parts) {
            isFormatException(part);
            stringToChar(part);
            isSpace(part);
            isMinus(part);
        }
    }

    //배열 내부 값이 롱의 범위를 벗어나는지 검사하는 메서드
    public static void isFormatException(String part) {
        long L = 0;

        try {
            L = Long.parseLong(part);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    // 문자 배열을 char형태로 변경 후 검사하는 메서드
    public static void stringToChar(String part) {
        for (char c : part.toCharArray()) {
            isDigit(c);
        }
    }

    // char 자료를 숫자인지 확인하고 아니면 에러내는 메서드
    public static void isDigit(char c) {
        if (!Character.isDigit(c)) {
            throw new IllegalArgumentException(); //
        }
    }

    // 아무것도 입력 안했는지 확인 후 즉시 출력하는 메서드
    public static void isSpace(String part) {
        if (part.isEmpty()) {
            throw new IllegalArgumentException(); //
        }
    }

    // 입력한 것이 오직 공백인지 확인하는 메서드
    public static void checkOnlySpace(String part) {
        if (part.equals("")) {
            System.out.println("결과 : 0");
        }
    }

    // 음수인지 확인하는 메서드
    public static void isMinus(String part) {
        long num = Long.parseLong(part);
        if (num < 0) {
            throw new IllegalArgumentException();
        }
    }

    // 합의 값이 오버플로우로 음수가 안됐는지 확인하는 메서드
    public static void isMinus(Long sum) {
        if (sum < 0) {
            throw new IllegalArgumentException();
        }
    }

    // 커스텀 구분자가 있는지 확인하고 구분자 반환하는 메서드
    public static String delimiter(String input) {
        if (isCDelimiter(input)) {
            int index = input.indexOf("\\n");
            String s = delimiterCheck(input, index);
            isSpace(s);
            return ",|:|" + s;
        }
        return "[,:]";
    }

    // 커스텀 구분자 구분 부분을 없애는 메서드
    public static String removeCDelimiter(String input) {
        if (isCDelimiter(input)) {
            int index = input.indexOf("\\n");
            return input.substring(index + 2);
        }
        return input;
    }

    // 커스텀 구분자로 |를 추가했을 때 수정하는 메서드
    public static String delimiterCheck(String input, int index) {
        String check = input.substring(2, index);

        return check.contains("|")
                ? check.replace("|", "\\|")
                : check;
    }

    // 커스텀 구분자가 들어갔는지 확인하는 메서드
    public static boolean isCDelimiter(String input) {
        return input.startsWith("//") && input.contains("\\n");
    }
    
}
