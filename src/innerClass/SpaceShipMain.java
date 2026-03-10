package innerClass;

public class SpaceShipMain {

    public static void main(String[] args) {

        SpaceShip.Engine engine = new SpaceShip.Engine();
        SpaceShip spaceShip = new SpaceShip();
        engine.start();
        spaceShip.addEngine(engine);
        spaceShip.startSpaceShip();

    } // end of main

}
