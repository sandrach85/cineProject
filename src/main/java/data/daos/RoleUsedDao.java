package data.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import data.entities.Person;
import data.entities.Role;
import data.entities.RoleUsed;

public interface RoleUsedDao  extends JpaRepository<RoleUsed, Integer> {
	
	@Query("select roleUsed.role from RoleUsed roleUsed where roleUsed.person = ?1")
    List<Role> findRoleByPerson(Person person);

}
