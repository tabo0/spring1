package server;

import com.yan.test.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserServiceImpl implements UserService {
    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void add(UserEntity user) {
        Session s = sessionFactory.openSession();
        Transaction tx= s.beginTransaction();
        s.save(user);
        tx.commit();
    }
    @Override
    public UserEntity find(String name) {
        Session s = sessionFactory.openSession();
        Transaction tx= s.beginTransaction();
        UserEntity ans=s.get(UserEntity.class,name);
        tx.commit();
        return ans;
    }

}
