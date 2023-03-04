package com.asantos.dslearn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asantos.dslearn.dto.DeliverRevisionDTO;
import com.asantos.dslearn.entities.Deliver;
import com.asantos.dslearn.repositories.DeliverRepository;

@Service
public class DeliverService {

	@Autowired
	private DeliverRepository deliverRepository;

	/**
	 * Atualiza as entregas após as correções dos professores Somente poderá
	 * atualizar a entrega e salvar a revisão um usuário ADMIN ou INSTRUCTOR que
	 * tem a lógica de verificação de usuário feita pela anotation @PreAutorize
	 * 
	 * @param deliverId
	 * @param deliverRevisionDTO
	 */
	@PreAuthorize("hasAnyRole('ADMIN', 'INSTRUCTOR')")
	@Transactional
	public void saveRevision(Long deliverId, DeliverRevisionDTO deliverRevisionDTO) {
		// carrega o objeto deliver
		Deliver deliver = deliverRepository.getOne(deliverId);
		// atualiza as novas informações da deliver
		deliver.setStatus(deliverRevisionDTO.getStatus());
		deliver.setFeedback(deliverRevisionDTO.getFeedback());
		deliver.setCorrectCount(deliverRevisionDTO.getCorrectCount());
		// salva o objeto atualizado após a revisão
		deliverRepository.save(deliver);
	}
}
