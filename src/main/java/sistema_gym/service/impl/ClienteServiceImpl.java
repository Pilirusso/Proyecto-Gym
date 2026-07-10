package sistema_gym.service.impl;
import sistema_gym.model.Cliente;
import sistema_gym.repository.ClienteRepository;
import sistema_gym.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente guardar(Cliente cliente) {

        validarCliente(cliente);

        if (clienteRepository.existsByDni(cliente.getDni())) {
            throw new RuntimeException("El DNI ya está registrado");
        }

        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente editar(Long id, Cliente cliente) {

        Cliente clienteExistente = buscarPorId(id);

        validarNombre(cliente.getNombre());
        validarApellido(cliente.getApellido());
        validarDni(cliente.getDni());
        validarTelefono(cliente.getTelefono());

        if (!clienteExistente.getDni().equals(cliente.getDni())
                && clienteRepository.existsByDni(cliente.getDni())) {

            throw new RuntimeException("El DNI ya está registrado");
        }

        clienteExistente.setNombre(cliente.getNombre());
        clienteExistente.setApellido(cliente.getApellido());
        clienteExistente.setDni(cliente.getDni());
        clienteExistente.setTelefono(cliente.getTelefono());
        clienteExistente.setActivo(cliente.getActivo());

        return clienteRepository.save(clienteExistente);
    }
    @Override
    public void eliminar(Long id) {

        Cliente cliente = buscarPorId(id);

        clienteRepository.delete(cliente);

    }

    @Override
    public List<Cliente> listar() {  // Le pide al repositorio todos los clientes
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    @Override
    public Cliente buscarPorDni(String dni) {
        return clienteRepository.findByDni(dni)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    @Override
    public List<Cliente> buscarPorNombre(String nombre) {
        return null;
    }

    @Override
    public List<Cliente> buscarPorApellido(String apellido) {
        return null;
    }

    // Validaciones para que todo este escrito correctamente

    private void validarCliente(Cliente cliente) {

        validarNombre(cliente.getNombre());
        validarApellido(cliente.getApellido());
        validarDni(cliente.getDni());
        validarTelefono(cliente.getTelefono());

    }

    private void validarNombre(String nombre) {

        if (nombre == null || nombre.isBlank()) {
            throw new RuntimeException("El nombre es obligatorio");
        }

    }
    private void validarApellido(String apellido) {

        if (apellido == null || apellido.isBlank()) {
            throw new RuntimeException("El apellido es obligatorio");
        }

    }

    private void validarDni(String dni) {

        if (dni == null || dni.isBlank()) {
            throw new RuntimeException("El DNI es obligatorio");
        }

        if (!dni.matches("\\d{8}")) {
            throw new RuntimeException("El DNI debe tener exactamente 8 números");
        }

    }

    private void validarTelefono(String telefono) {

        if (telefono == null || telefono.isBlank()) {
            throw new RuntimeException("El teléfono es obligatorio");
        }

        if (!telefono.matches("\\d{8,15}")) {
            throw new RuntimeException("El teléfono debe tener entre 8 y 15 números");
        }

    }

}