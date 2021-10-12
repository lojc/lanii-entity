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

	//bi-directional many-to-one association to EventExtraParam
	@OneToMany(mappedBy="extraParam")
	private List<EventExtraParam> eventExtraParams;

	//bi-directional many-to-one association to TemplateExtraParam
	@OneToMany(mappedBy="extraParam")
	private List<TemplateExtraParam> templateExtraParams;

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

	public List<EventExtraParam> getEventExtraParams() {
		return this.eventExtraParams;
	}

	public void setEventExtraParams(List<EventExtraParam> eventExtraParams) {
		this.eventExtraParams = eventExtraParams;
	}

	public EventExtraParam addEventExtraParam(EventExtraParam eventExtraParam) {
		getEventExtraParams().add(eventExtraParam);
		eventExtraParam.setExtraParam(this);

		return eventExtraParam;
	}

	public EventExtraParam removeEventExtraParam(EventExtraParam eventExtraParam) {
		getEventExtraParams().remove(eventExtraParam);
		eventExtraParam.setExtraParam(null);

		return eventExtraParam;
	}

	public List<TemplateExtraParam> getTemplateExtraParams() {
		return this.templateExtraParams;
	}

	public void setTemplateExtraParams(List<TemplateExtraParam> templateExtraParams) {
		this.templateExtraParams = templateExtraParams;
	}

	public TemplateExtraParam addTemplateExtraParam(TemplateExtraParam templateExtraParam) {
		getTemplateExtraParams().add(templateExtraParam);
		templateExtraParam.setExtraParam(this);

		return templateExtraParam;
	}

	public TemplateExtraParam removeTemplateExtraParam(TemplateExtraParam templateExtraParam) {
		getTemplateExtraParams().remove(templateExtraParam);
		templateExtraParam.setExtraParam(null);

		return templateExtraParam;
	}

}