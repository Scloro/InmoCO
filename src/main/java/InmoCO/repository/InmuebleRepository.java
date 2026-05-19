package InmoCO.repository;

import InmoCO.model.Inmueble;
import InmoCO.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InmuebleRepository extends JpaRepository<Inmueble, Long> {

    List<Inmueble> findByPropietario(Usuario propietario);
    
    List<Inmueble> findByCiudadContainingIgnoreCase(String ciudad);
    
    List<Inmueble> findByTipo(String tipo);
}