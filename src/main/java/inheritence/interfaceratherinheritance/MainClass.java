package inheritence.interfaceratherinheritance;



public class MainClass {

    public static void main(String[] args) {
        CarType inputCarType = CarType.EV;
        if(CarType.EV == inputCarType) {
            Car car = new EvCar();
            car.fuelUp();
        } else {
            Car car = new PetrolCar();
            car.fuelUp();
        }

    }

}
