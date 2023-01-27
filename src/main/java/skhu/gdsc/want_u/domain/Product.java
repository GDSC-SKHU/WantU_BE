package skhu.gdsc.want_u.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import skhu.gdsc.want_u.domain.dto.ProductDTO;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(targetEntity = Maker.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "maker_id")
    private Maker maker;


    @Column(nullable = false)
    private String link;


    public ProductDTO toDTO() {
        return ProductDTO.builder()
                .id(id)
                .name(name)
                .link(link)
                .build();
    }

}
