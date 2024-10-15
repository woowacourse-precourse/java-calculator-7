package calculator.service;

import calculator.entity.Num;
import calculator.entity.Separator;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public interface SeparatorService {

    List<Num> separateNum(String refinedInput, String separatorString);

    Set<Separator> getCustomSeparators(String input);

    String refineString(String input, Queue<Integer> idxQueue);

    Queue<Integer> getAllCustomSepIdx(String input);
}
