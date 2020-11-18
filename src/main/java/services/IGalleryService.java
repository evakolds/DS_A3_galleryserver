package services;

import javassist.NotFoundException;
import services.models.Employee;

import java.util.List;

public interface IGalleryService {
    List<Employee> findAll();

    Employee save(Employee employeeForSave);

    Employee getById(String id) throws NotFoundException;

    void deleteById(String id) throws NotFoundException;
}

