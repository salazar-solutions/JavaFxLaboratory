package application.reference;

import application.reference.backend.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class PantallaController {
private static final String[] BTN_MUTAR_MESSAGES=new String[]{"Modificar","Agregar"};
	
	private @FXML Label lblAction;
	private @FXML TextField txtId;
	private @FXML TextField txtNombre;
	private @FXML TextField txtApellido;
	private @FXML TextField txtDeuda;
	private @FXML TextField txtTelefono;

	private @FXML Button btnMutar;
	private @FXML Button btnEliminar;
	private @FXML Button btnCancelar;

	private @FXML TableView<PersonaModel> tblContent;

	private Controller controller;

	private boolean createMode;

	public PantallaController() {
		this.controller = new Controller();
		createMode = true;
	}

	@FXML
	public void initialize() {
		setupTblContent();
		refreshTblContent();
		setupCreateMode();

		txtId.setEditable(false);
		btnCancelar.setOnMouseClicked(this::btnCancelarOnClicked);
		btnEliminar.setOnMouseClicked(this::btnEliminarOnClicked);
		btnMutar.setOnMouseClicked(this::btnMutarOnClicked);
		tblContent.setOnMouseClicked(this::tblContentOnClicked);
		
	}
	
	public void tblContentOnClicked(MouseEvent event) {
		PersonaModel person = tblContent.getSelectionModel().getSelectedItem();
		txtId.setText(String.valueOf( person.getId()));
		txtNombre.setText(person.getNombre());
		txtApellido.setText(person.getApellido());
		txtDeuda.setText(String.valueOf( person.getDeuda()));
		txtTelefono.setText(person.getTelefono());
		setupEditMode();
	}

	public void btnMutarOnClicked(MouseEvent event) {
		PersonaModel persona = new PersonaModel();
		persona.setNombre(txtNombre.getText());
		persona.setApellido(txtApellido.getText());
		persona.setDeuda(Float.parseFloat(txtDeuda.getText()));
		persona.setTelefono(txtTelefono.getText());
		if (createMode) {
			controller.post(persona);
		} else {
			persona.setId(Integer.parseInt(txtId.getText()));
			controller.update(persona);
		}
		refreshTblContent();
		btnCancelarOnClicked(event);
	}

	public void btnEliminarOnClicked(MouseEvent event) {
		controller.delete(Integer.parseInt(txtId.getText()));
		refreshTblContent();
		btnCancelarOnClicked(event);
	}

	public void btnCancelarOnClicked(MouseEvent event) {
		setupCreateMode();
		
		txtId.clear();
		txtNombre.clear();
		txtApellido.clear();
		txtDeuda.clear();
		txtTelefono.clear();
	}

	private void setupEditMode() {
		createMode = false;
		btnMutar.setText(BTN_MUTAR_MESSAGES[0]);
		btnEliminar.setDisable(false);
	}
	
	private void setupCreateMode() {
		createMode = true;
		btnMutar.setText(BTN_MUTAR_MESSAGES[1]);
		btnEliminar.setDisable(true);
	}
	
	private void refreshTblContent() {
		PersonaModel[] personas = controller.get();
		if (personas.length == 0) {
			tblContent.setPlaceholder(new Label("No hay registros disponibles"));
			return;
		}
		ObservableList<PersonaModel> teamMembers = FXCollections.observableArrayList(personas);
		tblContent.setItems(teamMembers);
	}

	private void setupTblContent() {
		tblContent.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

		TableColumn<PersonaModel, String> idCol = new TableColumn<>("N° de Cliente");
		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		tblContent.getColumns().add(idCol);

		TableColumn<PersonaModel, String> firstNameCol = new TableColumn<>("Nombre");
		firstNameCol.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		tblContent.getColumns().add(firstNameCol);

		TableColumn<PersonaModel, String> lastNameCol = new TableColumn<>("Apellido");
		lastNameCol.setCellValueFactory(new PropertyValueFactory<>("apellido"));
		tblContent.getColumns().add(lastNameCol);

		TableColumn<PersonaModel, Float> debtCol = new TableColumn<>("Adeudo");
		debtCol.setCellValueFactory(new PropertyValueFactory<>("deuda"));
		tblContent.getColumns().add(debtCol);

		TableColumn<PersonaModel, String> phoneCol = new TableColumn<>("Contacto");
		phoneCol.setCellValueFactory(new PropertyValueFactory<>("telefono"));
		tblContent.getColumns().add(phoneCol);
	}

}
