package oops_3_abstract_Interface.interfaceDemo;

/// is extending Brake and will indirectly contain all the method and variables from Brake Interface.
public interface Engine extends Brake {
    /*static final */ int PRICE = 780000; /// This is by default static and final.
    void start();
    void stop();

///     Cannot be Overridden as these are static method
    static void help(){
        System.out.println("Emergency.---> I'm Engine Static method");
    }

    static void accelerate(){
        System.out.println("Accelerating the car.---> I'm Engine Static method");
    }

///    can be overridden but not necessary.
    default int totalCost(){
///        PRICE = 150000; // cannot be done as variable are by default static and final for interfaces.
        return PRICE + Brake.PRICE;
    }
}
