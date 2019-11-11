package javax.lang.reference;

import org.junit.Assert;
import org.junit.Test;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakReferenceTest {

    @Test
    public void strongReference() {
        Object obj =new Object();
        Object referenceObj = obj;

        Assert.assertEquals(obj, referenceObj);

        obj =null;
        System.gc();

        Assert.assertNotNull(referenceObj);
    }

    @Test
    public void weakReference() {
        Object obj =new Object();
        WeakReference referenceObj =new WeakReference<>(obj);

        Assert.assertEquals(obj, referenceObj.get());

        obj =null;
        System.gc();

        Assert.assertNull(referenceObj.get());
    }

    @Test
    public void softReference() {
        Object obj =new Object();
        SoftReference referenceObj =new SoftReference<>(obj);

        Assert.assertEquals(obj, referenceObj.get());

        obj =null;
        System.gc();

        Assert.assertNotNull(referenceObj.get());
    }

    @Test
    public void weakHashMap() throws InterruptedException {
        Map weakHashMap =new WeakHashMap<>();
        Object key =new Object();
        Object value =new Object();
        weakHashMap.put(key, value);

        Assert.assertTrue(weakHashMap.containsValue(value));

        key =null;
        System.gc();
        Thread.sleep(1000);

        Assert.assertFalse(weakHashMap.containsValue(value));
    }
}
