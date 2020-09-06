package snowboard.orderservice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import snowboard.orderservice.domain.Order;

public interface OrderRepo extends MongoRepository<Order, String> {
}
