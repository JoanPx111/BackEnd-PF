package com.uptc.entrenamiento.controllers;

import com.sun.istack.NotNull;
import com.uptc.entrenamiento.errors.BadRequestException;
import com.uptc.entrenamiento.models.TipoEjercicio;
import com.uptc.entrenamiento.services.ITipoEjercicioService;
import com.uptc.entrenamiento.utils.ErrorDescription;
import com.uptc.entrenamiento.utils.PageResponse;
import com.uptc.entrenamiento.utils.ResponseDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"})
@RestController
@RequestMapping("/tipo-ejercicio")
public class TipoEjercicioController {
    @Autowired
    private ITipoEjercicioService iTipoEjercicioService;

    @GetMapping("/all")
    public ResponseEntity<Iterable<TipoEjercicio>> findByAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.iTipoEjercicioService.findByAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoEjercicio> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.iTipoEjercicioService.findById(id).get());
    }

    @GetMapping
    public ResponseEntity<PageResponse<TipoEjercicio>> findByAllPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        if (page < 0 || size <= 0) {
            return ResponseEntity.status(HttpStatus.OK).body(getPageResponse(this.iTipoEjercicioService.findByAllPage(0, 10)));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(getPageResponse(this.iTipoEjercicioService.findByAllPage(page, size)));
        }
    }

    @PostMapping
    public ResponseEntity<TipoEjercicio> save(@RequestBody TipoEjercicio tipoEjercicio) {
        if (tipoEjercicio == null) {
            throw new BadRequestException(ErrorDescription.BAD_REQUEST_ERROR_MODEL);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body((this.iTipoEjercicioService.save(tipoEjercicio)));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoEjercicio> update(@RequestBody TipoEjercicio tipoEjercicio) {
        if (tipoEjercicio == null) {
            throw new BadRequestException(ErrorDescription.BAD_REQUEST_ERROR_MODEL);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(this.iTipoEjercicioService.save(tipoEjercicio));
        }
    }

    @PutMapping("/remover/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id, @RequestBody TipoEjercicio tipoEjercicio) {
        if (id == null) {
            throw new BadRequestException(ErrorDescription.BAD_REQUEST_ERROR_MODEL);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(ResponseDescription.REMOVE);
        }
    }

    @NotNull
    private PageResponse<TipoEjercicio> getPageResponse(PageResponse<TipoEjercicio> pageAct) {
        PageResponse<TipoEjercicio> response = new PageResponse<>();
        response.setList(pageAct.getList());
        response.setTotalPagina(pageAct.getTotalPagina());
        response.setTotal(pageAct.getTotal());
        response.setTotalPagina(pageAct.getTotalPagina());
        return response;
    }
}
