package oops_3_abstract_Interface.interfaceDemo;

public interface Brake {
    int PRICE = 10000; /// by default static and final

///    default methods can be overridden if required but not necessary.This method is overridden in the Electric Engine class.
    default void brake(){
        System.out.println("Break Applied. from brake Interface");
    }

    default void releaseBreak(){
        System.out.println("Break Released. from brake Interface");
    }
}
