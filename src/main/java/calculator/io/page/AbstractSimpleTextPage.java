package calculator.io.page;

public abstract class AbstractSimpleTextPage implements Page<String> {

    @Override
    public void render() {
        System.out.print(this.getContent());
    }

}
