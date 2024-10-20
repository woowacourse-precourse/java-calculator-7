package calculator.service;

import calculator.dto.CheckSeparatorDto;
import calculator.service.separator.Separator;
import calculator.service.validator.Validator;

public class CalculatorService {
    private final Validator validator = new Validator();
    private final Separator separator = new Separator();


    /**
     * 덧셈 로직을 순차적으로 진행한다.
     */
    public int add(String inputString) {
        CheckSeparatorDto checkSeparatorDto = new CheckSeparatorDto();
        checkSeparatorDto.setInputString(inputString);
        separator.checkCustomSeparator(checkSeparatorDto);
        String[] separatedString = separator.separate(checkSeparatorDto);

        validator.hasNaN(separatedString);
        return sumSeparatedStringArr(separatedString);
    }

    /**
     * 문자열을 int 형으로 바꾼 뒤 합한다.
     *
     * @param separatedStringArr 숫자로만 이루어진 문자열 배열을 입력한다.
     * @return 합한다.
     */
    private int sumSeparatedStringArr(String[] separatedStringArr) {
        int sum = 0;
        for (String separatedString : separatedStringArr) {
            if (!separatedString.isEmpty()) {
                sum += Integer.parseInt(separatedString);
            }
        }
        return sum;
    }
}
