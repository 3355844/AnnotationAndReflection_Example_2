import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by 33558 on 13.01.2017.
 */
public class RunnerTextContainer {
    public static void main(String[] args) {
        Class<?> gettingClass = Saver.class.getClass();
        // можливо опрацювати клас на наявність аннотоації SaveTo.class або порацювати безпосередньо в методі
        Method [] methods = gettingClass.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(SaverMethod.class)){
                try {
                    method.invoke(TextContainer.class.newInstance());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
