package ec.edu.espe.examen.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Builder
public class EmpleadosPago {
    private String numeroCuenta;
    private BigDecimal valor;
    private String Estado;

}
