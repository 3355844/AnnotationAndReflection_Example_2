import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by 33558 on 13.01.2017.
 */
public class Saver {

    @SaverMethod
    public void save(TextContainer container) {
        System.out.println("Come to save Method");
        Class<?> containerClass = container.getClass();
        if (!containerClass.isAnnotationPresent(SaveTo.class)) {
            System.out.println("This class can`t be saved!");
        } else {
            System.out.println("Come to annotated Class SaveTo...");
            String path = containerClass.getAnnotation(SaveTo.class).path();
            System.out.println(path);
            try {
                savingProcess(containerClass, path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void savingProcess(Class<?> containerClass, String path) throws IOException {

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path, true));
            Method method = containerClass.getMethod("getStringTextContainer");
            String text = (String) method.invoke(TextContainer.class.newInstance());
            System.out.println(text);
            oos.writeObject(text);
            oos.flush();
            oos.close();
        } catch (IOException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Creating file");
            File file = new File (path);

            System.out.println("File created :" );
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, true));
            try {
                oos.writeObject(TextContainer.class.newInstance().getStringTextContainer());
            } catch (InstantiationException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
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

