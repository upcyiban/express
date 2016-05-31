package express.yb.upc.edu.cn.model;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by lenovo on 2016/5/31.
 */
public interface UserDao {
    public interface CompetitionDao extends CrudRepository<User,Integer>{
        public Iterable<OrderStatus> findAll(Sort sort);
    }
}
