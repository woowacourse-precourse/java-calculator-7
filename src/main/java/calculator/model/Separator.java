package calculator.model;

public class Separator {
    private String separator;

    public Separator() {
        this.separator = ",|:";
    }

    public void registerSeparator(String separatorSection) {
        for (int nowSeparatorIdx = 0; nowSeparatorIdx < separatorSection.length(); nowSeparatorIdx++) {
            this.separator += ("|\\" + separatorSection.charAt(nowSeparatorIdx));
        }
    }

    public String getSeparator() {
        return separator;
    }
}
