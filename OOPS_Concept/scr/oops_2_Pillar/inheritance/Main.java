package oops_2_Pillar.inheritance;

public class Main {
    /* Inheritance as name suggest means inheriting some properties or features from others
     *   like in real life human does (inheriting features from parent)
     * */
    static void main(String[] args) {
//        Just accessing the base class.
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//        Box a = new Box();
//        Box cube = new Box(4);
//        Box cuboid = new Box(3,5,7,"cuboid");
//        Box copy = new Box(cube);
//
////        cube.weight; // Cannot access as this belongs to the class BoxWeight and Box class cannot recognize it.
//
////        a.test; // as test variable is private it cannot be accessed in any other file/Class not even by the child class.
//
//        a.getInfo();
//        cube.getInfo();
//        cuboid.getInfo();
//        copy.getInfo();

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                              Single Inheritance
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        BoxWeight obj = new BoxWeight(43);
        obj.length = 23; // Child class object can access all the members of parent class unless and until they are Private.
        obj.getInfo();
//        obj.test; // cannot access directly as test is private but can be used if it is being used by any function or constructor.Like below example shows.
        BoxWeight obj2 = new BoxWeight(43, 24, 45, 70, "cuboid");
        obj2.getInfo();

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
/*  we can reference a child to a parent but cannot reference a parent to a child because child class may have it's own variable which is must to be declared when object creation.
    that's why it is not possible.


        A Superclass Variable Can Reference a Subclass Object:
        It is important to understand that it is the type of the reference variable—not the type of the object that it refers to—that determines what members can be accessed.
        When a reference to a subclass object is assigned to a superclass reference variable, you will have access only to those parts of the object which are defined by the superclass.
*/

//        here the box is a reference type of super class 'Box' but it is actually referring to the child class 'BoxWeight' object means it is of type 'Box' only but is declared like an BoxWeight object.
//        That's why it will have access to the member which are in the superclass itself.
//        After completing runtime Polymorphism: what members are to be accessed is depend on the type of variable and which version to be accessed depends on the actual object type.
        Box box = new BoxWeight(43, 24, 45, 70, "testing some fun stuff");
//        double weight = box.weight; // cannot be accessed even though it is declared in constructor while object creation as weight is the property of child class.
        box.getInfo();
        Box box2 = obj; // Here obj is an object of BoxWeight
//        double weight1= box2.weight;
        double weight = obj.weight;


//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                              Multilevel Inheritance
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //  Box -> BoxWeight -> BoxPrice
//        GrandParent -> Parent -> Child    // Can have multiple levels
        BoxPrice bp = new BoxPrice(); // child class of 'BoxWeight' class which is child class of 'Box'
//        This will have access to the member of parent class as well as grandparent class if the member is not private.
        bp.length = 2;
        bp.width = 42;
        bp.height = 22;
        bp.weight = 53;
        bp.getInfo();

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                              Hierarchical Inheritance
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        /*  Hierarchical inheritance means one class is inherited by multiple class. Parent class for more than 1 class is same.
         *
         *   like here BoxWeight and BoxColor is the child classes of Box, and they do not have any connection between them.
         * */

//        Box -> BoxWeight
//        Box -> BoxColor


//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                              Multiple Inheritance
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


        /*In java Multiple inheritance is not supported. But can be achieved by using interfaces check interface section for details*/


//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                              Hybrid Inheritance
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        /* As name suggest hybrid is combination of single inheritance and multiple inheritance. And that's why
        In java Hybrid inheritance is also not supported. But can be achieved by using interfaces check interface section for details
        * */

    }
}
