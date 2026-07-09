package sistema_gym.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity //le dice al hibernate que esta clase representa una tbla en la base de datos, si no se pone la bd ignora la clase
public class Cliente {
    @Id //identifica que campo es la PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //le dice a la bd, que no esriba el Id a mano, sino que la bd lo cree automaticamente
    private Long id;

    private String nombre;
    private String apellido;

    @Column(unique = true) //ESTO CUMPLE CON LA REGLA DE NEGOCIO RN-01 (evita duplicados)
    private String dni;

    private String telefono;

    private LocalDate fechaAlta;
    private LocalDate fechaUltimoPago;
    private LocalDate fechaVencimiento;
    private boolean activo;

    // Constructor vacío necesario para Spring Data JPA
    public Cliente() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDate getFechaUltimoPago() {
        return fechaUltimoPago;
    }

    public void setFechaUltimoPago(LocalDate fechaUltimoPago) {
        this.fechaUltimoPago = fechaUltimoPago;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}

