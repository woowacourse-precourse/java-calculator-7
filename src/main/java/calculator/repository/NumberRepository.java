package calculator.repository;

import calculator.dto.NumberDto;
import java.util.ArrayList;

public class NumberRepository {
    private final ArrayList<Integer> numberRepository = new ArrayList<>();


    public void saveNumber(int number) {
        numberRepository.add(number);
    }

    public NumberDto getNumberDto() {
        return new NumberDto(new ArrayList<>(numberRepository));

    }


}
