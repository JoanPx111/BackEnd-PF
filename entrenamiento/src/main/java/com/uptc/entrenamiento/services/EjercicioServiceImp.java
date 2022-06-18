package com.uptc.entrenamiento.services;

import com.uptc.entrenamiento.errors.NotFoundException;
import com.uptc.entrenamiento.models.Ejercicio;
import com.uptc.entrenamiento.repositories.EjercicioRepository;
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
public class EjercicioServiceImp implements IEjercicioService {
    @Autowired
    private EjercicioRepository repository;
    @Autowired
    private ITipoEjercicioService iTipoEjercicioService;

    @Override
    public Iterable<Ejercicio> findByAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Ejercicio> findById(Long id) {
        Optional<Ejercicio> oApp = repository.findById(id);
        if (oApp.isPresent()) {
            return oApp;
        } else {
            throw new NotFoundException(ErrorDescription.NOT_FOUND_REGISTER_EJERCICIO);
        }
    }

    @Override
    @Transactional
    public Ejercicio save(Ejercicio ejercicio) {
        iTipoEjercicioService.findById(ejercicio.getTipoEjercicio().getIdTipoEjercicio()).ifPresent(ejercicio::setTipoEjercicio);
        return repository.save(ejercicio);
    }

    @Override
    @Transactional
    public Ejercicio update(Ejercicio ejercicio) {
        Optional<Ejercicio> oApp = findById(ejercicio.getIdEjercicio());
        if (oApp.isPresent()) {
            oApp.get().setDscEjercicio(ejercicio.getDscEjercicio());
            oApp.get().setNombreEjercicio(ejercicio.getNombreEjercicio());
            iTipoEjercicioService.findById(ejercicio.getTipoEjercicio().getIdTipoEjercicio()).ifPresent(oApp.get()::setTipoEjercicio);
            return repository.save(ejercicio);
        } else {
            throw new NotFoundException(ErrorDescription.NOT_FOUND_REGISTER_EJERCICIO);
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Optional<Ejercicio> oApp = findById(id);
        if (oApp.isPresent()) {
            repository.delete(oApp.get());
        }
    }

    @Override
    public Iterable<Ejercicio> buscarPorNombre2(String nombreEjercicio) {
        return repository.buscarPorNombre2(nombreEjercicio);
    }

    @Override
    public PageResponse findByAllPage(int page, int size) {
        Page<Ejercicio> pageTuts = repository.findAll(PageRequest.of(page, size, Sort.by(getOrders())));
        PageResponse<Ejercicio> pageResponse = new PageResponse<>();
        pageResponse.setList(pageTuts.getContent());
        pageResponse.setPaginaActual(pageTuts.getNumber());
        pageResponse.setTotal(pageTuts.getTotalElements());
        pageResponse.setTotalPagina(pageTuts.getTotalPages());
        return pageResponse;
    }

    private List<Sort.Order> getOrders() {
        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.ASC, "idEjercicio"));
        return orders;
    }
}
