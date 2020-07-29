package com.gilsontsc.rna.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gilsontsc.rna.api.entity.ProteinInfo;
import com.gilsontsc.rna.api.entity.dto.ProteinInfoDTO;
import com.gilsontsc.rna.api.repository.ProteinInfoRepository;

@Service
public class ProteinInfoService {

	@Autowired
	private ProteinInfoRepository repository;
	
	public Optional<ProteinInfo> buscarPorId(String proteinAccession){
		Optional<ProteinInfo> protein = this.repository.findByProteinAccession(proteinAccession);
		return protein;
	}
	
	public Page<ProteinInfo> buscarTodos(Pageable pageable) {
		return this.repository.findAll(pageable);
	}
	
	public ProteinInfo convertDtoToEntity(ProteinInfoDTO dto) {
		return ProteinInfo.builder()
						  .proteinAccession(dto.getProteinAccession())
						  .description(dto.getDescription())
						  .label(dto.getLabel())
						  .synonyms(dto.getSynonyms())
					      .build();
	}
	
	public ProteinInfoDTO convertEntityToDto(ProteinInfo proteinInfo) {
		return ProteinInfoDTO.builder()
							 .proteinAccession(proteinInfo.getProteinAccession())
							 .description(proteinInfo.getDescription())
							 .label(proteinInfo.getLabel())
							 .synonyms(proteinInfo.getSynonyms())
						     .build();
	}
	
}