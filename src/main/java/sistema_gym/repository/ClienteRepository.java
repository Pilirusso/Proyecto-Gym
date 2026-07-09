package sistema_gym.repository; // Cambiado

import sistema_gym.model.Cliente; // Esta linea le da permiso para ver y usar esa identidad
import org.springframework.data.jpa.repository.JpaRepository; //Trae la herramienta JPAREPOSITORY es una interfaz que ya tiene programada todos los metodos basicos para hablar con una bd
import org.springframework.stereotype.Repository; // le dice a spring que esta clase es un repositorio

@Repository // es una etiqueta que le dice a Spring: que el archivo debe ser gestionado por el contenedor de Spring. Permite que otros archivos (Como el service) pueden inyectar o usar ese repositorio mas facil
public interface ClienteRepository extends JpaRepository<Cliente, Long> { //Esto hace todo el trabajo. Spring boot analiza la clase cliente y genera auto todo el codigo necesaroi para comunciarse con gym_raido.db

    Cliente findByDni(String dni);
}

/*public interface ClienteRepository extends JpaRepository<Cliente, Long>:
interface: En Java, los repositorios se definen como interfaces. No llevan lógica propia, solo definen "qué" se puede hacer.
extends JpaRepository: Aquí ocurre la magia. Al heredar de JpaRepository, tu interfaz "hereda" automáticamente métodos como .save(), .findAll(), .deleteById(), etc.
<Cliente, Long>: Esto le dice a Spring: "Este repositorio va a gestionar objetos de tipo Cliente, y el identificador (@Id) de esos clientes es de tipo Long (número largo)".
{ }: Las llaves están vacías porque, gracias a Spring, no necesitas escribir nada más para que funcione.*/

