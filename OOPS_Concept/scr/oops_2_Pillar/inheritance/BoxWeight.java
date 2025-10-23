package oops_2_Pillar.inheritance;

public class BoxWeight extends Box{
    double weight;

    BoxWeight(){
        this.weight = -1;
    }

    BoxWeight(double weight){
        this.weight = weight;
//        this.test = -1; // cannot access as test is private in the parent class.
        this.length = -1; // Can be accessed as these are not private.
    }

    BoxWeight(double side,double weight){
        super(side);
        this.weight =weight;
    }
// Super is a constructor call which calls the parent class constructor if there is no super in the child class constructor java by defaults add it to the child class constructor.

    BoxWeight(double length,double width,double height, double weight){
        super(length,width,height);// calls the parent constructor with the value.
        this.weight = weight;
    }

    BoxWeight(double length,double width,double height, double weight,String name){
        super(length,width,height,name);
        this.weight = weight;
    }

    BoxWeight(BoxWeight other){
        super(other);
        this.weight = other.weight;
    }

}
