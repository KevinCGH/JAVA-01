package homework.thread;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Set;


/**
 * Homework01
 *
 * @author KevinChen
 * @since 7/2/2021
 */
public class Main {
    public static void main(String[] args) {
        Reflections reflections = new Reflections("homework.thread");
        Set<Class<? extends ThreadExperiment>> experiments = reflections.getSubTypesOf(ThreadExperiment.class);
        Iterator<Class<? extends ThreadExperiment>> iterator = experiments.iterator();
        int count = 1;
        while (iterator.hasNext()) {
            long start = System.currentTimeMillis();
            try {
                Class<? extends ThreadExperiment> clz = iterator.next();
                ThreadExperiment instance = clz.newInstance();
                String info = (String) clz.getDeclaredMethod("info").invoke(instance);
                System.out.println(count + "> " + info);
                Integer res = (Integer) clz.getDeclaredMethod("execute").invoke(instance);
                System.out.println(count + "> " + "异步计算结果为：" + res);
            } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
            } finally {
                System.out.println(count + "> " + "使用时间：" + (System.currentTimeMillis() - start) + "ms");
                System.out.println("-------------------------------------------------");
                count++;
            }

        }
    }
}
