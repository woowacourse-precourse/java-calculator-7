package calculator.service;

import java.util.ArrayList;
import java.util.List;

public class Extractor {

    public List<Integer> extractNumbers(final String input) {
        List<Integer> integers = new ArrayList<>();

        if (input.isEmpty()) {
            return null;
        }

        // TODO 여기서 중간에 validate 들어가야 함

        // TODO 커스텀으로 "'//', '\n'으로 입력받는 경우 delimeter를 해당 입력 값으로 변경할 것
        if (input.contains("//") && input.contains("\n")) {
            String[] tokens = input.split("//|\\n");
            // TODO tokens에 전부 다 들어 있으니 첫 번째 요소는 구분자로 쓰고 나머지는 통째로 뒤에 들어 있을 테니까
            //  나머지 부분을 구분자인 첫 번째 요소로 전부 잘라내면 그게 바로 숫자 ??
            String delimeter = tokens[0];
            String[] numberTokens = tokens[1].split(delimeter);

            for (String numberToken : numberTokens) {
                integers.add(Integer.parseInt(numberToken));
            }
            return integers;
        }

        // TODO 커스텀 없이 바로 숫자로 들어오는 경우 정규표현식 사용할 것
        String[] tokens = input.split("[,:]+");
        for (String token : tokens) {
            integers.add(Integer.parseInt(token));
        }
        return integers;
    }
}
