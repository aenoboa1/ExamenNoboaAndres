package ec.edu.espe.examen.service;

import ec.edu.espe.examen.controller.dto.EmpleadoRQ;
import ec.edu.espe.examen.controller.dto.EmpresaRQ;
import ec.edu.espe.examen.model.Empleado;
import ec.edu.espe.examen.model.Empresa;
import ec.edu.espe.examen.repository.EmpresaRepository;
import ec.edu.espe.examen.service.mapper.EmpresaMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa createEmpresa(EmpresaRQ empresaRQ) {
        Empresa empresaOpt = EmpresaMapper.empresaRQtoEmpresa(empresaRQ);
        Optional<Empresa> empresa = this.empresaRepository.findByRuc(empresaOpt.getRuc());
        if (empresa.isPresent()) {
            throw new RuntimeException("Ya existe una empresa con ese ruc");
        } else {
            List<Empleado> empleados = new ArrayList<>();
            for (EmpleadoRQ empleadosRQ : empresaRQ.getEmpleados()) {
                empleados.add(EmpresaMapper.empleadoRQtoEmpleado(empleadosRQ));
            }
            empresaOpt.setEmpleados(empleados);
            return this.empresaRepository.save(empresaOpt);
        }
    }
}
