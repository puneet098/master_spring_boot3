package arg.apring.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public PrototypeBean prototypeBean() {
		return new PrototypeBean();
	}
	
	
	@Bean
    public SingletonBean singletonBean() {
        return new SingletonBean();
    }
	
	@Bean
    public LookUpBean LookUpBean() {
        return new LookUpBean();
    }
}

class PrototypeBean{

	@SuppressWarnings("removal")
	protected  static Integer counter = new Integer(0);
	
	/**
	 * 
	 */
	public PrototypeBean() {
		super();
		counter++;
		System.out.println(" PrototypeBean is created");
	}
	
	public static Integer getCounter() {
		return counter;
	}
	
	
	
}

class SingletonBean{
	
	@SuppressWarnings("unused")
	@Autowired
	private PrototypeBean prototypeBean;

	/**
	 * 
	 */
	public SingletonBean() {
		System.out.println(" SingletonBean is created");
	}

	public PrototypeBean getPrototypeBean() {
		System.out.println(prototypeBean.getCounter());
		return prototypeBean;
	}	
}


class LookUpBean{
	
	@Autowired
	private PrototypeBean prototypeBean;

	/**
	 * 
	 */
	public LookUpBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Lookup
	public PrototypeBean getPrototypeBean() {
		System.out.println(prototypeBean.getCounter());
		return prototypeBean;
	}
	
}