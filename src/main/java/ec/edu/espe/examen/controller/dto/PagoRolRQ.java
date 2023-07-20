package ec.edu.espe.examen.controller.dto;

import lombok.Builder;
import lombok.Data;
import java.util.Date;
import java.util.List;


@Data
@Builder
public class PagoRolRQ {
    private String mes;
    private Date fechaProceso;
    private String rucEmpresa;
    private String cuentaPrincipal;
    private List<EmpleadoPagoRQ> empleadosPago;

}

