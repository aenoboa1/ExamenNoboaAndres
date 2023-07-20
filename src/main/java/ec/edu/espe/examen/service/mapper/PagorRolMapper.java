package ec.edu.espe.examen.service.mapper;

import ec.edu.espe.examen.controller.dto.PagoRolRQ;
import ec.edu.espe.examen.model.PagoRol;

public class PagorRolMapper {

    public static PagoRol transformPagoRol(PagoRolRQ pagoRolRQ) {
        return PagoRol.builder()
                .mes(pagoRolRQ.getMes())
                .rucEmpresa(pagoRolRQ.getRucEmpresa())
                .cuentaPrincipal(pagoRolRQ.getCuentaPrincipal())
                .build();
    }
}
