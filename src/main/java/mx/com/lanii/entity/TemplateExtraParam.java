package mx.com.lanii.entity;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.*;


/**
 * The persistent class for the template_extra_param database table.
 * 
 */
@Entity
@Table(name="template_extra_param")
@NamedQuery(name="TemplateExtraParam.findAll", query="SELECT t FROM TemplateExtraParam t")
public class TemplateExtraParam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)")
	private UUID id;

	//bi-directional many-to-one association to ExtraParam
	@ManyToOne
	@JoinColumn(name="extra_param_id")
	private ExtraParam extraParam;

	//bi-directional many-to-one association to Template
	@ManyToOne
	private Template template;

	public TemplateExtraParam() {
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public ExtraParam getExtraParam() {
		return this.extraParam;
	}

	public void setExtraParam(ExtraParam extraParam) {
		this.extraParam = extraParam;
	}

	public Template getTemplate() {
		return this.template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

}