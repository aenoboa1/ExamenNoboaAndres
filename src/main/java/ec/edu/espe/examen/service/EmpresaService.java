package ec.edu.espe.examen.service;

import ec.edu.espe.examen.controller.dto.EmpresaRQ;
import ec.edu.espe.examen.model.Empleado;
import ec.edu.espe.examen.model.Empresa;
import ec.edu.espe.examen.repository.EmpresaRepository;
import ec.edu.espe.examen.service.mapper.EmpresaMapper;
import org.springframework.stereotype.Service;


@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa createEmpresa(EmpresaRQ empresaRQ) {
        Empresa empresa = EmpresaMapper.empresaRQtoEmpresa(empresaRQ);
        for (Empleado empleado : empresa.getEmpleados()) {
            empleado.setNumeroDeCuenta(empresa.getCuentaPrincipal());
        }
        return this.empresaRepository.save(empresa);
    }


}
