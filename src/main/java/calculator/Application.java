package calculator;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String value = readLine();
        List<Integer> valuesToCalculate = new ArrayList<>();  //양수및커스텀구분자와특정구분자만 여기에 접수시킬것


        if (value.isEmpty()) {
            valuesToCalculate.add(0);
        } else {
            String[] tokens = value.split("[,:]");

            for (String token : tokens) {
                int num = Integer.parseInt(token.trim());
                valuesToCalculate.add(num);
            }

        }
        int sum = valuesToCalculate.stream().mapToInt(Integer::intValue).sum();
        System.out.println(valuesToCalculate);
        System.out.println("결과 : " + sum);

    }
}


