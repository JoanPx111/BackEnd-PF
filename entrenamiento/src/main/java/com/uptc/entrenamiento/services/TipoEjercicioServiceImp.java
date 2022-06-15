package com.uptc.entrenamiento.services;

import com.uptc.entrenamiento.errors.NotFoundException;
import com.uptc.entrenamiento.models.TipoEjercicio;
import com.uptc.entrenamiento.repositories.TipoEjercicioRepository;
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

public class TipoEjercicioServiceImp implements ITipoEjercicioService {
    @Autowired
    private TipoEjercicioRepository repository;

    @Override
    public Iterable<TipoEjercicio> findByAll() {
        return repository.findAll();
    }

    @Override
    public Optional<TipoEjercicio> findById(Long id) {
        Optional<TipoEjercicio> oApp = repository.findById(id);
        if (oApp.isPresent()) {
            return oApp;
        } else {
            throw new NotFoundException(ErrorDescription.NOT_FOUND_REGISTER_TIPO_EJERCICIO);
        }
    }

    @Override
    @Transactional
    public TipoEjercicio save(TipoEjercicio tipoEjercicio) {
        return repository.save(tipoEjercicio);
    }

    @Override
    @Transactional
    public TipoEjercicio update(TipoEjercicio ejercicio) {
        Optional<TipoEjercicio> oApp = findById(ejercicio.getIdTipoEjercicio());
        if (oApp.isPresent()) {
            oApp.get().setDscTipoEjercicio(ejercicio.getDscTipoEjercicio());
            return repository.save(ejercicio);
        } else {
            throw new NotFoundException(ErrorDescription.NOT_FOUND_REGISTER_TIPO_EJERCICIO);
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Optional<TipoEjercicio> oApp = findById(id);
        if (oApp.isPresent()) {
            repository.delete(oApp.get());
        }
    }

    @Override
    public PageResponse findByAllPage(int page, int size) {
        Page<TipoEjercicio> pageTuts = repository.findAll(PageRequest.of(page, size, Sort.by(getOrders())));
        PageResponse<TipoEjercicio> pageResponse = new PageResponse<>();
        pageResponse.setList(pageTuts.getContent());
        pageResponse.setPaginaActual(pageTuts.getNumber());
        pageResponse.setTotal(pageTuts.getTotalElements());
        pageResponse.setTotalPagina(pageTuts.getTotalPages());
        return pageResponse;
    }

    private List<Sort.Order> getOrders() {
        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.ASC, "idTipoEjercicio"));
        return orders;
    }
}
