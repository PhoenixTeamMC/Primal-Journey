package phoenixTeam.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author Strikingwolf, chbachman
 */
public class ReflectionUtil
{
    public static void runMethodsFromObjects(ArrayList<Object> objects, String methodName, Object... args) {
        for (Object object : objects) {
            runMethodFromObj(object, methodName, args);
        }
    }

    public static void runMethodsFromClasses(ArrayList<Class> classes, String methodName, Object... args) {
        for (Class aClass : classes) {
            runMethodFromClass(aClass, methodName, args);
        }
    }

    public static void runMethodFromObj(Object obj, String methodName, Object... args) {
        try {
            Class[] params = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                params[i] = args[i].getClass();
            }
            Method method = obj.getClass().getDeclaredMethod(methodName, params);
            method.setAccessible(true);
            method.invoke(obj, args);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void runMethodFromClass(Class<?> aClass, String methodName, Object... args) {
        try {
            Class[] params = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                params[i] = args[i].getClass();
            }
            Method method = aClass.getDeclaredMethod(methodName, params);
            method.setAccessible(true);
            method.invoke(aClass, args);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void changeFieldFromObj(Object obj, String fieldName, Object value) {
        Class aClass = obj.getClass();
        Field field;
        try {
            field = aClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static Object getFieldValFromObj(Object obj, String fieldName) {
        Class aClass = obj.getClass();
        Field field;
        try {
            field = aClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}