package calculator;

import camp.nextstep.edu.missionutils.Console;

/**
 * 이 클래스는 문자열 덧셈 계산기를 나타낸다.
 * 커스텀 구분자가 있는지 확인하는 메서드, 구분자 배열을 반환하는 메서드,
 * 커스텀 구분자 입력 부분을 제거하는 메서드, 구분자를 콤마로 대체하는 메서드,
 * 문자열을 구분자를 기준으로 나누는 메서드, 입력값의 유효성을 검증하는 메서드,
 * 배열의 합을 반환하는 메서드로 구성된다.
 */
public class Application {
    /** 입력 문자열에 커스텀 구분자가 있는지 확인하여 bool 값을 반환한다.
     * 여기서 커스텀 구분자란 입력 문자열 앞 부분의 "//"와 "\n" 사이에 위치하는 문자를 말한다.
     *
     * @param input 입력 문자열
     * @return 커스텀 구분자 존재 여부
     */
    public static boolean hasCustomSeparator(String input) {
//        if (input.startsWith("//\\n")) { // empty separator 비허용 시
//            return false;
//        }
        return input.startsWith("//") && input.contains("\\n");
    }

    /**
     * 입력 문자열에서 ","를 제외한 구분자를 배열로 반환한다.
     * 즉, 커스텀 구분자가 없다면 ":"만, 있다면 ":"와 해당 구분자를 포함한 배열을 반환한다.
     *
     * @param input 입력 문자열
     * @return 구분자의 배열
     */
    public static String[] getSeparators(String input) {
        String[] separators = new String[]
                {":"};
        if (hasCustomSeparator(input)) {
            separators =
                    new String[]{":",
                            input.substring(2,
                                    input.indexOf("\\n"))};
        }
        return separators;
    }

    /**
     * 입력 문자열에서 커스텀 구분자 처리 부분을 제외하고 반환한다.
     * 즉, 커스텀 구분자가 있다면 입력 문자열의 "\n" 이후만,
     * 없다면 입력 문자열을 그대로 반환한다.
     *
     * @param input 입력 문자열
     * @return 잘린 입력 문자열
     */
    public static String trimCustomSeparator(String input) {
        String trimedInput = input;
        if (hasCustomSeparator(input)) {
            trimedInput = input.substring(input.indexOf("\\n") + 2);
        }
        return trimedInput;
    }

    /**
     * 문자열에서 ","를 제외한 구분자를 모두 ","로 대체한다.
     *
     * @param input 입력 문자열
     * @param separators 구분자 배열
     * @return 대체된 입력 문자열
     */
    public static String replaceSeparators(String input, String[] separators) {
        String replacedInput = trimCustomSeparator(input);
        for (String sep : separators) {
            replacedInput = replacedInput.replace(sep, ",");
            if (sep.isEmpty()) {//empty separator 고려
                replacedInput = replacedInput.
                        substring(1, replacedInput.length() - 1);
            }
        }
        return replacedInput;
    }

    /**
     * 문자열의 구분자를 모두 ","로 대체하고, ","를 기준으로 나누어 정수를 포함하는 배열 반환
     * NumberFormatException이 발생하면 IllegalArgumentException 던짐
     *
     * @param input 입력 문자열
     * @param separators 구분자 배열
     * @return 정수를 포함하는 배열
     * @throws IllegalArgumentException 문자열이 배열로 반환될 수 없을 떄
     */
    public static int[] splitByComma(String input, String[] separators) {
        String[] arrayStrings = replaceSeparators(input, separators).split(",");
        int len = arrayStrings.length;
        int[] arrayInts = new int[len];
        for (int i = 0; i < len; i++) {
            try {
                arrayInts[i] = Integer.parseInt(arrayStrings[i]);
            } catch (NumberFormatException ex) {
                System.out.println(input + "은(는) 유효하지 않은 입력값입니다.");
                throw new IllegalArgumentException(input + "은(는) 유효하지 않은 입력값입니다.", ex);
            }
        }
        return arrayInts;
    }

    /**
     * 배열의 원소가 모두 주어진 조건, 즉 양수인지 확인
     * 유효하지 않은 입력값이면 IllegalArgumentException 발생
     *
     * @param arrayInts 정수 배열
     * @throws IllegalArgumentException 입력값이 유효하지 않을 때
     */
    public static void checkValidity(int[] arrayInts) {
        for (int arrayInt : arrayInts) {
            if (arrayInt <= 0) {
                System.out.println("유효하지 않은 입력값입니다.");
                throw new IllegalArgumentException(arrayInt + "은(는) 유효하지 않은 입력값입니다. (expected)");
            }

        }

    }

    /**
     * 주어진 정수 배열의 합 계산
     * @param arrayInts 정수 배열
     * @return 배열 원소들의 합
     */
    public static int calculateSum(int[] arrayInts) {
        int result = 0;
        for (int nat : arrayInts) {
            result += nat;
        }
        return result;
    }

    /**
     * Application의 진입 위치
     * 키보드로 입력값을 받아, 숫자의 합을 계산할 수 있으면 출력
     *
     * @param args 동작에 아무 영향 없음
     */
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        //String input = "//\\n123"; //테스트용
        String input = Console.readLine();
        if (input.isEmpty()) { // ""일 때 0 나오게 예외처리
            System.out.println("결과 : " + 0);
            return;
        }
        String[] separators = getSeparators(input);

        int[] container = splitByComma(input, separators);

        checkValidity(container);
        int sum = calculateSum(container);
        System.out.println("결과 : " + sum);
    }
}