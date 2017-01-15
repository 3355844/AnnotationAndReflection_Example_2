import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by 33558 on 13.01.2017.
 */
public class Saver {

    @SaverMethod
    public  void save(TextContainer container) {
        System.out.println("Come to save Method");
        Class<?> containerClass = container.getClass();
        if (!containerClass.isAnnotationPresent(SaveTo.class)){
            System.out.println("This class can`t be saved!");
        } else {
            System.out.println("Come to annotated Class SaveTo...");
            String path = containerClass.getAnnotation(SaveTo.class).path();
            System.out.println(path);
            try {
                ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream(path, true ));
                Method method = containerClass.getMethod("getStringTextContainer");
                String text = (String) method.invoke(TextContainer.class.newInstance());
                System.out.println(text);
                oos.writeObject(text);
                oos.flush();
                oos.close();
            } catch (IOException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    public Saver() {
    }
}
