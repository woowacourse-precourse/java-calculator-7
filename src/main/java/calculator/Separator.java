package calculator;

import java.util.List;

public interface Separator {

    public abstract List<Long> separate(String userInput); //자식 클래스에서 꼭 구현

    public abstract List<Long> separateNumbers(String userInput);
}
