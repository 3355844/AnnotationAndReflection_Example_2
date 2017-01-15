import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by 33558 on 13.01.2017.
 */
public class RunnerTextContainer {
    public static void main(String[] args) {
        Class<Saver> saver = Saver.class;
        System.out.println(saver.toString());
        Class workClass = TextContainer.class;
        System.out.println(workClass.toString());
        Method[] methods = saver.getMethods();
        for (Method method : methods) {
            System.out.println(method.toString());
            if (method.isAnnotationPresent(SaverMethod.class)) {
                System.out.print("Come to Annotated Class and call : ");
                System.out.println(method.toString());
                try {
                    method.invoke(Saver.class.newInstance(), TextContainer.class.newInstance());
                } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
