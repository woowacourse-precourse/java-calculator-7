package calculator.domain;

import java.util.LinkedList;

public class Delimiters {
    private LinkedList<Character> delimeterCollections = new LinkedList<>();
    public Delimiters(){
        delimeterCollections.add(',');
        delimeterCollections.add(':');
    }

    public LinkedList<Character> getDelimeterCollections() {
        return delimeterCollections;
    }

}
