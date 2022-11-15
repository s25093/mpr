package cars;

public class CarGeneratorService {
    private CarGenerator carGenerator;

    public CarGeneratorService(CarGenerator carGenerator){
        this.carGenerator = carGenerator;
    }

    public Car generateCar(String make, String color) {
        String plate = generatePlate();
        Car car = carGenerator.generateCar(make.toUpperCase(), color, plate);
        carGenerator.savePlateToDB(plate);
        return car;
    }

    private String generatePlate() {
        int digit1 = (int) (Math.random() * 10);
        int digit2 = (int) (Math.random() * 10);
        int digit3 = (int) (Math.random() * 10);
        int digit4 = (int) (Math.random() * 10);

        return "GDA" + digit1 + digit2 + digit3 + digit4;
    }
}
