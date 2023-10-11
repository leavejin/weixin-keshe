import com.dada.pojo.Courier;
import com.dada.pojo.Mail;
import com.dada.pojo.NetAdmin;
import com.dada.pojo.Users;
import com.dada.service.CourierService;
import com.dada.service.MailService;
import com.dada.service.NetAdminService;
import com.dada.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserService userServiceImpl = (UserService) context.getBean("UserServiceImpl");
//        for (Users users : userServiceImpl.queryAllUser()) {
//            System.out.println(users);
//        }
//        NetAdminService netAdminServiceImpl = (NetAdminService) context.getBean("NetAdminServiceImpl");
//        Mail mail = new Mail(1, "林轩逸", "137777777", "福州", "林大帅", "1388888", "北京", "食品", "5", "50");
//        mailServiceImpl.addMail(mail);
//        Mail mail1 = mailServiceImpl.queryMailByNumber("137777777");
//        System.out.println(mail1);
//        for (Mail mail : mailServiceImpl.queryAllMail()) {
//            System.out.println(mail);
//        }
//        NetAdmin netAdmin = netAdminServiceImpl.queryNetAdminByNumber("288");
//        CourierService courierServiceImpl = (CourierService) context.getBean("CourierServiceImpl");
//        System.out.println(courierServiceImpl.queryCourierLike("福州"));
        MailService mailServiceImpl = (MailService) context.getBean("MailServiceImpl");
//        List<Mail> mail = mailServiceImpl.selectMailByCourierNumber("1388888");
        List<Mail> mail1 = mailServiceImpl.queryAllMail();
        for (int i = 0; i < mail1.size(); i ++ ) {
            Mail mail = mail1.get(i);
            System.out.println("i == > " + i + "  == >>" + mail.getDotName() + "   type " +  mail.getDotName().getClass());
            if (mail.getDotName()!= null && !"".equals(mail.getDotName())) {
                Mail remove = mail1.remove(i);
                System.out.println("remove==>" + remove);
                i--;
            }
        }
        System.out.println(mail1);
    }
}
