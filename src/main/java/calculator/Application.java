package calculator;

import calculator.repository.number.NumberRepository;
import calculator.repository.number.NumberRepositoryImpl;
import calculator.repository.separator.SeparatorRepository;
import calculator.repository.separator.SeparatorRepositoryImpl;

public class Application {
    public static void main(String[] args) {
        SeparatorRepository separatorRepository = SeparatorRepositoryImpl.getInstance();
        NumberRepository numberRepository = NumberRepositoryImpl.getInstance(separatorRepository);
    }
}
