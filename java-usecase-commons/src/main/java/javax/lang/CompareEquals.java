package javax.lang;

import com.google.common.base.Preconditions;

public class CompareEquals {

    public static void equalsPrimitiveType() {
        int x = 1;
        int y = 1;

        //对于基本类型，== 判断两个值是否相等，基本类型没有 equals() 方法。
        Preconditions.checkState(x == y);

        y = 2;
        Preconditions.checkState(x != y);
    }

    public static void equalsInteger() {

        //先判断值是否在缓存池中，如果在的话就直接返回缓存池的内容。
        Integer x = 1;
        Integer y = 1;

        //对于引用类型，== 判断两个变量是否引用同一个对象，而 equals() 判断引用的对象是否等价。
        Preconditions.checkState(x == y);
        Preconditions.checkState(x.equals(y));

        y = 2;
        Preconditions.checkState(x != y);
    }

    public static void equalsIntegerValueOf() {

        //先判断值是否在缓存池中，如果在的话就直接返回缓存池的内容。
        Integer x = Integer.valueOf(1);
        Integer y = Integer.valueOf(1);

        //对于引用类型，== 判断两个变量是否引用同一个对象，而 equals() 判断引用的对象是否等价。
        Preconditions.checkState(x == y);
        Preconditions.checkState(x.equals(y));

        y = 2;
        Preconditions.checkState(x != y);
    }

    public static void equalsIntegerInstance() {

        //每次都会新建一个对象。
        Integer x = new Integer(1);
        Integer y = new Integer(1);

        //对于引用类型，== 判断两个变量是否引用同一个对象，而 equals() 判断引用的对象是否等价。
        Preconditions.checkState(x != y);
        Preconditions.checkState(x.equals(y));

        y = 2;
        Preconditions.checkState(x != y);
    }

    public static void equalsStringInPool() {

        //先判断值是否在字符串常量池中，如果在的话就直接返回缓存池的内容。
        String x = "abc";
        String y = "abc";

        //对于引用类型，== 判断两个变量是否引用同一个对象，而 equals() 判断引用的对象是否等价。
        Preconditions.checkState(x == y);

        //equals()判断两个对象是否相等。
        //情况1：类没有重写 equals() 方法。等价于“==”。
        //情况2：类重写了 equals() 方法。一般用来比较两个对象的内容；若它们的内容相等，则返回 true (即，认为这两个对象相等)。
        Preconditions.checkState(x.equals(y));

        y = "abcd";
        Preconditions.checkState(x != y);
    }

    public static void equalsString() {

        //每次都会新建一个对象。
        String x = new String("abc");
        String y = new String("abc");

        //对于引用类型，== 判断两个变量是否引用同一个对象，而 equals() 判断引用的对象是否等价。
        Preconditions.checkState(x != y);

        //equals()判断两个对象是否相等。
        Preconditions.checkState(x.equals(y));
    }


}
