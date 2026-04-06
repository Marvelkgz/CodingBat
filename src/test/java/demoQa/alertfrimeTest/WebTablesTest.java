package demoQa.alertfrimeTest;
import demoQa.BaseDemoQaTest;
import org.example.digital_nomads.demoQa.models.Employee;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.util.List;
@Tag("SmokeUI")
public class WebTablesTest extends BaseDemoQaTest {

    @Test
    void webTableTest(){
        driver.get("https://demoqa.com/webtables");
        List<Employee> employeeList = webTablesPage.getEmployeeFromTable();

        for (Employee employee : employeeList){
            System.out.println(employee);
        }
    }

    @Test
    void webTableAddEmployeeTest() {
        driver.get("https://demoqa.com/webtables");
        webTablesPage.addNewEmployee();
    }
}
