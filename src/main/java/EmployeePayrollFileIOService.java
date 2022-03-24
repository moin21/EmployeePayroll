
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollFileIOService {
	public static String PAYROLL_FILE_NAME = "payroll-file.txt";

	/**
	 * Method to writeData of List of Employee Payroll: taking param
	 * employeePayrollList of EmployeePayrollData Type. created instance of
	 * StringBuffer Than using toString Method created empoyeDataString. Finally
	 * appending this new string to empBuffer.
	 */

	public void writeData(List<EmployeePayrollData> employeePayrollList) {
		/**
		 * empBuffer created
		 */
		StringBuffer empBuffer = new StringBuffer();
		/**
		 * Using for each to use toString method on every new entry than appending it to
		 * the List
		 */
		employeePayrollList.forEach(employee -> {
			String employeeDataString = employee.toString().concat("\n");
			empBuffer.append(employeeDataString);
		});
		/**
		 * try and catch block IOExcepation
		 */
		try {
			Files.write(Paths.get(PAYROLL_FILE_NAME), empBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void printData() {
		try {
			Files.lines(new File(PAYROLL_FILE_NAME).toPath()).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * try and catch block IOExcepation countEntries method
	 */

	public long countEntries() {
		long entries = 0;
		try {
			entries = Files.lines(new File(PAYROLL_FILE_NAME).toPath()).count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return entries;
	}

	/*
	 * try and catch block IOExcepation List<EmployeePayrollData> readData() method
	 */

	public List<EmployeePayrollData> readData() {
		List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		try {
			Files.lines(new File(PAYROLL_FILE_NAME).toPath()).map(line -> line.trim())
					.forEach(line -> System.out.println(line));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return employeePayrollList;
	}

}