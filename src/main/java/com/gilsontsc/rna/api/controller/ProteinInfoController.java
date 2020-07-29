package com.gilsontsc.rna.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gilsontsc.rna.api.controller.exception.ObjectNotFoundException;
import com.gilsontsc.rna.api.entity.ProteinInfo;
import com.gilsontsc.rna.api.entity.dto.ProteinInfoDTO;
import com.gilsontsc.rna.api.services.ProteinInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Proteinas Endpoint", description = "Controler das informações das proteínas", tags = {"ProteinaEndpoint"})
@RestController
@RequestMapping(value="/api/protein")
public class ProteinInfoController {

	@Autowired
	private ProteinInfoService service;
	
	@ApiOperation(value = "Buscar Proteína pelo Id")
	@GetMapping(value = "/{id}")
	public ProteinInfoDTO buscarPorId(@PathVariable String id) {
		return this.service.buscarPorId(id)
				   .map(protein -> {
					   return this.service.convertEntityToDto(protein);
				   })
				   .orElseThrow(() -> new ObjectNotFoundException(
							"Proteína não encontrada! Id: " + id + ", Tipo: " + ProteinInfo.class.getName()));
	}
	
	@ApiOperation(value = "Lista todos as proteínas")
	@GetMapping
	public ResponseEntity<Page<ProteinInfoDTO>> obterTodos(
									  @RequestParam(value="limit", defaultValue = "10") int limit,
									  @RequestParam(value="offset", defaultValue = "0") int offset) {
		Pageable pageable = PageRequest.of(offset, limit, Sort.by(Direction.ASC, "proteinAccession"));
		
		Page<ProteinInfoDTO> listProteinDTO = this.service
										.buscarTodos(pageable)
										.map(protein -> this.service.convertEntityToDto(protein));
		return ResponseEntity.ok().body(listProteinDTO);
	}
	
}