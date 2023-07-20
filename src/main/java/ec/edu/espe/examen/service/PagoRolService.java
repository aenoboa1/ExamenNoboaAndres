package ec.edu.espe.examen.service;

import ec.edu.espe.examen.controller.dto.PagoRolRQ;
import ec.edu.espe.examen.model.Empleado;
import ec.edu.espe.examen.model.EmpleadoPago;
import ec.edu.espe.examen.model.Empresa;
import ec.edu.espe.examen.model.PagoRol;
import ec.edu.espe.examen.repository.EmpresaRepository;
import ec.edu.espe.examen.repository.PagoRolRepository;
import ec.edu.espe.examen.service.mapper.PagoRolMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class PagoRolService {
    private final PagoRolRepository pagoRolRepository;
    private final EmpresaRepository empresaRepository;


    public PagoRolService(PagoRolRepository pagoRolRepository, EmpresaRepository empresaRepository) {
        this.pagoRolRepository = pagoRolRepository;
        this.empresaRepository = empresaRepository;
    }

    public void validatePagoRol(String mes, String rucEmpresa) {
        Optional<Empresa> empresa = this.empresaRepository.findByRuc(rucEmpresa);
        if (empresa.isPresent()) {
            for (Empleado empleados : empresa.get().getEmpleados()) {

            }
        }
    }
    public void createPagoRolMensual(PagoRolRQ pagoRolRQ) {
        PagoRol pagoRol = PagoRolMapper.PagoRolRQtoPagoRol(pagoRolRQ);
        Optional<PagoRol> pagoRolOpt = this.pagoRolRepository.findByMesAndRucEmpresa(pagoRol.getMes(), pagoRol.getRucEmpresa());
        if (pagoRolOpt.isPresent()) {
            BigDecimal sum = BigDecimal.ZERO;
            for (EmpleadoPago empleadosPago : pagoRol.getEmpleadosPago()) {
                empleadosPago.setEstado("PEN");
                sum = sum.add(empleadosPago.getValor());
            }
            pagoRol.setValorTotal(sum);
            pagoRol.setValorReal(BigDecimal.ZERO);
            this.pagoRolRepository.save(pagoRol);
        } else {
            throw new RuntimeException("Ya existe un pago rol para el mes y empresa");
        }
    }
}
