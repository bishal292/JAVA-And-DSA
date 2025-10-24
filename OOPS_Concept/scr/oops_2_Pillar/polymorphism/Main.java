package oops_2_Pillar.polymorphism;

public class Main {
    static void main(String[] args) {
        /* Polymorphism:  one member working as more than one is known as polymorphism.
        Method Overloading (happens at Compile time) : when a method is defined with same name but with different return type,function signature
                    or with difference in order of params then it is known as compile time polymorphism or method Overloading.
                    we have already seen examples of this in inheritance(with constructor Overloading).
        * */

//        Overriding when a child class and parent class have exactly same method then the function in overridden by the child class method and is executed.
//        This happens at runtime hence it is also known as runtime polymorphism
        Shapes shape = new Shapes();
        Square square = new Square();
        Circle circle = new Circle();
        Triangle triangle = new Triangle();

        shape.area();
        square.area();
        circle.area();
        triangle.area();

        Shapes obj = new Square();
// in inheritance, we have seen that if a reference variable is of parent type and referring to a child class object. even though the child class variable cannot be accessed.
        obj.area();// but here this will call the child class method but not the parent class method Even though parent also have the method.
        System.out.println(obj.num);// This will return the value of num from the Parent Class
        // Why??
/*
*           Shapes obj = new Square();
*       This statement defines that all the member which are accessible to Shapes that same will be accessible to its object.
*       So the type of reference variable must have that element which are being tried to access using its object.
*      Means Shapes must have 'area()' method then only it can be accessed else not.
*
*       But why those difference in num and area() ??
*       because in Java, instance methods are resolved at runtime based on the actual object type, not the reference type.
*           while fields are resolved at compile time based on the reference type, not the actual object.
*       And num is field and not a method that's why...
* */




//        ------------------------------------------------------------------------------------------------------------------------------------------------------------------
//        Static methods are not overridden as static do not depend on object but overriding does.

        Shapes sp = new Square();
        Square sq = new Square();
        sp.greet(); // this both will result in the call of method from the shapes class. And this is not a good practice of calling a static method, although it can  be called like this.
        sq.greet();
//        But by this way we can call the methods from each class, and it is also perfect way of calling static method.
//        Note :-> these below calls are not representing Method Overriding in ant way
        Shapes.greet();
        Square.greet();

    }
}
