package backend.solutionRecouvrement.repositories;

import backend.solutionRecouvrement.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByObligoreIdAndReportingDate(String obligoreId, String reportingDate);

    @Query(
            value = "select * from client  , engagement where engagement.id_client = client.id and to_char(client.reporting_date,'yyyy-MM-dd')=:daterepo",
            nativeQuery = true
    )
    List<Client> findByDateReporting(@Param("daterepo") String daterepo);

    @Query(
            value = "select client.reporting_date from client where  EXTRACT(YEAR from client.reporting_date ) = :year group by client.reporting_date",
            nativeQuery = true
    )
    List<String> findByReportingDate(@Param("year") Integer reportingDate);
}

