package calculator.service.domain;

import java.util.ArrayList;
import java.util.List;

public class DelimiterHandler {
    private List<Delimiter> delimiterList;

    public DelimiterHandler() {
        delimiterList = new ArrayList<>(List.of(new Delimiter(','), new Delimiter(':')));
    }

    public void addDelimiter(char delimiter) {
        if(!checkDuplicate(new Delimiter(delimiter))) {
            delimiterList.add(new Delimiter(delimiter));
        }
    }

    private boolean checkDuplicate(Delimiter newDelimiter) {
        for(Delimiter each : delimiterList) {
            if(each.hasSameValueAs(newDelimiter)) return true;
        }
        return false;
    }
}
