package calculator.repository;

import java.util.ArrayList;

public class NumberRepository {
    private final ArrayList<Integer> numberRepository = new ArrayList<>();


    public void saveNumber(int number) {
        numberRepository.add(number);
    }

    public ArrayList<Integer> getNumberRepository() {
        return new ArrayList<>(numberRepository);

    }


}
