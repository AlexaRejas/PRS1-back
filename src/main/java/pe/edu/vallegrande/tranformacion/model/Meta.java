package pe.edu.vallegrande.tranformacion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "Meta")
public class Meta {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idMeta;

        private java.sql.Date initializationDate;

        private String name;

        private String description;

        private String objective;

        private String time;

        private Character status; // 'A' o 'I'

        @ManyToOne
        @JoinColumn(name = "id_section")
        private Section section; // Relación con Section
}
