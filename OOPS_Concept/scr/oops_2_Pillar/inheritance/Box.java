package oops_2_Pillar.inheritance;

public class Box {
    private String name;
    double length;
    double width;
    double height;
    {
        this.name = "being Written by instance block";
    }

    //    When object created with no values pass in the constructor.
    Box() {
        this.width = -1;
        this.length = -1;
        this.height = -1;
    }

    //    Cube
    Box(double length) {
        this.width = length;
        this.length = length;
        this.height = length;
    }

    //    Cuboid
    Box(double length, double width, double height) {
        this.width = width;
        this.length = length;
        this.height = height;
    }

    Box(Box other) {
        this.width = other.width;
        this.length = other.length;
        this.height = other.height;
    }

    Box(String name) {
        this.name = name;
    }

    Box(double length, double width, double height, String name) {
        this.name = name;
        this.width = width;
        this.length = length;
        this.height = height;
    }

    void getInfo() {
        System.out.println(STR."Length: \{length} Width: \{width} Height: \{height} TestString value is \{name}");
    }
}
