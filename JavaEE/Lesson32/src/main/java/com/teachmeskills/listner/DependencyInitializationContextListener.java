package com.teachmeskills.listner;

import com.teachmeskills.service.FriendRequestService;
import com.teachmeskills.service.FriendService;
import com.teachmeskills.service.MessageService;
import com.teachmeskills.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.annotation.WebListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@Slf4j
@WebListener
public class DependencyInitializationContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        final ApplicationContext context = new ClassPathXmlApplicationContext("social-network.xml");
        final UserService userService = context.getBean(UserService.class);
        final FriendRequestService friendRequestService = context.getBean(FriendRequestService.class);
        final FriendService friendService = context.getBean(FriendService.class);
        final MessageService messageService = context.getBean(MessageService.class);

        sce.getServletContext().setAttribute("userService", userService);
        sce.getServletContext().setAttribute("friendRequestService", friendRequestService);
        sce.getServletContext().setAttribute("friendService", friendService);
        sce.getServletContext().setAttribute("messageService", messageService);
    }
}
