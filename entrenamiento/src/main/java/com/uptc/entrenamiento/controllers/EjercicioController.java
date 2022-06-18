package com.uptc.entrenamiento.controllers;

import com.sun.istack.NotNull;
import com.uptc.entrenamiento.controllers.utils.dto.EjercicioDto;
import com.uptc.entrenamiento.controllers.utils.mappers.MapStructMapper;
import com.uptc.entrenamiento.errors.BadRequestException;
import com.uptc.entrenamiento.models.Ejercicio;
import com.uptc.entrenamiento.services.IEjercicioService;
import com.uptc.entrenamiento.utils.ErrorDescription;
import com.uptc.entrenamiento.utils.PageResponse;
import com.uptc.entrenamiento.utils.ResponseDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"})
@RestController
@RequestMapping("/ejercicio")
public class EjercicioController {
    @Autowired
    private IEjercicioService iEjercicioService;
    @Autowired
    private MapStructMapper mapStructMapper;

    @GetMapping("/all")
    public ResponseEntity<Iterable<EjercicioDto>> findByAll() {
        return ResponseEntity.status(HttpStatus.OK).body(mapStructMapper.ejercicioDtos(this.iEjercicioService.findByAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EjercicioDto> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(mapStructMapper.ejercicioDto(this.iEjercicioService.findById(id).get()));
    }

    @GetMapping
    public ResponseEntity<PageResponse<EjercicioDto>> findByAllPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        if (page < 0 || size <= 0) {
            return ResponseEntity.status(HttpStatus.OK).body(getPageResponse(this.iEjercicioService.findByAllPage(0, 10)));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(getPageResponse(this.iEjercicioService.findByAllPage(page, size)));
        }
    }

    @PostMapping
    public ResponseEntity<EjercicioDto> save(@RequestBody Ejercicio ejercicio) {
        if (ejercicio == null) {
            throw new BadRequestException(ErrorDescription.BAD_REQUEST_ERROR_MODEL);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(mapStructMapper.ejercicioDto(this.iEjercicioService.save(ejercicio)));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EjercicioDto> update(@RequestBody Ejercicio ejercicio) {
        if (ejercicio == null) {
            throw new BadRequestException(ErrorDescription.BAD_REQUEST_ERROR_MODEL);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(mapStructMapper.ejercicioDto(this.iEjercicioService.save(ejercicio)));
        }
    }

    @PutMapping("/remover/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (id == null) {
            throw new BadRequestException(ErrorDescription.BAD_REQUEST_ERROR_MODEL);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(ResponseDescription.REMOVE);
        }
    }

    @NotNull
    private PageResponse<EjercicioDto> getPageResponse(PageResponse<Ejercicio> pageAct) {
        PageResponse<EjercicioDto> response = new PageResponse<>();
        response.setList((List<EjercicioDto>) mapStructMapper.ejercicioDtos(pageAct.getList()));
        response.setTotalPagina(pageAct.getTotalPagina());
        response.setTotal(pageAct.getTotal());
        response.setTotalPagina(pageAct.getTotalPagina());
        return response;
    }

    @GetMapping("/filter/{name}")
    public ResponseEntity<Iterable<EjercicioDto>> findById(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(mapStructMapper.ejercicioDtos(this.iEjercicioService.buscarPorNombre2(name)));
    }
}
