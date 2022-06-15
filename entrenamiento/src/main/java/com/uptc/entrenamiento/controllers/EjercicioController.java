package com.uptc.entrenamiento.controllers;

import com.sun.istack.NotNull;
import com.uptc.entrenamiento.errors.BadRequestException;
import com.uptc.entrenamiento.models.Ejercicio;
import com.uptc.entrenamiento.services.IEjercicioService;
import com.uptc.entrenamiento.utils.ErrorDescription;
import com.uptc.entrenamiento.utils.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"})
@RestController
@RequestMapping("/ejercicio")
public class EjercicioController {
    @Autowired
    private IEjercicioService iEjercicioService;

    @GetMapping("/all")
    public ResponseEntity<Iterable<Ejercicio>> findByAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.iEjercicioService.findByAll());
    }

    @GetMapping(params = {"page", "size"})
    public ResponseEntity<PageResponse<Ejercicio>> findByAllPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        if (page < 0 || size <= 0) {
            return ResponseEntity.status(HttpStatus.OK).body(getPageResponse(this.iEjercicioService.findByAllPage(0, 10)));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(getPageResponse(this.iEjercicioService.findByAllPage(page, size)));
        }
    }

    @PostMapping
    public ResponseEntity<Ejercicio> save(@RequestBody Ejercicio ejercicio) {
        if (ejercicio == null) {
            throw new BadRequestException(ErrorDescription.BAD_REQUEST_ERROR_MODEL);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body((this.iEjercicioService.save(ejercicio)));
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Ejercicio> update(@RequestBody Ejercicio ejercicio) {
        if (ejercicio == null) {
            throw new BadRequestException(ErrorDescription.BAD_REQUEST_ERROR_MODEL);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(this.iEjercicioService.save(ejercicio));
        }
    }
    @PutMapping("/remover/{id}")
    public ResponseEntity<Ejercicio> delete(@PathVariable Long id,@RequestBody Ejercicio ejercicio) {
        if (id == null) {
            throw new BadRequestException(ErrorDescription.BAD_REQUEST_ERROR_MODEL);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body((this.iEjercicioService.delete(id)));
        }
    }

    @NotNull
    private PageResponse<Ejercicio> getPageResponse(PageResponse<Ejercicio> pageAct) {
        PageResponse<Ejercicio> response = new PageResponse<>();
        response.setList(pageAct.getList());
        response.setTotalPagina(pageAct.getTotalPagina());
        response.setTotal(pageAct.getTotal());
        response.setTotalPagina(pageAct.getTotalPagina());
        return response;
    }
}
