package homework.h01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * ProxyDemo
 * 使 Java 里的动态代理，实现一个简单的 AOP
 *
 * @author KevinChen
 * @since 21/2/2021
 */
public class ProxyDemo {
    public static void main(String[] args) {
        Dog dog = new Dog("小黑");
        Animal animal = (Animal) (new ProxyDemo()).createProxy(dog,
                () -> System.out.println("摇摇尾巴！"),
                () -> System.out.println("吐吐舌头!"));
        animal.eat("🦴");
    }

    private Object createProxy(Object targetObject, ProxyMethod before, ProxyMethod after) {
        ClassLoader loader = this.getClass().getClassLoader();
        Class[] interfaces = targetObject.getClass().getInterfaces();
        InvocationHandler handler = (proxy, method, args) -> {
            if (before != null) {
                before.run();
            }
            Object result = method.invoke(targetObject, args);
            if (after != null) {
                after.run();
            }
            return result;
        };

        Object obj = Proxy.newProxyInstance(loader, interfaces, handler);
        return obj;
    }
}
