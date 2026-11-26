package pe.edu.ulasalle.demospringdb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryLibro extends JpaRepository<Libro, Integer> {
}
