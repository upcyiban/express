package express.yb.upc.edu.cn.model;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by lenovo on 2016/5/31.
 */
public interface UserDao {
    public interface CompetitonDao extends CrudRepository<User,Integer>{

    }
}
