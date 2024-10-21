package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int result = 0; // 결과값 (구분자를 기준으로 분리한 각 숫자의 합)
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine().replaceAll(":", ",");
        String customCharacter = ""; // 커스텀 구분자
        if (str.indexOf("//") == 0 && str.indexOf("\\n") == 3) {
            // 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
            customCharacter = String.valueOf(str.charAt(2));
            str = str.replace("/", "").replace("\\", "").replace("n", "").replace(customCharacter, ",");
        }
        if (str.indexOf(",,") > -1) {
            //사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
            throw new IllegalArgumentException();
        }
        String[] arr = str.split(",");
        for (String item : arr) {
            if (!item.isEmpty()) {
                int n = Integer.parseInt(item);
                result += n;
            } else {
                //사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
                throw new IllegalArgumentException();
            }
        }
        System.out.println("결과 : " + result);
    }
}
