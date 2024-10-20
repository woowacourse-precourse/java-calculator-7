package calculator.utils;

import calculator.domain.Candidate;

import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public static List<Integer> candidateToInt(List<Candidate> candidates) {
        return candidates.stream()
                .map(c -> Integer.parseInt(c.getCandidate()))
                .collect(Collectors.toList());
    }
}
