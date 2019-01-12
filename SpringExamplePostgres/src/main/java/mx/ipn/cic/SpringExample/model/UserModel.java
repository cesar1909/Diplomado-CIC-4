package mx.ipn.cic.SpringExample.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class UserModel implements Serializable {

	@Transient // Para que no cree una columna en la BD
	private static final long serialVersionUID = -353954682904818696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nombre")
	@NotNull(message = "El Campo 'Nombre' no puede ser nulo")
	@Size(min = 1, max = 15, message = "El Campo 'Nombre' no puede estar vacío")
	private String name;

	@Column(name = "apellido")
	@NotNull
	@Size(min = 1, max = 15, message = "El campo 'Apellido' es requerido")
	private String lastname;

	@Column(name = "edad")
	@Min(value = 18)
	private Integer age;

	@Column(name = "direccion_principal")
	private String mainAddress;

	public UserModel() {
		super();

	}

	public UserModel(Integer id, String name, String lastname, Integer age, String mainAddress) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.age = age;
		this.mainAddress = mainAddress;
	}

	public UserModel(String name, String lastname, Integer age, String mainAddress) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.age = age;
		this.mainAddress = mainAddress;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMainAddress() {
		return mainAddress;
	}

	public void setMainAddress(String mainAddress) {
		this.mainAddress = mainAddress;
	}

	@Override
	public String toString() {
		return String.format("UserModel [id=%s, name=%s, lastname=%s, age=%s, mainAddress=%s]", id, name, lastname, age,
				mainAddress);
	}

}
