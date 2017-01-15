/**
 * Created by 33558 on 13.01.2017.
 */
public class Saver {

    @SaverMethod
    public void save(TextContainer container) {
        System.out.println("Come to save Method");
        Class<?> containerClass = container.getClass();
        if (!containerClass.isAnnotationPresent(SaveTo.class)){
            System.out.println("This class can`t be saved!");
        } else {
            System.out.println("Come to annotated Class SaveTo...");
            String path = containerClass.getAnnotation(SaveTo.class).path();
            System.out.println(path);
        }
    }

    public Saver() {
    }
}
