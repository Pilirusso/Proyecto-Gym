package sistema_gym.repository; // Cambiado

import sistema_gym.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByDni(String dni);

    boolean existsByDni(String dni);

    List<Cliente> findByNombreContainingIgnoreCase(String nombre);

    List<Cliente> findByApellidoContainingIgnoreCase(String apellido);

}
/*public interface ClienteRepository extends JpaRepository<Cliente, Long>:
interface: En Java, los repositorios se definen como interfaces. No llevan lógica propia, solo definen "qué" se puede hacer.
extends JpaRepository: Aquí ocurre la magia. Al heredar de JpaRepository, tu interfaz "hereda" automáticamente métodos como .save(), .findAll(), .deleteById(), etc.
<Cliente, Long>: Esto le dice a Spring: "Este repositorio va a gestionar objetos de tipo Cliente, y el identificador (@Id) de esos clientes es de tipo Long (número largo)".
{ }: Las llaves están vacías porque, gracias a Spring, no necesitas escribir nada más para que funcione.*/

