class Vehicle
{
    String brand;
    String year;
    void startEngine()
    {
        System.out.println("START KARO BHAII");
    }
}
class Car extends Vehicle
{
    String fuelType;
    @Override
    void startEngine() {
        System.out.println("Car Engine Starts bhaiii");
    }
    void drive()
    {
        System.out.println("Car odudhu bhaii");
    }
}
class Truck extends Vehicle
{
    int loadCapacity;
    @Override
    void startEngine() {
        System.out.println("Now Truck Odudhuu bhaiii!");
    }
}
public class Inherit {
    public static void main(String[] args) {
        Truck t = new Truck();
        Vehicle v = new Vehicle();
        v.startEngine();
        t.startEngine();
    }
}
