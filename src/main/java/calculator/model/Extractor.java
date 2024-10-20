package calculator.model;

import java.util.List;

public class Extractor {

    private List<String> delimiters;
    // 기본 구분자 및 커스텀 구분자 추가
    public Extractor(String input) {
        this.delimiters = new ArrayList<>(List.of(",", ":"));
    }

}
