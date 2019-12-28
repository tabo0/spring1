package action;

import com.opensymphony.xwork2.ActionSupport;

import com.yan.test.UserEntity;

import server.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;



public class UserAction extends ActionSupport {
    private String userName;
    private String password;
    @Autowired
    private UserServiceImpl userService;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String add(){
        UserEntity user = new UserEntity();
        user.setName(getUserName());
        user.setPassword(getPassword());
        userService.add(user);
        return SUCCESS;
    }
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }
}