package calculator.dto;

import java.util.ArrayList;

public class NumberDto {


    private final ArrayList<Integer> numberRepository;


    public NumberDto(ArrayList<Integer> numberRepository) {
        this.numberRepository = numberRepository;
    }


    public ArrayList<Integer> getNumberRepository() {
        return numberRepository;
    }

}
