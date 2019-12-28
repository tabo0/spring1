package server;

import com.yan.test.UserEntity;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW )
public class daoimpl extends HibernateDaoSupport implements dao{
    HibernateTemplate ht;

    public void setHt(HibernateTemplate ht) {
        this.ht = ht;
    }

    @Override
    public int save(UserEntity d) {
        try {
            //调用我们定义的接口  增加数据
            ht.save(d);
            return 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            return 1;
        }
    }

    @Override
    public UserEntity find(String name) {
        UserEntity dd=ht.get(UserEntity.class, name);
        return dd;
    }
}
