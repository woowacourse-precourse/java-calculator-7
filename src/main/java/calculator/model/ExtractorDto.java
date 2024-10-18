package calculator.model;

import java.util.List;

public class ExtractorDto {
    private List<String> delimiters;
    private String values;

    public void settingExtractorDto(List<String> delimiters, String values) {
        this.delimiters = delimiters;
        this.values=values;
    }

    public List<String> getDelimiters() {
        return delimiters;
    }

    public String getValues() {
        return values;
    }
}
