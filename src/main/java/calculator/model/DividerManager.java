package calculator.model;

import java.util.*;

public class DividerManager {
    private List<String> dividers = new ArrayList<>();

    public DividerManager() {
        dividers.add(",");
        dividers.add(":");
    }

    public void addDivider(String divider) {
        dividers.add(divider);
    }


    public List<String> getDividers() {
        return dividers;
    }
}
