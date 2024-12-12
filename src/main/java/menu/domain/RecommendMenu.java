package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.util.Exception;

public class RecommendMenu {
    private List<String> menus = new ArrayList<>();

    public RecommendMenu() {
    }

    public void addRecommendMenu(String menu) {
        validateRecommendMenu(menu);
        menus.add(menu);
    }

    private void validateRecommendMenu(String menu) {
        if (menus.contains(menu)) {
            throw new IllegalArgumentException(Exception.ERROR + Exception.DUPLICATE_RECOMMEND_MENU);
        }
    }
}
