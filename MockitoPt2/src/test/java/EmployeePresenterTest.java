import employee.Employee;
import employee.EmployeePresenter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class EmployeePresenterTest {

    @Mock
    Employee employee1;

    @Mock
    Employee employee2;

    @Mock
    Employee employee3;

    @Test
    public void presentEmployeeTest() {
        List<Employee> list = List.of(
                employee1,
                employee2,
                employee3
        );
        EmployeePresenter employeePresenter = new EmployeePresenter(list);
        employeePresenter.presentEmployees();
        Mockito.verify(employee1.getName(), times(1));

    }
}

