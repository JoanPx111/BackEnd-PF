package com.uptc.entrenamiento.services;

import com.uptc.entrenamiento.errors.NotFoundException;
import com.uptc.entrenamiento.models.Registro;
import com.uptc.entrenamiento.repositories.RegistroRepository;
import com.uptc.entrenamiento.utils.ErrorDescription;
import com.uptc.entrenamiento.utils.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegistroServiceImp implements IRegistroService {
    @Autowired
    private RegistroRepository repository;

    @Override
    public Iterable<Registro> findByAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Registro> findById(Long id) {
        Optional<Registro> oApp = repository.findById(id);
        if (oApp.isPresent()) {
            return oApp;
        } else {
            throw new NotFoundException(ErrorDescription.NOT_FOUND_REGISTER_REGISTRO);
        }
    }

    @Override
    @Transactional
    public Registro save(Registro registro) {
        return repository.save(registro);
    }

    @Override
    @Transactional
    public Registro update(Registro registro) {
        Optional<Registro> oApp = findById(registro.getIdRegistro());
        if (oApp.isPresent()) {
            oApp.get().setFechaRegistro(registro.getFechaRegistro());
            return repository.save(oApp.get());
        } else {
            throw new NotFoundException(ErrorDescription.NOT_FOUND_REGISTER_REGISTRO);
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Optional<Registro> oApp = findById(id);
        if (oApp.isPresent()) {
            repository.delete(oApp.get());
        }
    }

    @Override
    public PageResponse findByAllPage(int page, int size) {
        Page<Registro> pageTuts = repository.findAll(PageRequest.of(page, size, Sort.by(getOrders())));
        PageResponse<Registro> pageResponse = new PageResponse<>();
        pageResponse.setList(pageTuts.getContent());
        pageResponse.setPaginaActual(pageTuts.getNumber());
        pageResponse.setTotal(pageTuts.getTotalElements());
        pageResponse.setTotalPagina(pageTuts.getTotalPages());
        return pageResponse;
    }

    private List<Sort.Order> getOrders() {
        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.ASC, "idRegistro"));
        return orders;
    }
}
