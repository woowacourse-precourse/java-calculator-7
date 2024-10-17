package calculator;

import java.util.Queue;

public class Expression {
    private final Queue<Separator> separatorQueue;
    private final Queue<Integer> operandQueue;

    public Expression(Queue<Separator> separatorQueue, Queue<Integer> operandQueue) {
        this.separatorQueue = separatorQueue;
        this.operandQueue = operandQueue;
    }
}
