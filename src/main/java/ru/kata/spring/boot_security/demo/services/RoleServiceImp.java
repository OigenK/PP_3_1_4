package ru.kata.spring.boot_security.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import java.util.List;

@Service
public class RoleServiceImp implements RoleService{

    private final RoleRepository repository;

    public RoleServiceImp(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> getAllRoles() {
        return repository.findAll();
    }

    @Override
    public void addRole(Role role) {
        repository.save(role);
    }
}
