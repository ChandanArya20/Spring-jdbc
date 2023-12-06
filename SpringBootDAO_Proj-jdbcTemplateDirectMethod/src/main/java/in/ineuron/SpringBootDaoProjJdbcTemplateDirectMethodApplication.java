package in.ineuron;

import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.IEmployeeMangementService;

@SpringBootApplication
public class SpringBootDaoProjJdbcTemplateDirectMethodApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootDaoProjJdbcTemplateDirectMethodApplication.class, args);
		
		
		IEmployeeMangementService service = context.getBean(IEmployeeMangementService.class);
		List<Map<String, Object>> detailsByDesignation = service.getEmployeeDeatilsByDesignation("Batman", "Bowler");
		
		detailsByDesignation.forEach(System.out::println);
		
		context.close();
		
	}

}
