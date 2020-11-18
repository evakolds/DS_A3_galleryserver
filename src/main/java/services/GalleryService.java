package services;

import services.models.Employee;
import services.repository.GalleryRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GalleryService implements IGalleryService {
    @Autowired
    private GalleryRepository repository;

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) repository.findAll();
    }

    @Override
    public Employee save(Employee employeeForSave) {
        return repository.save(employeeForSave);
    }

    @Override
    public Employee getById(String id) throws NotFoundException {
        Optional<Employee> tempEmployee = repository.findById(id);
        if (tempEmployee.isPresent())
            return repository.findById(id).get();
        else
            throw new NotFoundException(String.format("Employee with id %s does not exist", id));
    }

    @Override
    public void deleteById(String id) throws NotFoundException {
        repository.delete(getById(id));
    }
}