package calculator;

import java.util.List;

public abstract class AbstractSeparator {
    private String separator; //구분자

    public abstract List<Long> separate(String userInput); //자식 클래스에서 꼭 구현

    public abstract List<Long> separateNumbers(String userInput);
}
