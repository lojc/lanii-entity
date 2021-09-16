package mx.com.lanii.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the extra_param_event_type database table.
 * 
 */
@Entity
@Table(name="extra_param_event_type")
@NamedQuery(name="ExtraParamEventType.findAll", query="SELECT e FROM ExtraParamEventType e")
public class ExtraParamEventType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	//bi-directional many-to-one association to EventExtraParamEventType
	@OneToMany(mappedBy="extraParamEventType")
	private List<EventExtraParamEventType> eventExtraParamEventTypes;

	//bi-directional many-to-one association to EventType
	@ManyToOne
	@JoinColumn(name="event_type_id")
	private EventType eventType;

	//bi-directional many-to-one association to ExtraParam
	@ManyToOne
	@JoinColumn(name="extra_param_id")
	private ExtraParam extraParam;

	public ExtraParamEventType() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<EventExtraParamEventType> getEventExtraParamEventTypes() {
		return this.eventExtraParamEventTypes;
	}

	public void setEventExtraParamEventTypes(List<EventExtraParamEventType> eventExtraParamEventTypes) {
		this.eventExtraParamEventTypes = eventExtraParamEventTypes;
	}

	public EventExtraParamEventType addEventExtraParamEventType(EventExtraParamEventType eventExtraParamEventType) {
		getEventExtraParamEventTypes().add(eventExtraParamEventType);
		eventExtraParamEventType.setExtraParamEventType(this);

		return eventExtraParamEventType;
	}

	public EventExtraParamEventType removeEventExtraParamEventType(EventExtraParamEventType eventExtraParamEventType) {
		getEventExtraParamEventTypes().remove(eventExtraParamEventType);
		eventExtraParamEventType.setExtraParamEventType(null);

		return eventExtraParamEventType;
	}

	public EventType getEventType() {
		return this.eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public ExtraParam getExtraParam() {
		return this.extraParam;
	}

	public void setExtraParam(ExtraParam extraParam) {
		this.extraParam = extraParam;
	}

}