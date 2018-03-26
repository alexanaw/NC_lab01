package analyzer;

import fillers.Filler;
import org.reflections.Reflections;
import sorters.Sort;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
/*
 * @author Bojchenko
 * @version 9
 *
 *  Class for sort time tracking
 */
public class Analyzer {
    private static ArrayList<Integer> res = new ArrayList<>();
   private static ArrayList<Integer> timeOfSort = new ArrayList<>();
    public static Map<String, Map<String, List<Integer>>> fullStatistic() throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Class<?> c = Class.forName("fillers.ArrayFiller");
        Method[] m = c.getDeclaredMethods();
        Map<String, Map<String, List<Integer>>> fullStatistic = new LinkedHashMap<>();
        for (int arraySize = 1000; arraySize <= 16000; arraySize = arraySize * 2) {
            res.add(arraySize);
        for (Method method : m) {
            if (method.isAnnotationPresent(Filler.class)) {
                    int a[] = (int[]) method.invoke(null, arraySize);
                    Map<String, List<Integer>> sortName = new LinkedHashMap<>();
                    Set<Class<? extends Sort>> subTypesOf = (new Reflections("sorters")).getSubTypesOf(Sort.class);
                    for (Class<? extends Sort> c1 : subTypesOf) {
                        Constructor<? extends Sort> emptyConstructor = c1.getConstructor();
                        Sort objectToInvokeOn = emptyConstructor.newInstance();
                        Method[] m1 = c1.getDeclaredMethods();
                        for (Method method1 : m1) {
                            Class<?>[] arguments = method1.getParameterTypes();
                            if (arguments.length != 1) continue;
                            if (arguments[0] != int[].class) continue;
                            long start = System.nanoTime();
                            method1.invoke(objectToInvokeOn, new Object[]{a});
                            timeOfSort.add((int) ((System.nanoTime() - start)/1000));
                            sortName.put(method1.getName(), timeOfSort);
                        }
                        fullStatistic.put(method.getName(), sortName);
                    }
                }
            }

        }
        return fullStatistic;
    }
    public static ArrayList <Integer> getRes(){
        return res;
    }
    public static ArrayList <Integer> getTimeOfSort(){
        return timeOfSort;
    }
}