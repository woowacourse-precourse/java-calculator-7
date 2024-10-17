package calculator;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class OperandManager {
    private List<BigDecimal> operands;

    public OperandManager() {
        this.operands = new LinkedList<>();
    }

    public List<BigDecimal> getOperands() {
        return this.operands;
    }

    public void save(String operandCandidates, Set<String> separator) {
        String[] splitOperandCandidates = split(operandCandidates, separator);
        for (String operandCandidate : splitOperandCandidates) {
            validate(operandCandidate);
            // TODO : 무리수, 소수점 다루는 로직 필요
            operands.add(new BigDecimal(operandCandidate));
        }
    }

    private String[] split(String operandCandidates, Set<String> separators) {
        String regex = String.join("|", separators);
        return operandCandidates.split(regex);
    }

    private void validate(String operandCandidate) {
        // TODO : 유효한 숫자인지 검증하는 로직 필요
    }
}
