package calculator.dto;

import java.util.ArrayList;

public class NumberDTO {


    private final ArrayList<Integer> numberRepository;


    public NumberDTO(ArrayList<Integer> numberRepository) {
        this.numberRepository = numberRepository;
    }


    public ArrayList<Integer> getNumberRepository() {
        return numberRepository;
    }

}
