package data.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import data.entities.ThemeUsed;;

public interface ThemeUsedDao extends JpaRepository<ThemeUsed, Integer> {
}
