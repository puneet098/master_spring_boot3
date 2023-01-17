package arg.apring.app;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

@SpringBootApplication
public class SpringSingletonPrototypeinjectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSingletonPrototypeinjectionApplication.class, args);
		try(var context = 
				new AnnotationConfigApplicationContext
				(SpringSingletonPrototypeinjectionApplication.class)){
			
			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
			System.out.println("printing configuration class.");
			context.getBean(AppConfig.class);
			

		    SingletonBean firstSingleton = context.getBean(SingletonBean.class);
		    PrototypeBean firstPrototype = firstSingleton.getPrototypeBean();
		    
		    // get singleton bean instance one more time
		    try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		    
		    SingletonBean secondSingleton = context.getBean(SingletonBean.class);
		    
		    PrototypeBean secondPrototype = secondSingleton.getPrototypeBean();
		    try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		    
		    SingletonBean thirdSingleton = context.getBean(SingletonBean.class);
		    
		    PrototypeBean thirdPrototype = secondSingleton.getPrototypeBean();
		    
		    System.out.println("====Printing just calling prototype Bean");
		    PrototypeBean justProto = context.getBean(PrototypeBean.class);
		    System.out.println(justProto.getCounter()+"--------------"+justProto.hashCode());
		    PrototypeBean justProto01 = context.getBean(PrototypeBean.class);
		    System.out.println(justProto01.getCounter()+"--------------"+justProto.hashCode());
		    PrototypeBean justProto02 = context.getBean(PrototypeBean.class);
		    System.out.println(justProto01.getCounter()+"--------------"+justProto.hashCode());
		    
		    System.out.println("====Printing just calling Lookup Bean");
		    LookUpBean lookupBean = context.getBean(LookUpBean.class);
		    lookupBean.getPrototypeBean().getCounter();
		    System.out.println(lookupBean.getPrototypeBean().hashCode());
		    LookUpBean lookupBean01 = context.getBean(LookUpBean.class);
		    System.out.println(lookupBean01.getPrototypeBean().hashCode());
		    lookupBean01.getPrototypeBean().getCounter();
		    LookUpBean lookupBean02 = context.getBean(LookUpBean.class);
		    lookupBean02.getPrototypeBean().getCounter();
		    System.out.println(lookupBean02.getPrototypeBean().hashCode());
		    
		    
		   Assert.isTrue(firstPrototype.equals(secondPrototype), "The same instance should be returned");
			
		}
	}

}
