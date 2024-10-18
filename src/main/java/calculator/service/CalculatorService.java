package calculator.service;

import java.util.Arrays;
import java.util.List;

public class CalculatorService {

    private final String ERROR_MESSAGE = "잘못된 값이 입력되었습니다.";

    /**
     * 입력된 문자열이 기본 구분자([,:])를 사용하는지 또는 커스텀 구분자를 사용하는지 확인한 후, 해당 구분자를 기준으로 문자열을 분리하여 배열로 반환합니다.
     *
     * @param line 사용자가 입력한 문자열
     * @return 분리된 숫자 리스트
     */
    public String[] paresInput(String line) {
        String delimiter = "[,:]";
        String number = line;

        if (line.startsWith("//")) {
            int lastIndexOf = line.lastIndexOf("\\n");
            delimiter = "[" + line.substring(2, lastIndexOf) + "]";
            number = line.substring(lastIndexOf + 2);
        }

        return number.split(delimiter);
    }

    /**
     * 파라미터로 전달된 문자열 배열에서 각 요소를 숫자로 변환할 수 있다면, values 리스트에 Int 타입으로 변환한 후 추가합니다. 1. 숫자로 변환할 수 없는 문자열일 경우
     * NumberFormatException이 발생하고, 이를 IllegalArgumentException으로 변환하여 던집니다. 2. 변환된 숫자가 음수일 경우 IllegalArgumentException을
     * 발생시킵니다.
     *
     * @param parts 구분자를 통해 분리된 문자열 배열
     * @return 숫자 리스트
     */
    public List<Integer> convertToNumbers(String[] parts) {
        return Arrays.stream(parts).
                map(part -> {
                    try {
                        int value = 0;
                        if (!part.isEmpty()) {
                            value = Integer.parseInt(part);
                        }
                        if (value < 0) {
                            throw new IllegalArgumentException(ERROR_MESSAGE);
                        }
                        return value;
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException(ERROR_MESSAGE);
                    }
                }).toList();
    }

    /**
     * 숫자 리스트의 합계를 반환
     */
    public int calculateSum(List<Integer> values) {
        return values.stream().mapToInt(value -> value).sum();
    }
}
