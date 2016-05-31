package express.yb.upc.edu.cn.model;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wh980 on 2016/5/30.
 */
public class OrderDao {
    public interface CompetitionDao extends CrudRepository<Order,Integer> {
        public Iterable<Order> findAll(Sort sort);
    }
}
