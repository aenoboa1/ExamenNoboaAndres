package ec.edu.espe.examen.controller.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class EmpleadoPagoRQ {
    private String numeroCuenta;
    private String Estado;

}
