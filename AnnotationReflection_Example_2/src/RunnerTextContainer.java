import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by 33558 on 13.01.2017.
 */
public class RunnerTextContainer {
    public static void main(String[] args) {
        Saver saver = null;
        Class workClass = TextContainer.class;
        System.out.println(workClass.toString());
        try {
            saver = Saver.class.newInstance();
            System.out.println(saver.toString());
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        Method[] methods = saver.getClass().getMethods();
        for (Method method : methods) {
            System.out.println(method.toString());
            if (method.isAnnotationPresent(SaverMethod.class)) {
                System.out.println("Come to Annotated Class");
                System.out.println(method.toString());
                try {
                    method.invoke(Saver.class.newInstance(), TextContainer.class.newInstance());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException | InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
