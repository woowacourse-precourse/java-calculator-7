package calculator.model;

import java.util.*;

public class DividerManager {
    private List<String> dividers = new ArrayList<>();

    public DividerManager() {
        dividers.add(",");
        dividers.add(":");
    }

    public void addDivider(String divider) {
//        dividers.add(divider);
        if (divider.equals(" ")) {
            dividers.add("\\s+"); // 공백 구분자를 정규식으로 처리
        } else {
            dividers.add(divider);
        }
    }


    public List<String> getDividers() {
        return dividers;
    }
}
