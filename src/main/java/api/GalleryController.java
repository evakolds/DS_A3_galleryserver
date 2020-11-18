package api;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.IGalleryService;
import services.models.Employee;
import gallery.galleryserver.GalleryServerApplication;

import java.util.List;

@RestController
@RequestMapping("api/clients")
@RequiredArgsConstructor
public final class GalleryController {
    static final Logger log = LoggerFactory.getLogger(GalleryServerApplication.class);

    @Autowired
    private IGalleryService galleryService;

    @GetMapping
    public ResponseEntity<List<Employee>> index() {
        return ResponseEntity.ok(galleryService.findAll());
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody GalleryPayload payload) {
        Employee newEmployee = new Employee(payload.getName());
        return ResponseEntity.ok(galleryService.save(newEmployee));
    }


    @GetMapping("{employeeId}")
    public ResponseEntity<Employee> show(@PathVariable String employeeId) throws NotFoundException {
        return ResponseEntity.ok(galleryService.getById(employeeId));
    }

    @DeleteMapping("{employeeId}")
    public ResponseEntity<Void> delete(@PathVariable String employeeId) throws NotFoundException {
        galleryService.deleteById(employeeId);
        return ResponseEntity.noContent().build();
    }
}