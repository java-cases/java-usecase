package javax.lambda;

import org.junit.Test;

public class ConsumerActionsTest {

    @Test
    public void consumer() {
        ConsumerActions.consumer().accept(1);
    }

    @Test
    public void biConsumer() {
        ConsumerActions.biConsumer().accept(1, 2L);
    }

    @Test
    public void doubleConsumer() {
        ConsumerActions.doubleConsumer().accept(1);
    }

    @Test
    public void intConsumer() {
        ConsumerActions.intConsumer().accept(1);
    }

    @Test
    public void longConsumer() {
        ConsumerActions.longConsumer().accept(1);
    }

    @Test
    public void objDoubleConsumer() {
        ConsumerActions.objDoubleConsumer().accept("double", 1);
    }

    @Test
    public void objIntConsumer() {
        ConsumerActions.objIntConsumer().accept("int", 1);
    }

    @Test
    public void objLongConsumer() {
        ConsumerActions.objLongConsumer().accept("long", 1L);
    }
}