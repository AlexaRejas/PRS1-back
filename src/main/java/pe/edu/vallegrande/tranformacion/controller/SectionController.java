package pe.edu.vallegrande.tranformacion.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.tranformacion.model.Section;
import pe.edu.vallegrande.tranformacion.service.SectionService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/sections")
public class SectionController {

    private final SectionService sectionService;

    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @GetMapping
    public List<Section> getAllSections() {
        return sectionService.getAllSections();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Section> getSectionById(@PathVariable Long id) {
        return sectionService.getSectionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Section createSection(@RequestBody Section section) {
        return sectionService.saveSection(section);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Section> updateSection(@PathVariable Long id, @RequestBody Section section) {
        return sectionService.getSectionById(id)
                .map(existing -> {
                    section.setIdSection(id);
                    return ResponseEntity.ok(sectionService.saveSection(section));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSection(@PathVariable Long id) {
        sectionService.deleteSection(id);
        return ResponseEntity.noContent().build();
    }
}