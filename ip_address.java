package java;
import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.icf.demo.datatypes.Employee;
import com.example.icf.demo.datatypes.Response;
import com.example.icf.demo.service.EmployeeService;
public class MainController {
	EmployeeService employeeService;
	HttpServletRequest httpServletRequest;
Logger logger = LoggerFactory.getLogger(MainController.class);
(path = "/findemp",method = RequestMethod.GET)
	public ResponseEntity<Employee> getEmployee(@RequestHeader String id) throws Exception
	{	
		logger.info("   ip addr :"+httpServletRequest.getLocalAddr()+
					"   Date and Time : "+LocalDateTime.now().toString()
					+"  Browser info :  "+ httpServletRequest.getHeader("User-Agent"));

		Employee e=employeeService.findEmployee(id);
		if(e==null)
		{
			logger.error("No Employee found error");
			return Response.badRequest(e);
		}

		return ResponseEntity.ok(e);
	}

	(path = "/addemp",method = RequestMethod.POST)
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) throws Exception
	{	
		try {

			logger.info("   ip addr :"+httpServletRequest.getLocalAddr()+
					"   Date and Time : "+LocalDateTime.now().toString()
					+"  Browser info :  "+ httpServletRequest.getHeader("User-Agent"));		

			king service class method

			return ResponseEntity.ok(employeeService.addEmployee(employee));
		}
		//Handling exception and returning required messsage
		catch(Exception e)
		{
			logger.error("No Employee found error");
			return Response.badRequest(e.getMessage());
		}
	}
(path = "/updateemp",method = RequestMethod.PUT)
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) throws Exception
	{	
		try {

			// Logging ip,dateTime and Browser info
			logger.info("   ip addr :"+httpServletRequest.getLocalAddr()+
					"   Date and Time : "+LocalDateTime.now().toString()
					+"  Browser info :  "+ httpServletRequest.getHeader("User-Agent"));		

			//invoking service class method

			return ResponseEntity.ok(employeeService.updateEmployee(employee));
		}
		//Handling exception and returning required messsage

		catch(Exception e)
		{

			logger.error("No Employee found error");
			return Response.badRequest(e.getMessage());
		}
	}

(path = "/deleteemp",method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteEmployee(@RequestHeader String id) throws Exception
	{	
		try 
		{
			logger.info("   ip addr :"+httpServletRequest.getLocalAddr()+
					"   Date and Time : "+LocalDateTime.now().toString()
					+"  Browser info :  "+ httpServletRequest.getHeader("User-Agent"));		
			//invoking service class method
			String e=employeeService.deleteEmployee(id);
		return ResponseEntity.ok(e);


		}
		
		catch(Exception e)
		{
			logger.error("No Employee found error");
			return Response.badRequest(e.getMessage());
		}

	}
}
