package sistema_gym.service;

import sistema_gym.model.Cliente;
import sistema_gym.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service //le dice a Spring que esta clase contiene la logica de negocio, es el lugar intermedio entre el controller (recibe pedidos de los usuarios) y el repository (que habla con la base de datos)
public class ClienteService {

    @Autowired // Le dice al sist Spring busca donde esta la instancia de ClienteRepository y conectala aca automaticamente, se llama INYECCION DE DEPENDENCIAS
    private ClienteRepository clienteRepository;

    // Guardar un nuevo cliente
    public Cliente guardarCliente(Cliente cliente) {
        // Aquí podríamos validar si el DNI ya existe antes de guardar
        return clienteRepository.save(cliente);
    }

    // Listar todos los clientes
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    // Buscar un cliente por DNI
    public Cliente buscarPorDni(String dni) {
        return clienteRepository.findByDni(dni);
    }

    // 5. Método para eliminar un cliente
    public void eliminarCliente(String dni) {
        Cliente cliente = clienteRepository.findByDni(dni);
        if (cliente != null) {
            clienteRepository.delete(cliente);
        }
    }

    public void registrarPago(String dni) {
        Cliente cliente = clienteRepository.findByDni(dni);

        if (cliente != null) {
            // Obtenemos la fecha actual
            LocalDate hoy = LocalDate.now();

            // Calculamos el día 10 del mes siguiente
            // Primero sumamos 1 mes, luego ponemos el día en 10
            LocalDate nuevoVencimiento = hoy.plusMonths(1).withDayOfMonth(10);

            // Actualizamos la fecha del cliente
            cliente.setFechaVencimiento(nuevoVencimiento);
            cliente.setFechaUltimoPago(hoy);

            // Guardamos los cambios en la base de datos
            clienteRepository.save(cliente);
        }
    }
}