package sistema_gym.service;

import sistema_gym.model.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente guardar(Cliente cliente);

    Cliente editar(Long id, Cliente cliente);

    void eliminar(Long id);

    List<Cliente> listar();

    Cliente buscarPorId(Long id);

    Cliente buscarPorDni(String dni);

    List<Cliente> buscarPorNombre(String nombre);

    List<Cliente> buscarPorApellido(String apellido);

}

