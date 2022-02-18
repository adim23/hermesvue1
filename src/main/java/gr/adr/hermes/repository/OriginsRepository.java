package gr.adr.hermes.repository;

import gr.adr.hermes.domain.Origins;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Origins entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OriginsRepository extends JpaRepository<Origins, Long>, JpaSpecificationExecutor<Origins> {}
