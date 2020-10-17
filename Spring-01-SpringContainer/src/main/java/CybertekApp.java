import interfaces.Mentor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.FullTimeMentor;

public class CybertekApp {

    public static void main(String[] args)  {

        // Way 1 : BeanFactory to create Bean Container
        BeanFactory container = new ClassPathXmlApplicationContext("config.xml");

        // interface: old way to create Lossly Coupled
        // Mentor mentor = new FullTimeMentor();


        // container : new way to create lossley coupled
        // important , we need to casting it to Mentor
        Mentor mentor = (Mentor) container.getBean("partTimeMentor");

        mentor.createAccount();




        // way 2 : ApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        Mentor mentor1 = (Mentor) context.getBean("fullTimeMentor");

        mentor1.createAccount();


        // way 3 : no need to casting to create bean

        BeanFactory container2 = new ClassPathXmlApplicationContext("config.xml");

        Mentor mentor2 = container2.getBean("partTimeMentor",Mentor.class);

        mentor2.createAccount();



    }

}
