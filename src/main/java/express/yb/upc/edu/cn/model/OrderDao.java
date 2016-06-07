package express.yb.upc.edu.cn.model;

import org.aspectj.weaver.ast.Or;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wh980 on 2016/5/30.
 */
public interface OrderDao extends CrudRepository<Order,Integer>
{
    public Iterable<Order> findAll(Sort sort);
    public Iterable<Order> findByYibanid(String yibanid);
    public Iterable<Order> findById(int id);

}