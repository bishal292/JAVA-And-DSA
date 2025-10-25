package oops_3_abstract_Interface.interfaceDemo;

public class CDPlayer implements Media {
///  Implementing the media interface and overriding the abstract methods.
    @Override
    public void start() {
        System.out.println("Music player Started.");
    }

    @Override
    public void stop() {
        System.out.println("Music player Stopped.");
    }
}
