package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();

        // inputString 이 잘 입력됐는지 확인
        validateInputString(inputString);

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < inputString.length(); i++) {
            arrayList.add(String.valueOf(inputString.charAt(i)));
        }

        for (int i = 0; i < arrayList.size(); i++) {
            // 기본구분자
            if (arrayList.contains(",") || arrayList.contains(":")) {
                useDefaultSeparator(inputString);
                break;
            }
            // 커스텀구분자
            if (arrayList.get(i).equals("/") && arrayList.get(i + 1).equals("/")
                    && arrayList.get(i + 3).equals("\\") && arrayList.get(i + 4).equals("n")
                    && !(arrayList.contains(",")) && !(arrayList.contains(":"))) {
                useCustomSeparator(inputString);
                break;
            }
        }

    }
    public static void useDefaultSeparator(String inputString){
        int sum = 0;
        StringTokenizer st = new StringTokenizer(inputString, ",:");
        while (st.hasMoreTokens()) {
            sum += Integer.parseInt(st.nextToken());
        }
        System.out.println("결과 : " + sum);
    }

    public static void useCustomSeparator(String inputString){
        int sum = 0;
        StringTokenizer st = new StringTokenizer(inputString, "/;\\n");
        while (st.hasMoreTokens()) {
            sum += Integer.parseInt(st.nextToken());
        }
        System.out.println("결과 : " + sum);
    }

    public static void validateInputString(String inputString) {
        StringTokenizer st = new StringTokenizer(inputString, ",:/;\\n0123456789");

        // 0이면 구분자와 양수로 구성된 문자열, 1이면 이외에 숫자가 있음.
        int i = st.countTokens();
        if (i == 1) {
            throw new IllegalArgumentException();
        }
    }
}

