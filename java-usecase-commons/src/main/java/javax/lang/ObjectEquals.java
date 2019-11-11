package javax.lang;

import java.util.Objects;

public class ObjectEquals {

    private int x;
    private int y;
    private int z;

    public ObjectEquals(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * 判断引用的对象是否等价。
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {

        //检查是否为同一个对象的引用，如果是直接返回 true
        if (this == o) {
            return true;
        }

        //检查是否是同一个类型，如果不是，直接返回 false
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        // 将 Object 对象进行转型
        ObjectEquals that = (ObjectEquals) o;

        // 判断每个关键域是否相等。
        return x == that.x &&
                y == that.y &&
                z == that.z;
    }

    /**
     * 在覆盖 equals() 方法时应当总是覆盖 hashCode() 方法，保证等价的两个对象散列值也相等。
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    public int hashCodeOfSuper() {
        return super.hashCode();
    }

    /**
     * 理想的散列函数应当具有均匀性，即不相等的对象应当均匀分布到所有可能的散列值上。
     * 这就要求了散列函数要把所有域的值都考虑进来。
     *
     * @return
     */
    public int hashCodeOfCustom() {
        int hash = 17;

        hash = 31 * hash + x;
        hash = 31 * hash + y;
        hash = 31 * hash + z;

        return hash;
    }

    @Override
    public String toString() {
        return String.format("ObjectEquals:x=%d,y=%d,z=%d", x, y, z);
    }


    public String toStringOfSuper() {
        // @ 后面的数值为散列码的无符号十六进制表示。
        return super.toString();
    }
}
