package server;

import com.yan.test.UserEntity;

public interface server {
    public boolean save(UserEntity d);
    public UserEntity find(String name);
}
