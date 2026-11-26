package pe.edu.ulasalle.demospringdb;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerLibro {

    private final ServiceLibro service;

    public ControllerLibro(ServiceLibro service) {
        this.service = service;
    }

    @GetMapping("/libros")
    public List<Libro> consultarLibros() {
        return service.consultarTodos();
    }

    @PostMapping(path = "/libro/nuevo", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Libro registrarLibro(@RequestBody NuevoLibro nuevo) {
        return service.registrar(new Libro(nuevo.titulo(), nuevo.autor(), nuevo.isbn()));
    }

    public record NuevoLibro(String titulo, String autor, String isbn) {
    }
}
