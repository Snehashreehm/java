package javaa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.EmpData;
import java.Emp;

public class EmployeeService{
	EmployeeData employeeData;

	public Employee findEmployee(String id)
	{
		return employeeData.findEmpoylee(id);
	}

	public String addEmployee(Employee employee) throws Exception
	{
		try
		{

			return employeeData.addEmpoylee(employee);
		}
		catch (Exception se) {
			throw new Exception("Error:  id already exists");
		}


	}

	public String updateEmployee(Employee employee) throws Exception
	{
			if(employee.getemployeeid()==null)
				throw new Exception("employee id cannot be null");
			return employeeData.updateEmpoylee(employee);	

	}

	public String deleteEmployee(String id) throws Exception
	{
			return employeeData.deleteEmpoylee(id);

	}
}
