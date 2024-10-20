package calculator;

import java.util.List;

public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 입력
        DataRepository dataRepository = new DataRepository();
        new InputHandler(dataRepository);

        // 기능
        LogicHandler logicHandler = new LogicHandler();

        List<String> stringList = logicHandler.splitInputString(dataRepository.getCustomSplitter(),
            dataRepository.getInputString());

        logicHandler.removeEmpty(stringList);
        logicHandler.checkInputString(stringList);
        logicHandler.printResult(stringList);
    }


}
