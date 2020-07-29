package com.gilsontsc.rna.api.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProteinInfoDTO {

	@NotNull
	private String proteinAccession;
	
	private String description;
	
	private String label;
	
	private String synonyms;
	
}