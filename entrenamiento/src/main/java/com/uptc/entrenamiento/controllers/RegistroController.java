package com.uptc.entrenamiento.controllers;

import com.sun.istack.NotNull;
import com.uptc.entrenamiento.controllers.utils.dto.RegistroDto;
import com.uptc.entrenamiento.controllers.utils.mappers.MapStructMapper;
import com.uptc.entrenamiento.errors.BadRequestException;
import com.uptc.entrenamiento.models.Registro;
import com.uptc.entrenamiento.services.IRegistroService;
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
@RequestMapping("/registro")
public class RegistroController {
    @Autowired
    private IRegistroService iRegistroService;
    @Autowired
    private MapStructMapper mapStructMapper;

    @GetMapping("/all")
    public ResponseEntity<Iterable<RegistroDto>> findByAll() {
        return ResponseEntity.status(HttpStatus.OK).body(mapStructMapper.registroDtos(this.iRegistroService.findByAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroDto> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(mapStructMapper.registroDto(this.iRegistroService.findById(id).get()));
    }

    @GetMapping
    public ResponseEntity<PageResponse<RegistroDto>> findByAllPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        if (page < 0 || size <= 0) {
            return ResponseEntity.status(HttpStatus.OK).body(getPageResponse(this.iRegistroService.findByAllPage(0, 10)));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(getPageResponse(this.iRegistroService.findByAllPage(page, size)));
        }
    }

    @PostMapping
    public ResponseEntity<RegistroDto> save(@RequestBody Registro registro) {
        if (registro == null) {
            throw new BadRequestException(ErrorDescription.BAD_REQUEST_ERROR_MODEL);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(mapStructMapper.registroDto(this.iRegistroService.save(registro)));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroDto> update(@RequestBody Registro registro) {
        if (registro == null) {
            throw new BadRequestException(ErrorDescription.BAD_REQUEST_ERROR_MODEL);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(mapStructMapper.registroDto(this.iRegistroService.save(registro)));
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
    private PageResponse<RegistroDto> getPageResponse(PageResponse<Registro> pageAct) {
        PageResponse<RegistroDto> response = new PageResponse<>();
        response.setList((List<RegistroDto>) mapStructMapper.registroDtos(pageAct.getList()));
        response.setTotalPagina(pageAct.getTotalPagina());
        response.setTotal(pageAct.getTotal());
        response.setTotalPagina(pageAct.getTotalPagina());
        return response;
    }
}
