package sistema_gym.controller;

import sistema_gym.model.Cliente;
import sistema_gym.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Obtener todos los clientes
    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listar();
    }

    // Buscar un cliente por ID
    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    // Crear un nuevo cliente
    @PostMapping
    public Cliente guardar(@RequestBody Cliente cliente) {
        return clienteService.guardar(cliente);
    }

    // Editar un cliente existente
    @PutMapping("/{id}")
    public Cliente editar(@PathVariable Long id,
                          @RequestBody Cliente cliente) {
        return clienteService.editar(id, cliente);
    }

    // Eliminar un cliente
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        clienteService.eliminar(id);
    }
}
