package calculator.domain;

import java.util.ArrayList;

import static calculator.validators.InvalidOperandFormatException.validateToken;

public class Operands {
    private final ArrayList<Integer> operandList;

    public Operands() {
        this.operandList = new ArrayList<>();
    }

    public ArrayList<Integer> getOperandList() {
        return operandList;
    }

    public void addOperand(String token){
        operandList.add(validateToken(token));
    }
}
