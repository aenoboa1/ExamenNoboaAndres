package ec.edu.espe.examen.repository;
import ec.edu.espe.examen.model.Empresa;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EmpresaRepository extends MongoRepository<Empresa, String> {

    Optional<Empresa> findByRuc(String ruc);
}