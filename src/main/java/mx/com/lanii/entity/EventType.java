package mx.com.lanii.entity;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;


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
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)")
	private UUID id;

	private String code;

	private String name;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="eventType")
	private List<Event> events;

	//bi-directional many-to-one association to InvitationRange
	@OneToMany(mappedBy="eventType")
	private List<InvitationRange> invitationRanges;

	//bi-directional many-to-one association to Template
	@OneToMany(mappedBy="eventType")
	private List<Template> templates;

	public EventType() {
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

	public List<Template> getTemplates() {
		return this.templates;
	}

	public void setTemplates(List<Template> templates) {
		this.templates = templates;
	}

	public Template addTemplate(Template template) {
		getTemplates().add(template);
		template.setEventType(this);

		return template;
	}

	public Template removeTemplate(Template template) {
		getTemplates().remove(template);
		template.setEventType(null);

		return template;
	}

}