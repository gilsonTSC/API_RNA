package com.gilsontsc.rna.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gilsontsc.rna.api.entity.ProteinInfo;

@Repository
public interface ProteinInfoRepository  extends JpaRepository<ProteinInfo, String>{

	Optional<ProteinInfo> findByProteinAccession(String proteinAccession);
	
}