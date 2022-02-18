package gr.adr.hermes.repository;

import gr.adr.hermes.domain.Emails;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Emails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EmailsRepository extends JpaRepository<Emails, Long>, JpaSpecificationExecutor<Emails> {}
