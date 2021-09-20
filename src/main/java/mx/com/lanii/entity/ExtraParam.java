package mx.com.lanii.entity;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the extra_param database table.
 * 
 */
@Entity
@Table(name="extra_param")
@NamedQuery(name="ExtraParam.findAll", query="SELECT e FROM ExtraParam e")
public class ExtraParam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)")
	private UUID id;

	private String code;

	private String name;

	//bi-directional many-to-one association to ExtraParamEventType
	@OneToMany(mappedBy="extraParam")
	private List<ExtraParamEventType> extraParamEventTypes;

	public ExtraParam() {
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ExtraParamEventType> getExtraParamEventTypes() {
		return this.extraParamEventTypes;
	}

	public void setExtraParamEventTypes(List<ExtraParamEventType> extraParamEventTypes) {
		this.extraParamEventTypes = extraParamEventTypes;
	}

	public ExtraParamEventType addExtraParamEventType(ExtraParamEventType extraParamEventType) {
		getExtraParamEventTypes().add(extraParamEventType);
		extraParamEventType.setExtraParam(this);

		return extraParamEventType;
	}

	public ExtraParamEventType removeExtraParamEventType(ExtraParamEventType extraParamEventType) {
		getExtraParamEventTypes().remove(extraParamEventType);
		extraParamEventType.setExtraParam(null);

		return extraParamEventType;
	}

}