package java;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.icf.demo.datatypes.Employee;
import com.example.icf.demo.datatypes.EmployeeEntity;

public class EmpData {
	JdbcTemplate jdbctemplate;
	EntityManagerFactory entityManagerFactory;
String getEmployeeSql="Select * from Employee";

	public Employee findEmpoylee(String id)
	{
		EntityManager em=entityManagerFactory.createEntityManager();
		return em.find(Employee.class, id);	
	}

	public String addEmpoylee(Employee employee) throws Exception
	{
		EntityManager em=entityManagerFactory.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(employee);
		et.commit();
		return "Employee Added Successfully";
	}

	public String updateEmpoylee(Employee employee) throws Exception
	{
		//creating EntityManager for query
		EntityManager em=entityManagerFactory.createEntityManager();
		//find method
		EmployeeEntity employeeEntity=em.find(EmployeeEntity.class, employee.getId());
		if(employeeEntity==null)
			throw new Exception("Empolyee not found for update");
		EntityTransaction et=em.getTransaction();
		et.begin();
		employeeEntity.setAddress(employee.getAddress());
		employeeEntity.setBloodgroup(employee.getBloodgroup());
		employeeEntity.setDepartement(employee.getDepartement());
		employeeEntity.setDesignation(employee.getDesignation());
		employeeEntity.setDob(employee.getDob());
		employeeEntity.setEmployeeid(employee.getemployeeid());
		employeeEntity.setEnddate(employee.getEnddate());
		employeeEntity.setFirstname(employee.getFirstname());
		employeeEntity.setGender(employee.getGender());
		employeeEntity.setId(employee.getId());
		employeeEntity.setLastname(employee.getLastname());
		employeeEntity.setReportingmanager(employee.getReportingmanager());
		employeeEntity.setStatus(employee.getStatus());
		employeeEntity.setStartdate(employee.getStartdate());
		et.commit();
		return "Employee Updated Successfully";
	}

	public String deleteEmpoylee(String id) throws Exception
	{
		EntityManager em=entityManagerFactory.createEntityManager();
		EmployeeEntity employeeEntity=em.find(EmployeeEntity.class, id);
		if(employeeEntity==null)
			throw new Exception("Empolyee not found for delete");
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.remove(employeeEntity);
		et.commit();
		return "Employee removed Successfully";
	}

}
