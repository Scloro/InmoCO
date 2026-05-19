package InmoCO.service;

import InmoCO.model.Inmueble;
import InmoCO.model.Usuario;
import InmoCO.repository.InmuebleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InmuebleService {

    private final InmuebleRepository inmuebleRepository;

    public InmuebleService(InmuebleRepository inmuebleRepository) {
        this.inmuebleRepository = inmuebleRepository;
    }

    @Transactional
    public Inmueble guardarInmueble(Inmueble inmueble) {
        return inmuebleRepository.save(inmueble);
    }

    public List<Inmueble> listarTodos() {
        return inmuebleRepository.findAll();
    }

    public List<Inmueble> listarPorPropietario(Usuario propietario) {
        return inmuebleRepository.findByPropietario(propietario);
    }

    public List<Inmueble> buscarPorCiudad(String ciudad) {
        return inmuebleRepository.findByCiudadContainingIgnoreCase(ciudad);
    }

    public List<Inmueble> buscarPorTipo(String tipo) {
        return inmuebleRepository.findByTipo(tipo);
    }

    public Optional<Inmueble> buscarPorId(Long id) {
        return inmuebleRepository.findById(id);
    }

    @Transactional
    public void eliminarInmueble(Long id) {
        inmuebleRepository.deleteById(id);
    }
}