package calculator.model;

import calculator.domain.Candidate;
import calculator.domain.delimiter.DefaultDelimiter;
import calculator.domain.delimiter.Delimiter;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private final List<Delimiter> allowedDelimiters;
    private final List<Candidate> numberCandidates;

    public Storage() {
        this.allowedDelimiters = new ArrayList<>();
        this.numberCandidates = new ArrayList<>();
        initDelimiters();
    }

    public void addCustomDelimiter(Delimiter delimiter) {
        allowedDelimiters.add(delimiter);
    }

    public void addCandidateOfNumber(String number) {
        numberCandidates.add(new Candidate(number));
    }

    private void initDelimiters() {
        allowedDelimiters.add(new DefaultDelimiter(","));
        allowedDelimiters.add(new DefaultDelimiter(":"));
    }

    public List<Delimiter> getAllowedDelimiters() {
        return allowedDelimiters;
    }

    public List<Candidate> getNumberCandidates() {
        return numberCandidates;
    }
}
