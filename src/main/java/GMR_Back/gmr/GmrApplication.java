package GMR_Back.gmr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("GMR_Back.gmr.model.mapper")
public class GmrApplication {

	public static void main(String[] args) {
		SpringApplication.run(GmrApplication.class, args);
	}

}
