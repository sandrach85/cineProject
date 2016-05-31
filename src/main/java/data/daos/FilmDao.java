package data.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import data.entities.Film;

public interface FilmDao extends JpaRepository<Film, Integer> {

    Film findById(int id);
    List<Film> findAll();
}
