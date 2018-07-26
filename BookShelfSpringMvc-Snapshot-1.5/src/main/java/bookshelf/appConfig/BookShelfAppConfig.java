package bookshelf.appConfig;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.mchange.v2.c3p0.ComboPooledDataSource;



@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "bookshelf")
@PropertySource({"classPath:persistence-mysql.properties"})
public class BookShelfAppConfig  implements WebMvcConfigurer{

	// Set up variable to hold that the db properties
	
	@Autowired
	private Environment env;
	
	// Set up LOGGER for diagnostics
	
	private Logger LOGGER = Logger.getLogger(getClass().getName());
	
	
//	@Bean
//	public ViewResolver viewResolver() {
//		
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		
//		viewResolver.setPrefix("/WEB-INF/view/");
//		viewResolver.setSuffix(".jsp");
//		
//		viewResolver.setViewClass(JstlView.class);
//		return viewResolver;
//	}
	
	// define a bean for security dataSource
	
	@Bean
	public DataSource securityDataSource() {
		
		// create connection pool
		ComboPooledDataSource securityDataSource 
									= new ComboPooledDataSource();
			
		
		
		// set the JDBC driver class
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		
		
		// log the connection props
		// just to make sure we are reading data from properties files
		
		LOGGER.info(">>> jdbc.url " + env.getProperty("jdbc.url"));
		LOGGER.info(">>> jdbc.user " + env.getProperty("jdbc.user"));
		
		
		// set database connection props
		
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		// set connection pool props
		
		securityDataSource.setInitialPoolSize(
				getIntProperty("connection.pool.initialPoolSize"));
		
		securityDataSource.setMinPoolSize(
				getIntProperty("connection.pool.minPoolSize"));
		
		securityDataSource.setMaxPoolSize(
				getIntProperty("connection.pool.maxPoolSize"));
		
		securityDataSource.setMaxIdleTime(
				getIntProperty("connection.pool.maxIdleTime"));
		
		
		return securityDataSource;
	}
	
	private Properties getHibernateProperties() {

		// set hibernate properties
		Properties props = new Properties();

		props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		
		return props;				
	}
	
	// need a helper method
	// read envieronment property and convert to int
	
	private int getIntProperty(String propName) {
		
		String propVal = env.getProperty(propName);
		
		int intPropVal = Integer.parseInt(propVal);
		
		return intPropVal;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		
		// create session factory
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		// set the properties
		sessionFactory.setDataSource(securityDataSource());
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());
		
		return sessionFactory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		
		// setup transaction manager based on session factory
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}	
	
}
