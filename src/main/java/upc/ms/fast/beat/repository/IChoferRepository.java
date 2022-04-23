package upc.ms.fast.beat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.ms.fast.beat.entity.Chofer;


@Repository
public interface IChoferRepository extends JpaRepository<Chofer, Integer> {

}
