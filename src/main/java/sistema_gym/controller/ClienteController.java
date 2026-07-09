package sistema_gym.controller;

import sistema_gym.model.Cliente;
import sistema_gym.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Le indica a Spring que esta clase manejara peticiones web (API REST)
@RequestMapping("/api/clientes") // Establece la URL base. Todo lo que pase por aqui empezara con /api/clientes.
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Crear cliente: POST /api/clientes
    @PostMapping // Se usa para enviar o crear informacion (como un pago o un alumno nuevo)
    public Cliente crear(@RequestBody Cliente cliente) {
        return clienteService.guardarCliente(cliente);
    }

    // Listar todos: GET /api/clientes
    @GetMapping // Se usa para consultar informacion
    public List<Cliente> listar() {
        return clienteService.listarTodos();
    }

    // Registrar pago: POST /api/clientes/pago/{dni}
    @PostMapping("/pago/{dni}")
    public void registrarPago(@PathVariable String dni) {
        clienteService.registrarPago(dni);
    }
//@PathVariable captura datos directamente desde la URL
    // Eliminar: DELETE /api/clientes/{dni}
    @DeleteMapping("/{dni}") // Se usa para eliminar informacion
    public void eliminar(@PathVariable String dni) {
        clienteService.eliminarCliente(dni);
    }
}

