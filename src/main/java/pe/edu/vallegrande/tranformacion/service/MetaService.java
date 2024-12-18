package pe.edu.vallegrande.tranformacion.service;

import org.springframework.stereotype.Service;
import pe.edu.vallegrande.tranformacion.model.Meta;
import pe.edu.vallegrande.tranformacion.repository.MetaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MetaService {

    private final MetaRepository metaRepository;

    public MetaService(MetaRepository metaRepository) {
        this.metaRepository = metaRepository;
    }

    public List<Meta> getAllMetas() {
        return metaRepository.findAll();
    }

    public Optional<Meta> getMetaById(Long id) {
        return metaRepository.findById(id);
    }

    public List<Meta> getMetasByStatus(char status) {
        return metaRepository.findByStatus(status);
    }

    public Meta saveMeta(Meta meta) {
        return metaRepository.save(meta);  // Se guarda la meta actualizada o nueva
    }

    public void deleteMeta(Long id) {
        metaRepository.deleteById(id);
    }
}
