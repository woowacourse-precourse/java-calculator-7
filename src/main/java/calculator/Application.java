package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 문자열을 입력받는다.
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine();

        // 입력한 문자열로부터 구분자로 분리한 배열을 구한다.
        String[] stringArray = getStringArray(userInput);

        // 배열 요소 중 잘못된 값이 들어있는지 확인한다.
        checkValidation(stringArray);

        // 배열 요소에 대하여 String 에서 int 로 형 변환한다.
        int[] numberArray = typeChangeArray(stringArray);

        // 배열 요소의 합계를 구한다.
        int sum =  addNumbers(numberArray);

        // 합계 결과를 출력한다.
        System.out.println("결과 : "+sum);
    }

    private static String[] getStringArray(String userInput) {
        // 커스텀 구분자를 사용한 경우
        if (userInput.startsWith("//") && userInput.contains("\\n")) {
            // 커스텀 구분자를 추출한다.
            int startIndex = userInput.indexOf("//") + 2;
            int endIndex = userInput.indexOf("\\n");
            String customSeparator = userInput.substring(startIndex, endIndex);
            // 커스텀 구분영역을 뺀 나머지 입력 값을 확인한다.
            int inputWithSeparatorIndex = userInput.indexOf("\\n") + 2;
            String inputWithSeparator = userInput.substring(inputWithSeparatorIndex);
            // 구분자로 입력 값을 분리하여 배열로 만들고 리턴한다.
            return inputWithSeparator.split(customSeparator);
        }
        // 기본 구분자를 사용한 경우
        else {
            // 기본 구분자 "," 또는 ":" 로 입력 값을 분리하여 배열로 만들고 리턴한다.
            return userInput.split("[,:]");
        }
    }

    private static void checkValidation(String[] arr) {
        for (String text: arr) {
            if (!text.matches("[1-9]\\d*") ) {
                throw new IllegalArgumentException("wrong text");
            }
        }
    }

    private static int[] typeChangeArray(String[] arr) {
        int[] numbersArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            numbersArray[i] = Integer.parseInt(arr[i]);
        }
        return numbersArray;
    }

    private static int addNumbers(int[] arr) {
        // 배열 요소의 합계를 구한다.
        int sum = 0;
        for (int i=0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
