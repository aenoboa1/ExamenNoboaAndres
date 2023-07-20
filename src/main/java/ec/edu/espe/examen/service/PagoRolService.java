package ec.edu.espe.examen.service;

import ec.edu.espe.examen.controller.dto.PagoRolRQ;
import ec.edu.espe.examen.model.Empleado;
import ec.edu.espe.examen.model.EmpleadosPago;
import ec.edu.espe.examen.model.Empresa;
import ec.edu.espe.examen.model.PagoRol;
import ec.edu.espe.examen.repository.EmpresaRepository;
import ec.edu.espe.examen.repository.PagoRolRepository;
import ec.edu.espe.examen.service.mapper.EmpresaMapper;
import ec.edu.espe.examen.service.mapper.PagorRolMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PagoRolService {
    // implement a service
    private final PagoRolRepository pagoRolRepository;
    private final EmpresaRepository empresaRepository;


    public PagoRolService(PagoRolRepository pagoRolRepository, EmpresaRepository empresaRepository) {
        this.pagoRolRepository = pagoRolRepository;
        this.empresaRepository = empresaRepository;
    }
    // implement a service that receives a pagorol
    public void validatePagoRol(String mes, String rucEmpresa){
        Optional<Empresa> empresa = this.empresaRepository.findByRuc(rucEmpresa);
        // iterate over empleados List in empresa
        if(empresa.isPresent()){

        }
    }
    public void createPagoRolMensual(PagoRolRQ pagoRolRQ) {
        // transform to pagoRol
        PagoRol pagoRol = PagorRolMapper.transformPagoRol(pagoRolRQ);
        Optional<PagoRol> pagoRolOpt = this.pagoRolRepository.findByMesAndRucEmpresa(pagoRol.getMes(), pagoRol.getRucEmpresa());
        if(pagoRolOpt.isPresent())
        {
            for (EmpleadosPago empleados : pagoRol.getEmpleadosPago()) {
                pagoRol.setValorTotal(empleados.getValor());
            }
            this.pagoRolRepository.save(pagoRol);
        }
        else {
            throw new RuntimeException("Ya existe un pago rol para el mes y empresa");
        }
    }

}
