package mx.com.lanii.entity;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.*;


/**
 * The persistent class for the event_extra_param database table.
 * 
 */
@Entity
@Table(name="event_extra_param")
@NamedQuery(name="EventExtraParam.findAll", query="SELECT e FROM EventExtraParam e")
public class EventExtraParam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)")
	private UUID id;

	private String value;

	//bi-directional many-to-one association to Event
	@ManyToOne
	private Event event;

	//bi-directional many-to-one association to ExtraParam
	@ManyToOne
	@JoinColumn(name="extra_param_id")
	private ExtraParam extraParam;

	public EventExtraParam() {
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public ExtraParam getExtraParam() {
		return this.extraParam;
	}

	public void setExtraParam(ExtraParam extraParam) {
		this.extraParam = extraParam;
	}

}