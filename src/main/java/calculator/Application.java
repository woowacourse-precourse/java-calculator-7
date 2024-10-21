package calculator;
import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String splits = ":,";
        String patterString = "(?<=//).*?(?=\\\\n)"; //사이만 추출가능
        String patterString2 = "//.*?\\\\n";
        int sum = 0;
        System.out.println("Please Enter Your String!");
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
            input = input.replaceAll(patterString2,""); //새 input받기

        }
        if (input.isEmpty()) {
            System.out.println(0);
        } else {
            String splitFormmat = String.format("[%s]", splits); //정규식으로 전환
            String[] strArr = input.split(splitFormmat); //구분자를 기준으로 분할


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
            System.out.println(String.format("결과 : %s",sum));
        }
    }

    public static int[] toIntArray(String[] strArr) {
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            try {
                int parseInt = Integer.parseInt(strArr[i]);
                if (parseInt<0){
                    throw new IllegalArgumentException();
                }
                intArr[i] = parseInt;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        return intArr;
    }
}
