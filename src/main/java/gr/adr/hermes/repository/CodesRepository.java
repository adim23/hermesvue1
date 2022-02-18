package gr.adr.hermes.repository;

import gr.adr.hermes.domain.Codes;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Codes entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CodesRepository extends JpaRepository<Codes, Long>, JpaSpecificationExecutor<Codes> {}
