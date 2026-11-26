package pe.edu.ulasalle.demospringdb;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ServiceLibro {

    private final RepositoryLibro repository;

    public ServiceLibro(RepositoryLibro repository) {
        this.repository = repository;
    }

    public List<Libro> consultarTodos() {
        return repository.findAll();
    }

    public Libro registrar(Libro nuevo) {
        return repository.save(nuevo);
    }
}
