package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Recommend {
    private List<String> categories = new ArrayList<>();
    private List<String> coach;
    private Map<String, List<String>> inedible;
    private Map<String, List<String>> recommendMenu;

    public Recommend(List<String> coach, Map<String, List<String>> inedible, Map<String, List<String>> recommendMenu) {
        this.coach = coach;
        this.inedible = inedible;
        this.recommendMenu = recommendMenu;
    }

    public boolean isCategoryAmountOverThree(String category) {
        long count = categories.stream().filter(c -> c.equals(category)).count();
        if (count >= 3) {
            return true;
        }
        return false;
    }

    public void addCategory(String category) {
        categories.add(category);
    }

    public int recommendAmount() {
        return categories.size();
    }

    public List<String> getCoach() {
        return coach;
    }

    public Map<String, List<String>> getRecommendMenu() {
        return inedible;
    }

    public List<String> getCategories() {
        return categories;
    }

    public List<String> getRecommendMenu(String coach) {
        return recommendMenu.get(coach);
    }
}
