package application.reference.backend;

import java.util.ArrayList;
import java.util.List;

import application.reference.PersonaModel;

public class PersonaTransformer {
	public PersonaModel[] transform(PersonaEntity[] personas) {
		List<PersonaModel> personaModelList = new ArrayList<>();
		for (PersonaEntity persona : personas) {
			personaModelList.add(transform(persona));
		}
		return personaModelList.toArray(new PersonaModel[personaModelList.size()]);
	}

	public PersonaEntity[] transform(PersonaModel[] personas) {
		List<PersonaEntity> personaEntityList = new ArrayList<>();
		for (PersonaModel persona : personas) {
			personaEntityList.add(transform(persona));
		}
		return personaEntityList.toArray(new PersonaEntity[personaEntityList.size()]);
	}

	public PersonaModel transform(PersonaEntity persona) {
		PersonaModel personaModel = new PersonaModel();
		personaModel.setId(persona.getId());
		personaModel.setNombre(persona.getNombre());
		personaModel.setApellido(persona.getApellido());
		personaModel.setDeuda(persona.getDeuda());
		personaModel.setTelefono(persona.getTelefono());
		return personaModel;
	}

	public PersonaEntity transform(PersonaModel persona) {
		PersonaEntity personaEntity = new PersonaEntity();
		personaEntity.setId(persona.getId());
		personaEntity.setNombre(persona.getNombre());
		personaEntity.setApellido(persona.getApellido());
		personaEntity.setDeuda(persona.getDeuda());
		personaEntity.setTelefono(persona.getTelefono());
		return personaEntity;
	}
}
