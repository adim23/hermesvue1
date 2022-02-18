package gr.adr.hermes.repository;

import gr.adr.hermes.domain.ContactTypes;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the ContactTypes entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ContactTypesRepository extends JpaRepository<ContactTypes, Long>, JpaSpecificationExecutor<ContactTypes> {}
