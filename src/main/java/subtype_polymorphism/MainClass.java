package subtype_polymorphism;

import subtype_polymorphism.Car;
import subtype_polymorphism.CarType;

public class MainClass {
    
    //This is an use case of subtype polymorphism -> when I see the variation b/w subtypes are in terms of behaviour not data
    
    public static void main() {
        CarType inputCarType = CarType.HONDA;
        if(CarType.HONDA == inputCarType) {
//            HondaCar hondaCar = new HondaCar();
//            System.out.println(hondaCar.getHondaCarDescription());
            Car hondaCar = new Car("I am Honda");
            System.out.println(hondaCar.getDescription());
        } else {
//            SUVCar suuCar = new SUVCar();
//            System.out.println(suuCar.getSUVCarDescription());
            Car suvCar = new Car("I am SUV");
            System.out.println(suvCar.getDescription());
        }
    }
    
    
}
