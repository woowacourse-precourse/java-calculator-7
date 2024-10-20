package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < inputString.length(); i++) {
            arrayList.add(String.valueOf(inputString.charAt(i)));
        }

        for (int i = 0; i < arrayList.size(); i++) {

            if (arrayList.contains(",") || arrayList.contains(":")) { // 기본구분자
                useDefaultSeparator(inputString);
                break;
            }
            if (arrayList.get(i).equals("/") && arrayList.get(i + 1).equals("/")
                    && arrayList.get(i + 3).equals("\\") && arrayList.get(i + 4).equals("n")
                    && !(arrayList.contains(",")) && !(arrayList.contains(":"))) { // 커스텀구분자
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

}
