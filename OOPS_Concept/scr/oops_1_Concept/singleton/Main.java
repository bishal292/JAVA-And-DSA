package oops_1_Concept.singleton;

public class Main {
    static void main(String[] args) {
//        Singleton obj = new Singleton(); // cannot create as the constructor of the class is private.

        Singleton obj = Singleton.getInstance(); // This will return the reference of the object which is created in the Singleton class.
        obj.name = "Bishal";
        Singleton obj2 = Singleton.getInstance();
        obj2.name ="Rohan";

//        These all variables(Objects) are referring to the single object only. means change made via any object will result in change for all.

        System.out.println(obj.name +"  "+obj2.name);
    }
}
