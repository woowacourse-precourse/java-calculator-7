package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Categories {
    private List<String> categories = new ArrayList<>();

    public Categories() {
    }

    private void addCategory(String category) {
        categories.add(category);
    }
}
