package skhu.gdsc.want_u.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import skhu.gdsc.want_u.domain.Maker;
import skhu.gdsc.want_u.domain.Product;
import skhu.gdsc.want_u.domain.dto.ProductDTO;
import skhu.gdsc.want_u.repository.MakerRepository;
import skhu.gdsc.want_u.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final MakerRepository makerRepository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(Product::toDTO)
                .collect(Collectors.toList());
    }

//    @Transactional
//    public ProductDTO findAllByMakerId(Long makerId) {
//        Maker maker = makerRepository.findById(makerId)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 ID의 maker가 존재하지 않습니다."));
//
//        List<Product> products = productRepository.findAllByMaker(maker);
//
//        return products.stream()
//                .map(Product::toDTO)
//                .collect(Collectors.toList());
//    }

    @Transactional
    public List<ProductDTO> findAllByMakerId(Long makerId) {

        Maker maker = makerRepository.findById(makerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 ID의 팀이 존재하지 않습니다."));

        List<Product> products = productRepository.findAllByMaker(maker);

        return products.stream()
                .map(Product::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        return findEntityById(id).toDTO();
    }

    @Transactional(readOnly = true)
    Product findEntityById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 ID와 일치하는 제품를 찾을 수 없습니다."));
    }

}
