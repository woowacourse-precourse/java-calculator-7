package DTO;

import java.util.ArrayList;

public class ParsedInputDTO {
    private ArrayList<String> separators;
    private ArrayList<Integer> numbers;

    public ParsedInputDTO(ArrayList<String> separators, ArrayList<Integer> numbers){
        this.separators = separators;
        this.numbers = numbers;
    }


    public ArrayList<String> getSeparators() {
        return separators;
    }

    public void setSeparators(ArrayList<String> separators) {
        this.separators = separators;
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }
}
