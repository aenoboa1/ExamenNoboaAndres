package ec.edu.espe.examen.repository;

import ec.edu.espe.examen.model.PagoRol;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface PagoRolRepository extends MongoRepository<PagoRol, String> {
    Optional<PagoRol> findByMesAndRucEmpresa(String mes, String rucEmpresa);

}