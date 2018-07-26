/*package bookshelf.appConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInit implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(BookShelfAppConfig.class);
		
		DispatcherServlet servlet = new DispatcherServlet(appContext);
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("app", servlet);
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
	}

}
*/