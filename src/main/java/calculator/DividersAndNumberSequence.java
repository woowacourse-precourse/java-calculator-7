package calculator;

import java.util.List;

public class DividersAndNumberSequence {
    private List<String> dividers;
    private String numberSequence;

    public DividersAndNumberSequence(List<String> dividers, String numberSequence) {
        this.dividers = dividers;
        this.numberSequence = numberSequence;
    }

    public List<String> getDividers() {
        return dividers;
    }

    public String getNumberSequence() {
        return numberSequence;
    }
}
