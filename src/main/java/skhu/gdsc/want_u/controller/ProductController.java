package skhu.gdsc.want_u.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import skhu.gdsc.want_u.domain.dto.ProductDTO;
import skhu.gdsc.want_u.service.MakerService;
import skhu.gdsc.want_u.service.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final MakerService makerService;


    //전체 리스트 출력
    @GetMapping("/main")
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<ProductDTO> responses = productService.findAll();

        if (responses.isEmpty()) {
            return ResponseEntity
                    .noContent()
                    .build();
        }
        return ResponseEntity.ok(responses);
    }


    @GetMapping("/main/{id}")
    public ResponseEntity<List<ProductDTO>> findAllMakerId(@PathVariable("id") Long id) {
        List<ProductDTO> responses = productService.findAllByMakerId(id);

        if (responses.isEmpty()) {
            return ResponseEntity
                    .noContent()
                    .build();
        }

        return ResponseEntity.ok(responses);
    }

//    //id를 불러와서 호출되면
//    @GetMapping("/main/{id}")
//    //id에 맞는 maker 불러옴
//    public ResponseEntity<MakerDTO> findById(@PathVariable Long id) { // @PathVariable: id를 파라미터로 받아 사용.
//        MakerDTO response = makerService.findById(id);
//
//        return ResponseEntity.ok(response);
//    }
}