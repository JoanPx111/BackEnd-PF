package com.uptc.entrenamiento.services;

import com.uptc.entrenamiento.errors.NotFoundException;
import com.uptc.entrenamiento.models.Especialista;
import com.uptc.entrenamiento.repositories.EspecialistaRepository;
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
public class EspecialistaServiceImp implements IEspecialistaService {
    @Autowired
    private EspecialistaRepository repository;
    @Autowired
    private IRegistroService iRegistroService;

    @Override
    public Iterable<Especialista> findByAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Especialista> findById(Long id) {
        Optional<Especialista> oApp = repository.findById(id);
        if (oApp.isPresent()) {
            return oApp;
        } else {
            throw new NotFoundException(ErrorDescription.NOT_FOUND_REGISTER_ESPECIALISTA);
        }
    }

    @Override
    @Transactional
    public Especialista save(Especialista especialista) {
        iRegistroService.findById(especialista.getRegistro().getIdRegistro()).ifPresent(especialista::setRegistro);
        return repository.save(especialista);
    }

    @Override
    @Transactional
    public Especialista update(Especialista especialista) {
        Optional<Especialista> oApp = findById(especialista.getIdEspecialista());
        if (oApp.isPresent()) {
            oApp.get().setFechaDeNacimiento(especialista.getFechaDeNacimiento());
            oApp.get().setNombre(especialista.getNombre());
            oApp.get().setTarjetaProfesional(especialista.getTarjetaProfesional());
            oApp.get().setFechaDeNacimiento(especialista.getFechaDeNacimiento());
            iRegistroService.findById(especialista.getRegistro().getIdRegistro()).ifPresent(oApp.get()::setRegistro);
            return repository.save(oApp.get());
        } else {
            throw new NotFoundException(ErrorDescription.NOT_FOUND_REGISTER_ESPECIALISTA);
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Optional<Especialista> oApp = findById(id);
        if (oApp.isPresent()) {
            repository.delete(oApp.get());
        }
    }

    @Override
    public PageResponse findByAllPage(int page, int size) {
        Page<Especialista> pageTuts = repository.findAll(PageRequest.of(page, size, Sort.by(getOrders())));
        PageResponse<Especialista> pageResponse = new PageResponse<>();
        pageResponse.setList(pageTuts.getContent());
        pageResponse.setPaginaActual(pageTuts.getNumber());
        pageResponse.setTotal(pageTuts.getTotalElements());
        pageResponse.setTotalPagina(pageTuts.getTotalPages());
        return pageResponse;
    }

    private List<Sort.Order> getOrders() {
        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.ASC, "idEspecialista"));
        return orders;
    }
}
