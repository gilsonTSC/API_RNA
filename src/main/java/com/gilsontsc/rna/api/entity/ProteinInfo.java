package com.gilsontsc.rna.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "protein_info", schema = "rnacen")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProteinInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "protein_accession", columnDefinition="LONGTEXT")
	private String proteinAccession;
	
	@Column(columnDefinition="LONGTEXT")
	private String description;
	
	@Column(columnDefinition="LONGTEXT")
	private String label;
	
	@Column(columnDefinition="LONGTEXT")
	private String synonyms;
	
}