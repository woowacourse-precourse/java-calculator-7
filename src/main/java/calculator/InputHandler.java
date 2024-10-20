package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputHandler {

    final private DataRepository dataRepository;
    final private String CUSTOM_START = "//";
    final private String CUSTOM_END = "\\n";

    public InputHandler(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
        input();
    }

    public void input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String tempInput = Console.readLine();

        // 문자열로 \n 입력 될 때
        if (tempInput.startsWith(CUSTOM_START) && tempInput.contains(CUSTOM_END)) {
            dataRepository.setCustomSplitter(
                tempInput.substring(tempInput.indexOf(CUSTOM_START) + CUSTOM_START.length(),
                    tempInput.indexOf(CUSTOM_END)));
            dataRepository.setInputString(tempInput.substring(
                tempInput.indexOf(CUSTOM_END) + CUSTOM_END.length()));
            return;
        }

        // 엔터키로 \n 입력 될 때
        if (tempInput.startsWith(CUSTOM_START)) {
            dataRepository.setCustomSplitter(
                tempInput.substring(tempInput.indexOf(CUSTOM_START) + CUSTOM_START.length()));
            tempInput = Console.readLine();
        }

        // 문자열 입력 없을 시 예외 발생
        if (tempInput == null) {
            throw new IllegalArgumentException();
        }
        dataRepository.setInputString(tempInput);
        System.out.println(tempInput);
    }
}
