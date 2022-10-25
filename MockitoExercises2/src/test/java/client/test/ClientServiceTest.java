package client.test;

import car.Car;
import client.Client;
import client.ClientRepository;
import client.ClientService;
import exception.ClientAlreadyExistsException;
import exception.ClientAlreadyInactiveException;
import exception.ClientNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

    @Mock
    ClientRepository clientRepository;

    @Mock
    Client client;

    @Mock
    Car car;

    @Test(expected = ClientAlreadyExistsException.class)
    public void shouldThrowExceptionWhenClientExists(){
        String clientId = "jim";
        Mockito.when(clientRepository.findClient(clientId)).thenReturn(client);
        ClientService clientService = new ClientService(clientRepository);
        clientService.createNewClient(clientId);
    }

    @Test
    public void shouldReturnClientWithGivenId(){
        String clientId = "jim";
        Mockito.when(clientRepository.findClient(clientId)).thenReturn(null);
        ClientService clientService = new ClientService(clientRepository);
        Client jim = clientService.createNewClient(clientId);

        Assert.assertEquals(clientId, jim.getId());
    }

    @Test(expected = ClientNotFoundException.class)
    public void shouldThrowExceptionWhenClientDoesntExist(){
        String clientId = "jim";
        Mockito.when(clientRepository.findClient(clientId)).thenReturn(null);
        ClientService clientService = new ClientService(clientRepository);
        Client harry = clientService.updateClientAccountId(clientId, "harry");
    }

    @Test
    public void shouldUpdateIdWhenClientExists(){
        String clientId = "jim";
        Client jim = new Client(clientId, true, car);
        Mockito.when(clientRepository.findClient(clientId)).thenReturn(jim);
        ClientService clientService = new ClientService(clientRepository);
        Client harry = clientService.updateClientAccountId(clientId, "harry");
        Assert.assertEquals("harry", harry.getId());
    }

    @Test(expected = ClientNotFoundException.class)
    public void shouldThrowExceptionWhenClientDoesntExistOnDisable(){
        String clientId = "jim";
        Mockito.when(clientRepository.findClient(clientId)).thenReturn(null);
        ClientService clientService = new ClientService(clientRepository);
        Client jimDisabled = clientService.disableClientAccount(clientId);
    }

    @Test(expected = ClientAlreadyInactiveException.class)
    public void shouldThrowExceptionWhenClientAlreadyInactiveOnDisable(){
        String clientId = "jim";
        Client jim = new Client(clientId, false, car);
        Mockito.when(clientRepository.findClient(clientId)).thenReturn(jim);
        ClientService clientService = new ClientService(clientRepository);
        Client jimDisabled = clientService.disableClientAccount(clientId);
    }

    @Test
    public void shouldReturnTheSameInactiveClientOnDisable(){
        String clientId = "jim";
        Client jim = new Client(clientId, true, car);
        Mockito.when(clientRepository.findClient(clientId)).thenReturn(jim);
        ClientService clientService = new ClientService(clientRepository);
        Client jimDisabled = clientService.disableClientAccount(clientId);
        Assert.assertEquals(jim.getId(), jimDisabled.getId());
        Assert.assertEquals(jim.getCar(), jimDisabled.getCar());
        Assert.assertFalse(jimDisabled.isActive());
    }
}
