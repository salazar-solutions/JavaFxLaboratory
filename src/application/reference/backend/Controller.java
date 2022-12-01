package application.reference.backend;

import application.reference.PersonaModel;

public class Controller {
	private Service service;

	public Controller() {
		Repository repository = new Repository();
		PersonaTransformer personaTransformer = new PersonaTransformer();
		this.service = new Service(repository, personaTransformer);
	}

	public PersonaModel[] get() {
		try {
			PersonaModel[] personas = service.list();
			return personas;
		} catch (Exception e) {
			log(String.format("Ocurrio un error mientras se obtenian los registros: [%s]", e.getMessage()));
		}
		return new PersonaModel[0];
	}

	public PersonaModel get(short id) {
		try {
			PersonaModel persona = service.detail(id);
			return persona;
		} catch (Exception e) {
			log(String.format("Ocurrio un error mientras se obtenian el registro: [%s]", e.getMessage()));
		}
		return null;
	}

	public boolean post(PersonaModel persona) {
		try {
			service.create(persona);
			return true;
		} catch (Exception e) {
			log(String.format("Ocurrio un error mientras se guardaba el registro: [%s]", e.getMessage()));
		}
		return false;
	}

	public boolean update(PersonaModel persona) {
		try {
			service.update(persona);
			return true;
		} catch (Exception e) {
			log(String.format("Ocurrio un error mientras se actualizaba el registro: [%s]", e.getMessage()));
		}
		return false;
	}

	public boolean delete(int id) {
		try {
			service.delete(id);
			return true;
		} catch (Exception e) {
			log(String.format("Ocurrio un error mientras se borraba el registro: [%s]", e.getMessage()));
		}
		return false;
	}

	private void log(String message) {
		System.out.println(message);
	}

}
