package calculator;

import static calculator.Constants.*;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

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
        return operandCandidates.trim().split(WHITESPACE_REGEX);
    }

    private void validate(String operandCandidate) {
        if(operandCandidate.isEmpty()) {
            return;
        }
        if (!operandCandidate.matches(VALID_OPERAND_REGEX)) {
            throw new IllegalArgumentException(ERROR_INVALID_OPERAND);
        }
    }
}
