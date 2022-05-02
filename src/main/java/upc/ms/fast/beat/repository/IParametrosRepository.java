package upc.ms.fast.beat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.ms.fast.beat.entity.Parametros;

@Repository
public interface IParametrosRepository extends JpaRepository<Parametros,Integer> {
}
