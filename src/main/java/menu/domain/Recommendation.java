package menu.domain;

public class Recommendation {
    private Coachs coachs;
    private Categories categories;

    public Recommendation(Coachs coachs, Categories categories) {
        this.coachs = coachs;
        this.categories = categories;
    }

    public void addCategory(String category) {
        categories.addCategory(category);
    }

    public void addRecommendMenu(String category) {
        coachs.recommendMenuOneCycle(category);
    }

    public boolean isCompleteRecommendation() {
        if (categories.isComplete()) {
            return true;
        }
        return false;
    }
}
