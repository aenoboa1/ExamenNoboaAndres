package ec.edu.espe.examen.service.mapper;

import ec.edu.espe.examen.controller.dto.EmpleadoRQ;
import ec.edu.espe.examen.controller.dto.EmpresaRQ;
import ec.edu.espe.examen.model.Empleado;
import ec.edu.espe.examen.model.Empresa;

public class EmpresaMapper {

    public static Empresa empresaRQtoEmpresa(EmpresaRQ empresaRQ) {
        return Empresa.builder()
                .ruc(empresaRQ.getRuc())
                .razonSocial(empresaRQ.getRazonSocial())
                .cuentaPrincipal(empresaRQ.getCuentaPrincipal())
                .build();
    }


}
