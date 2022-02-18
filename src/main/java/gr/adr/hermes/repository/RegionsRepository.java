package gr.adr.hermes.repository;

import gr.adr.hermes.domain.Regions;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Regions entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RegionsRepository extends JpaRepository<Regions, Long>, JpaSpecificationExecutor<Regions> {}
