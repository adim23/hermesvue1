package gr.adr.hermes.repository;

import gr.adr.hermes.domain.PhoneTypes;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the PhoneTypes entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PhoneTypesRepository extends JpaRepository<PhoneTypes, Long>, JpaSpecificationExecutor<PhoneTypes> {}
