package javax.lambda.defaultmethod;

public class Car implements Vehicle, FourWheeler {

    @Override
    public void me() {
        Vehicle.super.me();
        FourWheeler.super.me();

        System.out.println("Car");
    }

    public void start() {
        Vehicle.blowHorn();
        FourWheeler.move();
    }
}
