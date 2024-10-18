package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine(); //사용자입력

        // 입력을 구분자로 나누기
        try {
            String[] parts = splitInput(input); //입력된 숫자들의 배열값
            isNum(parts); //배열 내부가 전부 숫자인지 확인.. false시 에러
            int sum = sumNumbers(parts); //전체 배열 내 합 구하기
            System.out.println("결과 : " + sum); //결과
        } catch (IllegalArgumentException e) {
        }

    }

    // 입력된 문자열을 구분자로 나누는 메서드
    public static String[] splitInput(String input) {
        String numbers = removeCDelimiter(input);//입력값의 커스텀 입력부 삭제

        return numbers.split(delimiter(input)); // 콤마와 콜론, 커스텀 구분자로 사용하여 문자열을 나눔
    }

    //나눠진 문자를 합하는 메서드
    public static int sumNumbers(String[] parts) {
        int sum = 0;

        //배열 내부 숫자화와 합
        for (String part : parts) {
            sum += Integer.parseInt(part);
        }
        return sum;
    }

    //나눠진 문자들이 합당한지 확인하는 메서드
    public static boolean isNum(String[] parts) {
        for (String part : parts) {
            stringToChar(part);
            isSpace(part);
            isMinus(part);
        }
        return true;
    }

    //문자 배열을 char형태로 변경 후 검사하는 메서드
    public static void stringToChar(String part) {
        for (char c : part.toCharArray()) {
            isDigit(c);
        }
    }

    //char 자료를 숫자인지 확인하고 아니면 에러내는 메서드
    public static void isDigit(char c) {
        if (!Character.isDigit(c)) {
            System.out.println("error");
            throw new IllegalArgumentException(); //
        }
    }

    //아무것도 입력 안했는지 확인 후 즉시 출력하는 메서드
    public static void isSpace(String part) {
        if (part.isEmpty()) {
            System.out.println("결과 : 0");
        }
    }

    //음수인지 확인하는 메서드
    public static void isMinus(String part) {
        int num = Integer.parseInt(part);
        if (num < 0) {
            System.out.println("error");
            throw new IllegalArgumentException();
        }
    }


    //커스텀 구분자가 있는지 확인하고 구분자 반환하는 메서드
    public static String delimiter(String input) {
        if (input.startsWith("//") && input.contains("\\n")) {
            int index = input.indexOf("\\n");
            return "[,:]" + input.substring(2, index);
        }
        return "[,:]";
    }

    //커스텀 구분자 구분 부분을 없애는 메서드
    public static String removeCDelimiter(String input) {
        if (input.startsWith("//") && input.contains("\\n")) {
            int index = input.indexOf("\\n");
            return input.substring(index + 2);
        }
        return input;
    }
}
