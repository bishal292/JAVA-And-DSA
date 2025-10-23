package oops_1_Concept.singleton;

/*------------------------------------------------------------------------------------------------------------------------------------------------------------
 *                           Singleton Class:
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------
 *   These are the class which can have exactly one object and cannot have more object.
 *
 *  As we know for creating an object a class Constructor is called which actually creates and object and return it.
 *  So, if somehow a class constructor is in accessible then the object of that class cannot be created.
 *
 *  Now, if any members which are declared with private keyword can be accessed within the same file only.
 *      What if a class constructor is private and there is function which is actually returning a single object whenever it is called.
 *
 * */


public class Singleton {
    String name;
    private Singleton(){}
//    As we know that static members can only access other static members directly.
    private static Singleton instance;

//    As no object can be created for this class outside this file so that we must make this function such that it can be called without an object means static.
    static Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}

// Now no object of this class can be created outside this file rather the single object instance will be referenced whenever a user try to create an object.
