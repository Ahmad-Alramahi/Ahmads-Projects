package iastate.edu.Notification;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.socket.server.standard.ServerEndpointRegistration;

public class CustomNotificationConfigurator extends ServerEndpointRegistration.Configurator implements ApplicationContextAware 
{
	private static volatile BeanFactory context;

	@Override
	public <T> T getEndpointInstance(Class<T> endpoint) throws InstantiationException 
	{
		return context.getBean(endpoint);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException 
	{
		CustomNotificationConfigurator.context = applicationContext;
	}
}
