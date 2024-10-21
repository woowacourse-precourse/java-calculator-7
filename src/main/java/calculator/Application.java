package calculator;



import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

        // 0. 문자열 입력받기
        String input = readLine();

        System.out.println("input: " + input);

        Calc calc = new Calc(input);

        int result = calc.calcSum();

        calc.printResult(result);


    }
}

class Calc {

    private static Set<String> sep = new HashSet<String>();
    private String input;
    private int[] numArr;

    Calc(String input) {
        this.input = input;
        setSepAndInput();
    }

    // 1. 구분자 저장 및 input에서 커스텀 구분자 분리하기
    private void setSepAndInput() {

        sep.add(",");
        sep.add(":");

        // "//" "\n" 사이 단어 추출
        Pattern pattern = Pattern.compile("//(.*?)(?=\\\\n)");
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()) {

            String customSep = matcher.group(1);

            sep.add(customSep);


            this.input = input.replace(matcher.group(0), "").replace("\\n", "").trim(); // 첫 번째 매칭된 문자열 제거

        }

//        System.out.println("sep: " + sep.toString());
//        System.out.println("input: " + this.input);

    }

    // 2. 숫자 구분하기
    private int[] getNumArr() {

        String regex = String.join("|", sep);

        try {
            numArr = Arrays.stream(input.split(regex))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } catch (Exception e) {

            numArr = new int[0];
        }

        return numArr;
    }

    // 3. 숫자 합 구하기
    public int calcSum() {
        int[] numArr = getNumArr();

        if (numArr != null) {

            return Arrays.stream(numArr).sum();
        }

        return 0;
    }

    // 결과 출력하기
    public void printResult(int result) {
        System.out.println("결과 : " + result);
    }

}


