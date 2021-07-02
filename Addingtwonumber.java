package demo;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class MathTest
{
private MathDemo mathDemo;
 @Before
public void setUp() throws Exception
{
mathDemo = new MathDemo();
}
@After
public void tearDown() throws Exception
{
}
@Test
public void testAdd() 
{
int result = mathDemo.add(5,3);
assertEquals(result,8);
 }
  }




 







 











 



 







 



 



 

















 









