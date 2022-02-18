package gr.adr.hermes.repository;

import gr.adr.hermes.domain.CitizensRelations;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the CitizensRelations entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CitizensRelationsRepository extends JpaRepository<CitizensRelations, Long>, JpaSpecificationExecutor<CitizensRelations> {}
