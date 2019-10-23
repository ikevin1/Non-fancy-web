package springxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springxml.beans.Comdeian;

public class SpringApp {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Comdeian theComdeian = context.getBean("myComdeian", Comdeian.class);

        System.out.println(theComdeian.getName());
        System.out.println(theComdeian.getDescription());

        theComdeian.loggingChange();


        context.close();// close the context
    }
}

