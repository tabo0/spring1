package server;

import com.yan.test.UserEntity;

public interface dao {
    public int save(UserEntity d);
    public UserEntity find(String name);
}
