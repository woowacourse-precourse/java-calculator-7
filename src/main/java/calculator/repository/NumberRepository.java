package calculator.repository;

import calculator.dto.NumberDto;
import java.util.ArrayList;

public class NumberRepository {
    private final ArrayList<Long> numberRepository = new ArrayList<>();


    public void saveNumber(long number) {
        numberRepository.add(number);
    }

    public NumberDto getNumberDto() {
        return new NumberDto(new ArrayList<>(numberRepository));

    }


}
