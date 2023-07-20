package ec.edu.espe.examen.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmpleadoRQ {
    private String cedulaDeIdentidad;
    private String apellidos;
    private String nombres;
    private String numeroDeCuenta;
}
