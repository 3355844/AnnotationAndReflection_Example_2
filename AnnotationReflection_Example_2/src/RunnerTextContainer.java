/**
 * Created by 33558 on 13.01.2017.
 */
public class RunnerTextContainer {
    public static void main(String[] args) {
        try {
            TextContainer container = TextContainer.class.newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
