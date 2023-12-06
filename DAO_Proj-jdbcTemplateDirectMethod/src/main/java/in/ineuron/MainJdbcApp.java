package in.ineuron;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.service.IEmployeeMangementService;

public class MainJdbcApp 
{
    public static void main( String[] args ){
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");
    	
    	
    	IEmployeeMangementService service = context.getBean(IEmployeeMangementService.class);
    	
    	try {
    		
			int empsCount = service.fetchEmpsCount();
			System.out.println("No of records are :: " + empsCount);
			
			
			String name=service.getEmployeeNameByNo(2);
			System.out.println("Employee name is : "+name);
			
			
			Map<String, Object> empDetails = service.getEmployeeDetailsByNo(3);
			System.out.println("Employee details are : "+empDetails);
			
			
			List<Map<String, Object>> detailsByDesignation = service.getEmployeeDeatilsByDesignation("Batman", "Bowler");
			
			detailsByDesignation.forEach(System.out::println);
			
//			int insertRowAffected = service.insertEmp("Sanju", "KKR", 30000, "Batman");
//			System.out.println("Insert Row affected "+insertRowAffected);
			
//			int updateRowAffected = service.addBonusToEmpByDesg("Batman", 1000);
//			System.out.println("Update Row affected "+updateRowAffected);
			
			int deleteRowAffected = service.deleteEmployee(7);
			System.out.println("Delete Row affected "+deleteRowAffected);
			
			
			
			
			
		} catch (Exception e) {
			System.out.println("The exception msg is ::" + e.getMessage());
		}
    	
    	((AbstractApplicationContext) context).close();
    }
}
