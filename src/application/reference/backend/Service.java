package application.reference.backend;

import application.reference.PersonaModel;

public class Service {
	private Repository repository;
	private PersonaTransformer personaTransformer;

	public Service(Repository repository, PersonaTransformer personaTransformer) {
		this.repository = repository;
		this.personaTransformer = personaTransformer;
	}

	public PersonaModel[] list() {
		return personaTransformer.transform(repository.list());
	}

	public PersonaModel detail(int id) {
		PersonaEntity persona = repository.detail(id);
		return personaTransformer.transform(persona);
	}

	public void create(PersonaModel persona) {
		repository.create(personaTransformer.transform(persona));
	}

	public void update(PersonaModel persona) {
		PersonaEntity personaEntity=repository.detail(persona.getId());
		personaEntity.setNombre(persona.getNombre());
		personaEntity.setApellido(persona.getApellido());
		personaEntity.setDeuda(persona.getDeuda());
		personaEntity.setTelefono(persona.getTelefono());
	}

	public void delete(int id) {
		PersonaEntity persona=repository.detail(id);
		repository.delete(persona);
	}


}
