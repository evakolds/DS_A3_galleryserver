package services.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import services.models.Employee;

@Repository
public interface GalleryRepository extends CrudRepository<Employee, String> {
}
