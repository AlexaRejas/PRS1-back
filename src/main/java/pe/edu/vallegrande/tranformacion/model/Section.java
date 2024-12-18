package pe.edu.vallegrande.tranformacion.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Section")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSection;

    private java.sql.Date updateDate;

    private String name;

    private String description;

    private Character status; // 'A' o 'I'
}