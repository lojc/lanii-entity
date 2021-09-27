package mx.com.lanii.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the invitation database table.
 * 
 */
@Entity
@NamedQuery(name="Invitation.findAll", query="SELECT i FROM Invitation i")
public class Invitation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)")
	private UUID id;

	@Column(name="ingress_date")
	private LocalDateTime ingressDate;

	@Column(name="rsvp_date")
	private LocalDateTime rsvpDate;

	@Column(name="people_amount")
	private int peopleAmount;

	//bi-directional many-to-one association to Contact
	@ManyToOne
	private Contact contact;

	//bi-directional many-to-one association to Event
	@ManyToOne
	private Event event;

	//bi-directional many-to-one association to Notification
	@OneToMany(mappedBy="invitation")
	private List<Notification> notifications;

	public Invitation() {
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public LocalDateTime getIngressDate() {
		return this.ingressDate;
	}

	public void setIngressDate(LocalDateTime ingressDate) {
		this.ingressDate = ingressDate;
	}

	public LocalDateTime getrsvpDate() {
		return this.rsvpDate;
	}

	public void setRsvpDate(LocalDateTime rsvpDate) {
		this.rsvpDate = rsvpDate;
	}

	public int getPeopleAmount() {
		return this.peopleAmount;
	}

	public void setPeopleAmount(int peopleAmount) {
		this.peopleAmount = peopleAmount;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public List<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public Notification addNotification(Notification notification) {
		getNotifications().add(notification);
		notification.setInvitation(this);

		return notification;
	}

	public Notification removeNotification(Notification notification) {
		getNotifications().remove(notification);
		notification.setInvitation(null);

		return notification;
	}

}