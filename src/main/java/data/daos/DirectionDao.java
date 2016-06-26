package data.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import data.entities.Direction;;

public interface DirectionDao extends JpaRepository<Direction, Integer> {

}
