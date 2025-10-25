package oops_3_abstract_Interface.interfaceDemo;

public class PowerEngine implements Engine{
//    As this class is implementing the interface(Engine) it must complete the abstract methods.

    @Override
    public void start() {
//        Engine.PRICE = 12; // cannot be reassigned as by default variable are final and static.
        System.out.println("Power Engine Starts.");
    }

    @Override
    public void stop() {
        System.out.println("Power Engine Stops.");
    }
}
