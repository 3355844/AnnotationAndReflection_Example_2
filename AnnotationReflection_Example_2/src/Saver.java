import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by 33558 on 13.01.2017.
 */
public class Saver {

    @SaverMethod
    public void save(TextContainer container) {
        Class<?> containerClass = container.getClass();
        if (!containerClass.isAnnotationPresent(SaveTo.class)) {
            System.out.println("This class can`t be saved! Class not Annotated by @SaveTo");
        } else {
            String path = containerClass.getAnnotation(SaveTo.class).path();
            savingProcess(containerClass, path);
        }
    }

    private void savingProcess(Class<?> containerClass, String path) {

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path, true));
            Method method = containerClass.getMethod("getStringTextContainer");
            String text = (String) method.invoke(TextContainer.class.newInstance());
            oos.writeObject(text);
            oos.flush();
            oos.close();
        } catch (IOException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            File file = new File(path);
            ObjectOutputStream oos = null;
            try {
                oos = new ObjectOutputStream(new FileOutputStream(file, true));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                oos.writeObject(TextContainer.class.newInstance().getStringTextContainer());
            } catch (InstantiationException | IllegalAccessException | IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public Saver() {
    }

    @Override
    public String toString() {
        return "new Saver Class";
    }
}

