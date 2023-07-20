package ec.edu.espe.examen.controller;

import ec.edu.espe.examen.controller.dto.PagoRolRQ;
import ec.edu.espe.examen.service.PagoRolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/empresa")
public class PagoRolController{

    private final PagoRolService pagoRolService;


    public PagoRolController(PagoRolService pagoRolService) {
        this.pagoRolService = pagoRolService;
    }

    @PostMapping
    public ResponseEntity registrarPagoRolMensual(@RequestBody PagoRolRQ pagoRolRQ) {
        try {
            this.pagoRolService.createPagoRolMensual(pagoRolRQ);
            return ResponseEntity.ok().build();
        } catch (RuntimeException rte) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping({"{rucEmpresa}/{mes}"})
    public ResponseEntity validarPagoRolMensual(
            String rucEmpresa,
            String mes) {
        try {
            this.pagoRolService.validatePagoRol(mes, rucEmpresa);
            return ResponseEntity.ok().build();
        } catch (RuntimeException rte) {
            return ResponseEntity.badRequest().build();
        }
    }
}
