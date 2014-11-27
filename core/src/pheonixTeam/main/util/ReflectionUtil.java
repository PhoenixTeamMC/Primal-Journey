package pheonixTeam.main.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author Strikingwolf, chbachman
 */
public class ReflectionUtil
{
    public static void runMethodsFromObjects(ArrayList<Object> objects, String methodName, Object... args) {
        for (int i = 0; i < objects.size(); i++) {
            runMethodFromObj(objects.get(i), methodName, args );
        }
    }

    public static void runMethodFromObj(Object obj, String methodName, Object... args) {
        try {
            Method method = obj.getClass().getMethod(methodName);
            method.invoke(obj, args);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
