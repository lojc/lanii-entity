package mx.com.lanii.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the event_type database table.
 * 
 */
@Entity
@Table(name="event_type")
@NamedQuery(name="EventType.findAll", query="SELECT e FROM EventType e")
public class EventType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String code;

	private String name;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="eventType")
	private List<Event> events;

	//bi-directional many-to-one association to ExtraParamEventType
	@OneToMany(mappedBy="eventType")
	private List<ExtraParamEventType> extraParamEventTypes;

	//bi-directional many-to-one association to InvitationRange
	@OneToMany(mappedBy="eventType")
	private List<InvitationRange> invitationRanges;

	public EventType() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
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

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setEventType(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setEventType(null);

		return event;
	}

	public List<ExtraParamEventType> getExtraParamEventTypes() {
		return this.extraParamEventTypes;
	}

	public void setExtraParamEventTypes(List<ExtraParamEventType> extraParamEventTypes) {
		this.extraParamEventTypes = extraParamEventTypes;
	}

	public ExtraParamEventType addExtraParamEventType(ExtraParamEventType extraParamEventType) {
		getExtraParamEventTypes().add(extraParamEventType);
		extraParamEventType.setEventType(this);

		return extraParamEventType;
	}

	public ExtraParamEventType removeExtraParamEventType(ExtraParamEventType extraParamEventType) {
		getExtraParamEventTypes().remove(extraParamEventType);
		extraParamEventType.setEventType(null);

		return extraParamEventType;
	}

	public List<InvitationRange> getInvitationRanges() {
		return this.invitationRanges;
	}

	public void setInvitationRanges(List<InvitationRange> invitationRanges) {
		this.invitationRanges = invitationRanges;
	}

	public InvitationRange addInvitationRange(InvitationRange invitationRange) {
		getInvitationRanges().add(invitationRange);
		invitationRange.setEventType(this);

		return invitationRange;
	}

	public InvitationRange removeInvitationRange(InvitationRange invitationRange) {
		getInvitationRanges().remove(invitationRange);
		invitationRange.setEventType(null);

		return invitationRange;
	}

}