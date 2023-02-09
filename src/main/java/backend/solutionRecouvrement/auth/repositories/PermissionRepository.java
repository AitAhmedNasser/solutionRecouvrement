package backend.solutionRecouvrement.auth.repositories;

import backend.solutionRecouvrement.auth.entities.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PermissionRepository extends JpaRepository<Permissions, Long> {
    Permissions getPermissionById(Long id_Permissions);

    @Query(
            value = "SELECT * FROM permissions per WHERE per.privileges_id=?1 AND per.ressources_id=?2",
            nativeQuery = true
    )
    List<Permissions> permissionWhereId(Long id_Privileges, Long id_Ressource);

    @Query(
            value = "@Query(value = \"SELECT * FROM permissions per WHERE per.privileges_id=?1 AND per.ressources_id=?2\",nativeQuery = true ",
            nativeQuery = true
    )
    List<Permissions> roleHasNotPermissions(long id_Role);
}
