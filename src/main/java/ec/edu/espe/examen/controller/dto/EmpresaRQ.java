package ec.edu.espe.examen.controller.dto;

import ec.edu.espe.examen.model.Empleado;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Builder
public class EmpresaRQ {
    private String ruc;
    private String razonSocial;
    private String cuentaPrincipal;
    private List<EmpleadoRQ> empleados;
}
