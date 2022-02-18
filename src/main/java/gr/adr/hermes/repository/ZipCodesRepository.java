package gr.adr.hermes.repository;

import gr.adr.hermes.domain.ZipCodes;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the ZipCodes entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ZipCodesRepository extends JpaRepository<ZipCodes, Long>, JpaSpecificationExecutor<ZipCodes> {}
