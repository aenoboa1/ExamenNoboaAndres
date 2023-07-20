package ec.edu.espe.examen.controller;

import ec.edu.espe.examen.controller.dto.EmpresaRQ;
import ec.edu.espe.examen.service.EmpresaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/empresa")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping
    public ResponseEntity registrar(@RequestBody EmpresaRQ empresaRQ) {
        try {
            this.empresaService.createEmpresa(empresaRQ);
            return ResponseEntity.ok().build();
        } catch (RuntimeException rte) {
            return ResponseEntity.badRequest().build();
        }
    }
}
