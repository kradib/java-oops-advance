package inheritence.dontuseinheritance;

import inheritence.dontuseinheritance.Car;

public class EvCar {



    public void ChargeBattery() {
        //If there is no need for inheritance and you just want to avoid code redundancy, don't use that
        Car car = new Car();
        ////
        car.fuelUp();
        ///;
    }

    public void start() {

    }

}
