package com.uptc.entrenamiento.controllers;

import com.sun.istack.NotNull;
import com.uptc.entrenamiento.controllers.utils.dto.TipoEjercicioDto;
import com.uptc.entrenamiento.controllers.utils.mappers.MapStructMapper;
import com.uptc.entrenamiento.errors.BadRequestException;
import com.uptc.entrenamiento.models.TipoEjercicio;
import com.uptc.entrenamiento.services.ITipoEjercicioService;
import com.uptc.entrenamiento.utils.ErrorDescription;
import com.uptc.entrenamiento.utils.PageResponse;
import com.uptc.entrenamiento.utils.ResponseDescription;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"})
@RestController
@RequestMapping("/tipo-ejercicio")
@Api(value = "Servicio tipos de ejercicio", description = "Servicio tipos de ejercicio")
public class TipoEjercicioController {
    @Autowired
    private ITipoEjercicioService iTipoEjercicioService;
    @Autowired
    private MapStructMapper mapStructMapper;

    @GetMapping("/all")
    public ResponseEntity<Iterable<TipoEjercicioDto>> findByAll() {
        return ResponseEntity.status(HttpStatus.OK).body(mapStructMapper.tipoEjercicioDtos(this.iTipoEjercicioService.findByAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoEjercicioDto> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(mapStructMapper.tipoEjercicioDto(this.iTipoEjercicioService.findById(id).get()));
    }

    @GetMapping
    public ResponseEntity<PageResponse<TipoEjercicioDto>> findByAllPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        if (page < 0 || size <= 0) {
            return ResponseEntity.status(HttpStatus.OK).body(getPageResponse(this.iTipoEjercicioService.findByAllPage(0, 10)));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(getPageResponse(this.iTipoEjercicioService.findByAllPage(page, size)));
        }
    }

    @PostMapping
    public ResponseEntity<TipoEjercicioDto> save(@RequestBody TipoEjercicio tipoEjercicio) {
        if (tipoEjercicio == null) {
            throw new BadRequestException(ErrorDescription.BAD_REQUEST_ERROR_MODEL);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(mapStructMapper.tipoEjercicioDto(this.iTipoEjercicioService.save(tipoEjercicio)));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoEjercicioDto> update(@RequestBody TipoEjercicio tipoEjercicio) {
        if (tipoEjercicio == null) {
            throw new BadRequestException(ErrorDescription.BAD_REQUEST_ERROR_MODEL);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(mapStructMapper.tipoEjercicioDto(this.iTipoEjercicioService.save(tipoEjercicio)));
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
    private PageResponse<TipoEjercicioDto> getPageResponse(PageResponse<TipoEjercicio> pageAct) {
        PageResponse<TipoEjercicioDto> response = new PageResponse<>();
        response.setList((List<TipoEjercicioDto>) mapStructMapper.tipoEjercicioDtos(pageAct.getList()));
        response.setTotalPagina(pageAct.getTotalPagina());
        response.setTotal(pageAct.getTotal());
        response.setTotalPagina(pageAct.getTotalPagina());
        return response;
    }
}
