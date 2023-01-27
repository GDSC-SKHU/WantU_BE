package skhu.gdsc.want_u.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import skhu.gdsc.want_u.domain.Maker;
import skhu.gdsc.want_u.domain.dto.MakerDTO;
import skhu.gdsc.want_u.repository.MakerRepository;

@Service
@RequiredArgsConstructor
public class MakerService {

    private final MakerRepository makerRepository;

    @Transactional(readOnly = true)
    public MakerDTO findById(Long id) {
        Maker maker = findEntityById(id);

        return maker.toDTO();
    }

    @Transactional(readOnly = true)
    Maker findEntityById(Long id) {
        return makerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 ID로 Maker 찾을 수 없음"));
    }
}
