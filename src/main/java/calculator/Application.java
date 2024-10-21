package calculator;
import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String splits = ":,";
        String patterString = "(?<=//).*"; //사이만 추출가능
        String input = Console.readLine();
        if (input.startsWith("//")) {
            Pattern pattern = Pattern.compile(patterString);
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String newSplit = matcher.group();
                splits += newSplit;
            } else {
                System.out.println("there is no matched String");
            }
            input = Console.readLine(); //새 input받기
        } else if (input.matches("^[^0-9]*$")) {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                System.exit(0);
            }
        }
        if (input.isEmpty()) {
            System.out.println(0);
        } else {
            String splitFormmat = String.format("[%s]", splits); //정규식으로 전환
            String[] strArr = input.split(splitFormmat); //구분자를 기준으로 분할


            int sum = 0;

            int[] intArr = null;
            try {
                intArr = toIntArray(strArr);
            } catch (IllegalArgumentException e) {
                System.out.println("IllegalArgument Exception occur!");
                System.exit(0);
            }

            for (int j : intArr) { //배열의 값 모두 출력
                sum += j;
            }
            System.out.println(sum);
        }
    }

    public static int[] toIntArray(String[] strArr) {
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            try {
                intArr[i] = Integer.parseInt(strArr[i]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        return intArr;
    }
}
