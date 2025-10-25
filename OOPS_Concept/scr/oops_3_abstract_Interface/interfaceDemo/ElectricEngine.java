package oops_3_abstract_Interface.interfaceDemo;

public class ElectricEngine implements Engine,Brake{
    @Override
    public void start() {
        System.out.println("Electric Engine Starts.");
    }

    @Override
    public void stop() {
        System.out.println("Electric Engine Stops.");
    }

///    Overriding the default method of Brake interface.
    public void brake(){
        System.out.println("Applying Brake for Electric Engine.");
    }
///  default method can be overridden by keeping the method public only as the method from interface are public, and we cannot downgrade its access while overriding.
///    So this below overriding will throw an error.
/*  void releaseBreak(){
        System.out.println("Break Released.");
    }*/
}
