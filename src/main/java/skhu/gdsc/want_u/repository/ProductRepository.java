package skhu.gdsc.want_u.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skhu.gdsc.want_u.domain.Maker;
import skhu.gdsc.want_u.domain.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findAllByMaker(Maker maker);

}
