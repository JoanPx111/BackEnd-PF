package com.uptc.entrenamiento.controllers;

import com.sun.istack.NotNull;
import com.uptc.entrenamiento.controllers.utils.dto.EspecialistaDto;
import com.uptc.entrenamiento.controllers.utils.mappers.MapStructMapper;
import com.uptc.entrenamiento.errors.BadRequestException;
import com.uptc.entrenamiento.models.Especialista;
import com.uptc.entrenamiento.services.IEspecialistaService;
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
@RequestMapping("/especialista")
public class EspecialistaController {
    @Autowired
    private IEspecialistaService iEspecialistaService;
    @Autowired
    private MapStructMapper mapStructMapper;

    @GetMapping("/all")
    public ResponseEntity<Iterable<EspecialistaDto>> findByAll() {
        return ResponseEntity.status(HttpStatus.OK).body(mapStructMapper.especialistaDtos(this.iEspecialistaService.findByAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspecialistaDto> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(mapStructMapper.especialistaDto(this.iEspecialistaService.findById(id).get()));
    }

    @GetMapping
    public ResponseEntity<PageResponse<EspecialistaDto>> findByAllPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        if (page < 0 || size <= 0) {
            return ResponseEntity.status(HttpStatus.OK).body(getPageResponse(this.iEspecialistaService.findByAllPage(0, 10)));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(getPageResponse(this.iEspecialistaService.findByAllPage(page, size)));
        }
    }

    @PostMapping
    public ResponseEntity<EspecialistaDto> save(@RequestBody Especialista especialista) {
        if (especialista == null) {
            throw new BadRequestException(ErrorDescription.BAD_REQUEST_ERROR_MODEL);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(mapStructMapper.especialistaDto(this.iEspecialistaService.save(especialista)));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EspecialistaDto> update(@RequestBody Especialista especialista) {
        if (especialista == null) {
            throw new BadRequestException(ErrorDescription.BAD_REQUEST_ERROR_MODEL);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(mapStructMapper.especialistaDto(this.iEspecialistaService.save(especialista)));
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
    private PageResponse<EspecialistaDto> getPageResponse(PageResponse<Especialista> pageAct) {
        PageResponse<EspecialistaDto> response = new PageResponse<>();
        response.setList((List<EspecialistaDto>) mapStructMapper.especialistaDtos(pageAct.getList()));
        response.setTotalPagina(pageAct.getTotalPagina());
        response.setTotal(pageAct.getTotal());
        response.setTotalPagina(pageAct.getTotalPagina());
        return response;
    }
}
