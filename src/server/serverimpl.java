package server;

import com.yan.test.UserEntity;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class serverimpl extends HibernateDaoSupport implements  server {
    private daoimpl idd;
    @Override
    public boolean save(UserEntity d) {
        int aa=this.idd.save(d);
        if(aa==0){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public UserEntity find(String name) {
        return this.idd.find(name);
    }

    public void setIdd(daoimpl idd) {
        this.idd=idd;
    }
}
