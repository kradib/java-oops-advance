package inheritence.interfaceratherinheritance;

public class PetrolCar implements  Car {


    public void fuelUp() {
        //have it's own implementation
        FuelProcessor fuelProcessor = new FuelProcessor();
        fuelProcessor.fuelUp();
        System.out.println("With Petrol");
    }

}
