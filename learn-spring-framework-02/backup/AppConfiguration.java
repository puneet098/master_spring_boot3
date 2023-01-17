package arg.apring.app;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Configuration
@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
public class AppConfiguration {
	@Autowired
	private NormalClass normalClass;
	
    
    
    
}



@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PrototypeClass{
	private static final AtomicInteger instanceCounter = new AtomicInteger(0);

	PrototypeClass(){
		instanceCounter.incrementAndGet();
	}

	static int getInstanceCounter() {
		return instanceCounter.get();
	}
}

@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
class NormalClass{
	/*0 this is constructor injection
	 * prints only once 
	 */
	
	@Autowired
	public NormalClass(PrototypeClass proto) {
		System.out.println("now count is: "+proto.getInstanceCounter());
	}
	
	
	
}

