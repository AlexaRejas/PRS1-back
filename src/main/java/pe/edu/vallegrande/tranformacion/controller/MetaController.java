package pe.edu.vallegrande.tranformacion.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.tranformacion.model.Meta;
import pe.edu.vallegrande.tranformacion.model.Section;
import pe.edu.vallegrande.tranformacion.service.MetaService;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/metas")
public class MetaController {

    private final MetaService metaService;

    public MetaController(MetaService metaService) {
        this.metaService = metaService;
    }

    @GetMapping
    public List<Meta> getAllMetas() {
        return metaService.getAllMetas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meta> getMetaById(@PathVariable Long id) {
        return metaService.getMetaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/status/{status}")
    public List<Meta> getMetasByStatus(@PathVariable String status) {
        return metaService.getMetasByStatus(status.charAt(0)); // Convert String to Character
    }

    @PostMapping
    public Meta createMeta(@RequestBody Meta meta) {
        return metaService.saveMeta(meta);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Meta> updateMeta(@PathVariable Long id, @RequestBody Meta meta) {
        return metaService.getMetaById(id)
                .map(existing -> {
                    meta.setIdMeta(id);
                    return ResponseEntity.ok(metaService.saveMeta(meta));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeta(@PathVariable Long id) {
        metaService.deleteMeta(id);
        return ResponseEntity.noContent().build();
    }
}
