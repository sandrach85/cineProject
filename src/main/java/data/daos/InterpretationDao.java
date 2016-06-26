package data.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import data.entities.Interpretation;

public interface InterpretationDao extends JpaRepository<Interpretation, Integer> {

}
