package jp.co.onoda.kadai.db;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataAccessor {

	final static Logger logger = LoggerFactory.getLogger(DataAccessor.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Bean
	public String createtb() {
		jdbcTemplate.execute("CREATE TABLE EVENT_DATA (EVENT_NAME VARCHAR2(50), EVENT_DATE VARCHAR2(50), REMARKS VARCHAR2(500), PRIMARY KEY(EVENT_NAME))");
		return null;

	  }
	public int insertEventInfo(String eventName, String eventDate, String Remarks){
		int count = jdbcTemplate.update("INSERT INTO EVENT_DATA(EVENT_NAME,EVENT_DATE,REMARKS) VALUES(?,?,?)",
				eventName, eventDate, Remarks);
		return count;
	}

}
