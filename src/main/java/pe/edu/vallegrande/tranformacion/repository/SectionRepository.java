package pe.edu.vallegrande.tranformacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.vallegrande.tranformacion.model.Section;

public interface SectionRepository extends JpaRepository<Section, Long> {
}