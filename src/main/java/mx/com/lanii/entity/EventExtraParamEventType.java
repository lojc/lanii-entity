package mx.com.lanii.entity;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.*;


/**
 * The persistent class for the event_extra_param_event_type database table.
 * 
 */
@Entity
@Table(name="event_extra_param_event_type")
@NamedQuery(name="EventExtraParamEventType.findAll", query="SELECT e FROM EventExtraParamEventType e")
public class EventExtraParamEventType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)")
	private UUID id;

	@Column(name="event_id")
	private byte[] eventId;

	private String name;

	//bi-directional one-to-one association to Event
	@OneToOne
	@JoinColumn(name="id")
	private Event event;

	//bi-directional many-to-one association to ExtraParamEventType
	@ManyToOne
	@JoinColumn(name="extra_param_event_type_id")
	private ExtraParamEventType extraParamEventType;

	public EventExtraParamEventType() {
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public byte[] getEventId() {
		return this.eventId;
	}

	public void setEventId(byte[] eventId) {
		this.eventId = eventId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public ExtraParamEventType getExtraParamEventType() {
		return this.extraParamEventType;
	}

	public void setExtraParamEventType(ExtraParamEventType extraParamEventType) {
		this.extraParamEventType = extraParamEventType;
	}

}