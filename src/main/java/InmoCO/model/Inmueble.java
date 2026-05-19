package InmoCO.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "inmuebles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inmueble {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal precio;

    @Column(nullable = false)
    private String tipo;           

    @Column(nullable = false)
    private String estado;         

    private Integer habitaciones;
    private Integer banos;
    private Double area;           

    @Column(nullable = false)
    private String ciudad;

    @Column(nullable = false)
    private String direccion;

    private String imagenPrincipal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario propietario;

    private LocalDateTime fechaPublicacion = LocalDateTime.now();
}