package car.test;

import car.Car;
import car.CarCreator;
import car.CarService;
import client.Client;
import client.ClientRepository;
import exception.PaymentException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import payment.Payment;
import payment.PaymentRepository;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

    @Mock
    Payment payment;

    @Mock
    CarCreator carCreator;

    @Mock
    ClientRepository clientRepository;

    @Mock
    PaymentRepository paymentRepository;

    @Test(expected = PaymentException.class)
    public void shouldThrowExceptionWhenPaymentIsZero(){
        Mockito.when(payment.getAmount()).thenReturn(0);
        CarService carService = new CarService(carCreator, clientRepository, paymentRepository);
        carService.savePayment(payment);
    }

    @Test
    public void shouldRegisterClientWithACar(){
        CarService carService = new CarService(carCreator, clientRepository, paymentRepository);
        Car audi = new Car();
        audi.setMake("Audi");
        audi.setColor("Red");
        audi.setPlate("GD100");

        Mockito.when(carCreator.createCar("Audi", "Red", "GD100"))
                .thenReturn(audi);

        Client jim = new Client();
        jim.setId("Jim");

        Mockito.when(clientRepository.findClient("Jim"))
                .thenReturn(jim);

        Client client = carService.registerClientCar("Jim", "Audi", "Red", "GD100");

        Assert.assertEquals(jim.getId(), client.getId());
        Assert.assertEquals(audi.getPlate(), client.getCar().getPlate());
    }
}