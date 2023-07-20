package ec.edu.espe.examen.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Empleado {
    private String cedulaDeIdentidad;
    private String apellidos;
    private String nombres;
    private String numeroDeCuenta;
}
