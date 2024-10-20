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

    public void setNumberSequence(String numberSequence) {
        this.numberSequence = numberSequence;
    }

    public void updateNumberSequence() {
        if (this.getNumberSequence() == null) {
           throw new IllegalArgumentException();
        }

        String newNumberSequence = this.getNumberSequence();

        for (String divider : dividers) {
            newNumberSequence = newNumberSequence.replace(divider, SignAndDivider.defaultDivider1);
        }

        this.setNumberSequence(newNumberSequence);
    }
}
