package ec.edu.espe.examen.service.mapper;

import ec.edu.espe.examen.controller.dto.EmpleadoPagoRQ;
import ec.edu.espe.examen.controller.dto.PagoRolRQ;
import ec.edu.espe.examen.model.EmpleadoPago;
import ec.edu.espe.examen.model.PagoRol;

public class PagoRolMapper {

    public static PagoRol PagoRolRQtoPagoRol(PagoRolRQ pagoRolRQ) {
        return PagoRol.builder()
                .mes(pagoRolRQ.getMes())
                .rucEmpresa(pagoRolRQ.getRucEmpresa())
                .cuentaPrincipal(pagoRolRQ.getCuentaPrincipal())
                .build();
    }
    public static EmpleadoPago EmpleadoPagoRQtoEmpleadoPago(EmpleadoPagoRQ empleadoPago) {
        return EmpleadoPago.builder()
                .numeroCuenta(empleadoPago.getNumeroCuenta())
                .valor(empleadoPago.getValor())
                .build();
    }
}
