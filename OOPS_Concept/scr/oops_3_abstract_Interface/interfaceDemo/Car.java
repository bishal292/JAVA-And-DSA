package oops_3_abstract_Interface.interfaceDemo;

public class Car {
    private Engine engine;
    private final Media mediaPlayer = new CDPlayer();

    /// media player have same type so initializing it here and making it final so that no new object for same can be created.

    public Car() { /// if a new car is created without engine param then initialize the engine with powerEngine
        engine = new PowerEngine();
    }

    public Car(Engine engine) { /// Else initialize it with the engine with which it is being created.
        this.engine = engine;
    }

    public void start() { /// starts the engine and starts according to the type of engine(Engine Object)
        engine.start();
    }

    public void stop() {/// Stops the engine and stops according to the type of engine(Engine Object)
        engine.stop();
    }
/// calling brake using the instance engine instance as Engine Interface extends Brake and all the types of engine implements the Engine Interface.
    void applyBrake(){
        engine.brake();
    }

    void releaseBreak(){
        engine.releaseBreak();
    }

///  Calling the static method of Engine Interface 'help'.
    void emergency(){
        Engine.help();
    }

    public void startMusic() { /// Start the music player.
        mediaPlayer.start();
    }

    public void stopMusic() { /// stops music player
        mediaPlayer.stop();
    }

    int totalCost(){
        int cost;
        /// as engine includes the price of braking system also so, just only adding the media player cost.
        cost = engine.totalCost() + Media.PRICE;
        return cost;
    }

    public void upgradeEngine() { /// Upgrade the engine to Electric if it is other.
        if (this.engine instanceof ElectricEngine) return; /// if already an electric engine then return.
        System.out.println("Engine is Upgrading to Electric from : "+this.engine.getClass().getSimpleName());
        this.engine = new ElectricEngine();
    }

    public void speedUp() {
        Engine.accelerate();
    }
}
