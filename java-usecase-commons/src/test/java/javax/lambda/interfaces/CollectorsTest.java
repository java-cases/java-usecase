package javax.lambda.interfaces;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class CollectorsTest {

    private Stream<String> buildStream() {
        return Stream.of("java", "python", "c");
    }

    private void assertListResult(List<String> list) {
        assertEquals(3, list.size());
        assertEquals("java", list.get(0));
        assertEquals("python", list.get(1));
        assertEquals("c", list.get(2));
    }

    private void assertSetResult(Set<String> set) {
        assertEquals(3, set.size());
        assertEquals(true, set.contains("java"));
        assertEquals(true, set.contains("python"));
        assertEquals(true, set.contains("c"));
    }

    private void assertJoiningResult(String joining) {
        assertEquals(true, joining.contains("java"));
        assertEquals(true, joining.contains("python"));
        assertEquals(true, joining.contains("c"));
    }

    @Test
    public void toList() {
        //将数据收集进一个列表(Stream 转换为 List，允许重复值，有顺序)
        Collector<String, ?, List<String>> collector = Collectors.toList();

        Stream<String> stream = buildStream();
        List<String> list = stream.collect(collector);

        assertListResult(list);
    }

    @Test
    public void toSet() {
        //将数据收集进一个集合(Stream 转换为 Set，不允许重复值，没有顺序)
        Collector<String, ?, Set<String>> collector = Collectors.toSet();

        Stream<String> stream = buildStream();
        Set<String> set = stream.collect(collector);

        assertSetResult(set);
    }

    @Test
    public void toCollectionLinkedList() {
        //用自定义的实现Collection的数据结构收集
        Collector<String, ?, LinkedList<String>> collector = Collectors.toCollection(LinkedList::new);

        Stream<String> stream = buildStream();
        List<String> list = stream.collect(collector);

        assertListResult(list);
    }

    @Test
    public void toCollectionArrayList() {
        //用自定义的实现Collection的数据结构收集
        Collector<String, ?, List<String>> collector = Collectors.toCollection(ArrayList::new);

        Stream<String> stream = buildStream();
        List<String> list = stream.collect(collector);

        assertListResult(list);
    }

    @Test
    public void toCollectionTreeSet() {
        //用自定义的实现Collection的数据结构收集
        Collector<String, ?, Set<String>> collector = Collectors.toCollection(TreeSet::new);

        Stream<String> stream = buildStream();
        Set<String> set = stream.collect(collector);

        assertSetResult(set);
    }

    @Test
    public void joining() {
        //对Stream的字符串拼接
        Collector<CharSequence, ?, String> collector = Collectors.joining();

        Stream<String> stream = buildStream();
        String r = stream.collect(collector);

        assertJoiningResult(r);
        System.out.println(r);
    }

    @Test
    public void joiningWithDelimiter() {
        //对Stream的字符串拼接
        Collector<CharSequence, ?, String> collector = Collectors.joining(" | ");

        Stream<String> stream = buildStream();
        String r = stream.collect(collector);

        assertJoiningResult(r);
        System.out.println(r);
    }

    @Test
    public void joiningWithDelimiters() {
        //对Stream的字符串拼接
        Collector<CharSequence, ?, String> collector = Collectors.joining(" | ", "Start--", "--End");

        Stream<String> stream = buildStream();
        String r = stream.collect(collector);

        assertJoiningResult(r);
        System.out.println(r);
    }
}
