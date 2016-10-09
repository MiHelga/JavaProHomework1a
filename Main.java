import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Olga on 02.10.2016.
 */
public class Main {
    public static void main(String[] args){
        Class cls = MyClass.class;
        Method [] methods = cls.getMethods();
        for (Method method:methods){
            if (method.isAnnotationPresent(Test.class)) {
                Test test = method.getAnnotation(Test.class);
                try {
                    System.out.println(method.invoke(null, test.a(), test.b()));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
