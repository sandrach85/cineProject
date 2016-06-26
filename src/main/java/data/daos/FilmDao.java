package data.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import data.entities.Film;

public interface FilmDao extends JpaRepository<Film, Integer> {

}
