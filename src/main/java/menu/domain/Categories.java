package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.util.Exception;

public class Categories {
    private List<String> categories = new ArrayList<>();

    public Categories() {
    }

    public void addCategory(String category) {
        validateCategory(category);
        categories.add(category);
    }

    public boolean isComplete() {
        if (categories.size() == 5) {
            return true;
        }
        return false;
    }

    private void validateCategory(String category) {
        long count = categories.stream()
                .filter(c -> c.equals(category))
                .count();
        if (count >= 2) {
            throw new IllegalArgumentException(Exception.ERROR + Exception.OVER_CATEGORY_AMOUNT);
        }
    }
}
