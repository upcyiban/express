package express.yb.upc.edu.cn.model;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wanghaojun on 2016/5/31.
 */
public class OrderStatusDao {
    public interface CompetitionDao extends CrudRepository<OrderStatus,Integer> {
        public Iterable<OrderStatus> findAll(Sort sort);
    }
}
