package com.asantos.dslearn.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asantos.dslearn.dto.DeliverRevisionDTO;
import com.asantos.dslearn.services.DeliverService;

@RestController
@RequestMapping(value = "/deliveries")
public class DeliverResource {

	@Autowired
	private DeliverService deliverService;

	/**
	 * Atualiza a entrega após a revisão/correção não há retorno, apenas update do
	 * status, questões acertadas e feedback Apenas usuários ADMIN ou INSTRUCTORS
	 * podem salvar, STUDENT não Pode ser mantido na camada de Resource ou na Camada
	 * de Serviçe na camada de Resource já evita processar possíveis validações, mas
	 * na camada de Services já estão presentes outras lógicas de autorizações e
	 * acumulam as regras de negócio
	 * 
	 * @param id
	 * @param deliverRevisionDto
	 * @return noContent
	 * 
	 *@PreAuthorize("hasAnyRole('ADMIN', 'INSTRUCTOR')")
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> saveDeliverRevision(@PathVariable Long id,
			@RequestBody DeliverRevisionDTO deliverRevisionDto) {
		deliverService.saveRevision(id, deliverRevisionDto);
		return ResponseEntity.noContent().build();
	}
}
