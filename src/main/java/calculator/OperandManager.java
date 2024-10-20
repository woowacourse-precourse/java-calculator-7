package calculator;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class OperandManager {
    private final List<BigInteger> operands;
    private final SeparatorManager separatorManager;

    public OperandManager(SeparatorManager separatorManager) {
        this.operands = new LinkedList<>();
        this.separatorManager = separatorManager;
    }

    public List<BigInteger> getOperands() {
        return this.operands;
    }

    public void save(String operandCandidates) {
        String[] splitOperandCandidates = split(operandCandidates);
        for (String operandCandidate : splitOperandCandidates) {
            validate(operandCandidate);
            if(!operandCandidate.isEmpty()) {
                operands.add(new BigInteger(operandCandidate));
            }
        }
    }

    private String[] split(String operandCandidates) {
        for (String separator : separatorManager.getSeparators()) {
            operandCandidates = operandCandidates.replace(separator, " ");
        }
        return operandCandidates.trim().split("\\s+");
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
