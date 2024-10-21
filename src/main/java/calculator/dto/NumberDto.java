package calculator.dto;

import java.util.ArrayList;

public class NumberDto {


    private final ArrayList<Long> numberRepository;


    public NumberDto(ArrayList<Long> numberRepository) {
        this.numberRepository = numberRepository;
    }


    public ArrayList<Long> getNumberRepository() {
        return numberRepository;
    }

}
