import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by 33558 on 13.01.2017.
 */
public class RunnerTextContainer {
    public static void main(String[] args) {
        Class<Saver> saver = Saver.class;
        Method[] methods = saver.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(SaverMethod.class)) {
                try {
                    method.invoke(Saver.class.newInstance(), TextContainer.class.newInstance());
                } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
