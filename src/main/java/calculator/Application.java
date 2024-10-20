package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        DataRepository dataRepository = new DataRepository();
        new InputHandler(dataRepository);
        LogicHandler logicHandler = new LogicHandler();

        List<String> stringList = logicHandler.splitInputString(dataRepository.getCustomSplitter(),
            dataRepository.getInputString());

        System.out.println(stringList.toString());

    }


}
