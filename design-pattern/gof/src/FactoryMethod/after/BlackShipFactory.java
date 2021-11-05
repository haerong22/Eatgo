package FactoryMethod.after;

public class BlackShipFactory extends DefaultShipFactory{

    @Override
    public Ship createShip(String name) {
        return new BlackShip(name);
    }
}
