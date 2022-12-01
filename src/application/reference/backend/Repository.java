package application.reference.backend;

import java.util.ArrayList;
import java.util.List;

public class Repository {
	List<PersonaEntity> personas;
	public static int SEQUENCE = 1;

	public Repository() {
		personas = new ArrayList<>();
		create(new PersonaEntity("Juan", "Iglesias", 16.5f, "312-122-7590"));
		create(new PersonaEntity("Maria", "Ruiz", 1563.5f, "312-122-7590"));
		create(new PersonaEntity("Pedro", "Kardashian", 152885.5f, "312-122-7590"));
	}

	public PersonaEntity[] list() {
		return personas.toArray(new PersonaEntity[personas.size()]);
	}

	public PersonaEntity detail(int id) {
		for (PersonaEntity persona : personas) {
			if (persona.getId() == id)
				return persona;
		}

		return null;
	}

	public void create(PersonaEntity persona) {

//		if (detail(persona.getId()) != null)
//			throw new RuntimeException(String.format("Persona ya existe [%s] ", persona.getId()));
		persona.setId(SEQUENCE++);
		personas.add(persona);

	}

	public void delete(PersonaEntity persona) {
		Integer index = null;
		for (int i = 0; i < personas.size(); i++) {
			PersonaEntity personaEntity = personas.get(i);
			if (personaEntity.getId() == persona.getId()) {
				index = i;
				break;
			}
		}

		if (index == null)
			throw new RuntimeException(String.format("Persona no existe [%s] ", persona.getId()));

		personas.remove((int) index);

	}

}
