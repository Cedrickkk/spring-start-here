package org.spring.framework.sqch9ex2.processors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.spring.framework.sqch9ex2.services.LoggedUserManagementService;

@Component
public class LoginProcessor {
    private static final Log log = LogFactory.getLog(LoginProcessor.class);
    private String username;
    private String password;
    private final LoggedUserManagementService loggedUserManagementService;

    @Autowired
    public LoginProcessor(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    public boolean login() {
        String username = this.getUsername();
        String password = this.getPassword();
        boolean loginResult = false;

        if (username.equals("hula@nm0") && password.equals("p@ssw0rd")) {
            loginResult = true;
            loggedUserManagementService.setUsername(username);
        }

        return loginResult;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
