import java.util.Arrays;
import org.junit.Test;

import org.junit.Assert;

public class EmployeePayrollServiceTest {
	@Test
	public void given3EmployeesWhenWrittenToFileShouldMatchEmployeeEntries() {
		EmployeePayrollData[] arrayOfEmps = { new EmployeePayrollData(1, "Equila Joe", 80000),
				new EmployeePayrollData(2, "Dee Holy", 70000), new EmployeePayrollData(3, "Fredich Karl", 90000) };
		EmployeePayrollService employeePayrollService;
		employeePayrollService = new EmployeePayrollService();
		employeePayrollService.writeEmployeePayrollData();
		employeePayrollService.printData(IOService.FILE_IO);
	}
}