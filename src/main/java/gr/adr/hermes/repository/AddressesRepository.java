package gr.adr.hermes.repository;

import gr.adr.hermes.domain.Addresses;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Addresses entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AddressesRepository extends JpaRepository<Addresses, Long>, JpaSpecificationExecutor<Addresses> {}
