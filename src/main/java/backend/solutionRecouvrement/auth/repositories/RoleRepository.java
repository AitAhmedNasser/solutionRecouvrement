package backend.solutionRecouvrement.auth.repositories;

import backend.solutionRecouvrement.auth.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Map;

@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getRoleById(Long id_Roles);

    Role getRolesByName(String name);

    @Query(
            value = "SELECT * FROM roles_permissions",
            nativeQuery = true
    )
    Map<Long, Long> RolPermission();

    @Query(
            value = "SELECT * FROM roles_permissions WHERE role_id=?1 AND permissions_id=?2",
            nativeQuery = true
    )
    Map<Long, Long> roleHasPermission(Long roleId, Long permissionId);
}