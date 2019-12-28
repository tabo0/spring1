package server;
import com.yan.test.UserEntity;

public interface UserService {
    public void add(UserEntity user);
    public UserEntity find(String name);
}
