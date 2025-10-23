package oops_2_Pillar.inheritance;

public class BoxColor extends Box{
    String boxColor;

    BoxColor(String color){
        this.boxColor = color;
        this.length = 23;
        super.height = 12;
    }
}
