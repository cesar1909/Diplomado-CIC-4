package mx.ipn.cic.SpringExample.model;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserModel implements Serializable {

	private static final long serialVersionUID = -353954682904818696L;

	private Integer id;

	@NotNull(message = "El Campo 'Nombre' no puede ser nulo")
	@Size(min = 1, max = 15, message = "El Campo 'Nombre' no puede estar vacío")
	private String name;

	@NotNull
	@Size(min = 1, max = 15, message = "El campo 'Apellido' es requerido")
	private String lastname;

	@Min(value = 18)
	private Integer age;

	public UserModel() {
		super();

	}

	public UserModel(Integer id, String name, String lastname, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.age = age;
	}

	public UserModel(String name, String lastname, Integer age) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.age = age;
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

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", name=" + name + ", lastname=" + lastname + ", age=" + age + "]";
	}

}
