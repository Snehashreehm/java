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
import java.io.e_update;
import java.io.Empdata2;
import java.io.Empdata1;

public class MainController {
	Empdata2 empdata;
	HttpServletRequest httpServletRequest;
	Logger logger = LoggerFactory.getLogger(MainController.class);
(path = "/findemp",method = RequestMethod.GET)
	public ResponseEntity<Emp> getEmp1(@RequestHeader String id) throws Exception
	{	
		logger.info("   ip addr :"+httpServletRequest.getLocalAddr()+
					"   Date and Time : "+LocalDateTime.now().toString()
					+"  Browser info :  "+ httpServletRequest.getHeader("User-Agent"));
		Emp1 e=empdata2.findEmp1(id);
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

			return ResponseEntity.ok(emp2.addEmp1(emp1));
		}
		catch(Exception e)
		{
			logger.error("No Employee found error");
			return Response.badRequest(e.getMessage());
		}
	}
(path = "/updateemp",method = RequestMethod.PUT)
	public ResponseEntity<String> updateEmp1(@RequestBody Emp1 employee) throws Exception
	{	
		try {
			logger.info("   ip addr :"+httpServletRequest.getLocalAddr()+
					"   Date and Time : "+LocalDateTime.now().toString()
					+"  Browser info :  "+ httpServletRequest.getHeader("User-Agent"));		
      
			return ResponseEntity.ok(emp2.updateEmp1(employee));
		}
	
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
			String e=empdata.deleteEmployee(id);
		return ResponseEntity.ok(e);


		}
		catch(Exception e)
		{
			logger.error("No Employee found error");
			return Response.badRequest(e.getMessage());
		}

	}
}
