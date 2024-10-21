package calculator;

import calculator.context.Context;
import calculator.input.FastScan;
import calculator.output.Print;

public class Solution {
    public void solve() {
        String problem = new FastScan().nextLine();

        Context context = new Context();
        context.setStrategy(problem);

        int res = context.problemCalculate(problem);

        new Print().print(res);
    }
}
