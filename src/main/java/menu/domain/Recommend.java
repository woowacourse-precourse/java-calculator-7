package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Recommend {
    private List<String> categories = new ArrayList<>();
    private List<String> coach;
    private Map<String, List<String>> inedible;

    public Recommend(List<String> coach, Map<String, List<String>> inedible) {
        this.coach = coach;
        this.inedible = inedible;
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

    public Map<String, List<String>> getInedible() {
        return inedible;
    }

    public List<String> getCategories() {
        return categories;
    }
}
