package cn.com.reflection;

import java.lang.reflect.*;

public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {
        demo4();
    }

    public static void demo1() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> class1 = Class.forName("cn.com.reflection.Person");
        Constructor<?>[] constructors = class1.getConstructors();

        for (Constructor<?> constructor: constructors){
            System.out.println(constructor.getName());
        }
        Person person1 = (Person)constructors[0].newInstance();
        Person person2 = (Person)constructors[1].newInstance("ZhangSan",10);
        System.out.println(person1.toString());
        System.out.println(person2.toString());
        person1.setName("Lisi");
        person2.setAge(20);
        System.out.println(person1.toString());

    }

    public static void demo2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<?> class1 = Class.forName("cn.com.reflection.Person");
        Person person = (Person)class1.newInstance();
        Field field = class1.getDeclaredField("name");
        field.setAccessible(true);
        field.set(person,"Zhao Liu");
        System.out.println(field.get(person));

    }

    public static void demo3() throws ClassNotFoundException {
        Class<?> class1 = Class.forName("cn.com.reflection.SuperMan");
        Class<?> superClass = class1.getSuperclass();
        System.out.println("父类名称是："+superClass.getName());

        System.out.println("====================================================================");

        Field[] fields = class1.getDeclaredFields();
        for(Field field: fields){
            System.out.println("类中的成员为："+field.getName());
        }

        System.out.println("====================================================================");

        Method[] methods = class1.getDeclaredMethods();
        for(Method method: methods){
            System.out.println("类中的方法有："+method.getName());
            System.out.println("方法的返回类型为："+method.getReturnType());
            System.out.println("方法的修饰符："+Modifier.toString(method.getModifiers()));
            System.out.println("方法的内容："+method);
        }

        System.out.println("====================================================================");

        Class<?>[] inters = class1.getInterfaces();
        for(Class<?> inter: inters){
            System.out.println("接口的名称"+inter.getName());
        }
    }

    public static void demo4() throws ClassNotFoundException
    {
        Class<?> class1 = null;
        class1 = Class.forName("cn.com.reflection.SuperMan");
        String nameString = class1.getClassLoader().getClass().getName();

        System.out.println("Demo8: 类加载器类名: " + nameString);
    }
}
