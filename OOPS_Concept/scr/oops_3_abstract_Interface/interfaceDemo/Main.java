package oops_3_abstract_Interface.interfaceDemo;

public class Main {
    static void main(String[] args) {
        Car car = new Car();
///  Example uses of all the functions from the car class.
        System.out.println(car.totalCost());
        car.totalCost();
        car.start();
        car.startMusic();
        car.speedUp();
        car.applyBrake();
        car.releaseBreak();
        car.stop();
        car.stopMusic();
        car.emergency();
        car.upgradeEngine();
        car.start();
        car.applyBrake();
        car.stop();


        Car car2 = new Car(new ElectricEngine());
        car2.start();
        car2.upgradeEngine();
        car2.stop();
    }
}
