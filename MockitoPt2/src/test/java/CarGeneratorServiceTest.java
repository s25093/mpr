import cars.Car;
import cars.CarGenerator;
import cars.CarGeneratorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarGeneratorServiceTest {

    @Mock
    CarGenerator carGenerator;

    @Mock
    Car car;

    @Test
    public void generateCarTest() {
        ArgumentCaptor<String> plateCaptor = ArgumentCaptor.forClass(String.class);

        CarGeneratorService carGeneratorService = new CarGeneratorService(carGenerator);
        String make = "Audi";
        String color = "Red";
        when(carGenerator.generateCar(eq(make.toUpperCase()), eq(color), anyString())).thenReturn(car);

        Car car1 = carGeneratorService.generateCar(make, color);

        Mockito.verify(carGenerator).generateCar(eq(make.toUpperCase()), eq(color), plateCaptor.capture());
        Mockito.verify(carGenerator).savePlateToDB(plateCaptor.capture());

        assertEquals(plateCaptor.getValue().substring(0,3), "GDA");

    }
}
