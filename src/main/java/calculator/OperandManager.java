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

    public void save(String operandCandidates, Set<String> separators) {
        String[] splitOperandCandidates = split(operandCandidates, separators);
        for (String operandCandidate : splitOperandCandidates) {
            validate(operandCandidate);
            if(!operandCandidate.isEmpty()) {
                operands.add(new BigDecimal(operandCandidate));
            }
        }
    }

    private String[] split(String operandCandidates, Set<String> separators) {
        String regex = String.join("|", separators);
        return operandCandidates.split(regex);
    }

    private void validate(String operandCandidate) {
        if(operandCandidate.isEmpty()) {
            return;
        }
        if (!operandCandidate.matches("[1-9]+")) {
            throw new IllegalArgumentException("피연산자는 1~9의 숫자로만 이루어져야 합니다.");
        }
    }
}
