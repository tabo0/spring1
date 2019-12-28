package action;

import com.opensymphony.xwork2.ActionContext;
import com.yan.test.UserEntity;
import com.yan.test.hiber;
import org.springframework.beans.factory.annotation.Autowired;
import server.UserServiceImpl;

import java.util.Map;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

public class login {
    @Autowired
    private UserServiceImpl userService;
    private String userName;
    private String password;
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
    public String login(){
        Map session = ActionContext.getContext().getSession();
        UserEntity user=userService.find(userName);
        if(user==null) return ERROR;
        if((user.getPassword()).compareTo(password)==0){
            session.put("message", "hello "+userName +"!");
            return SUCCESS;
        }else return ERROR;

    }
    public String rigister(){
        Map session = ActionContext.getContext().getSession();
        UserEntity user=new UserEntity();
        user.setName(userName);
        user.setPassword(password);
        userService.add(user);
        session.put("message", "注册成功");
        return SUCCESS;
    }
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }
}
