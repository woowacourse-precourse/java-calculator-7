package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    private final List<String> stringList;
    private final List<Integer> intList = new ArrayList<>();

    public Converter(List<String> stringList) {
        this.stringList = stringList;
    }

    public List<Integer> convertList() {
        stringList.forEach(num -> intList.add(Integer.parseInt(num)));
        return intList;
    }
}
