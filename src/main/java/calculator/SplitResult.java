package calculator;

import java.util.Collections;
import java.util.List;

public class SplitResult {
    private List<String> result;
    private boolean success;

    SplitResult(List<String> result, boolean success) {
        this.result = result;
        this.success = success;
    }

    public static SplitResult success(List<String> result) {
        return new SplitResult(result, true);
    }

    public static SplitResult fail() {
        return new SplitResult(Collections.EMPTY_LIST, false);
    }

    public List<String> result() {
        return result;
    }

    public boolean isSuccess() {
        return success;
    }
}
