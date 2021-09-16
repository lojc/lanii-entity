package mx.com.lanii.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the invitation database table.
 * 
 */
@Entity
@NamedQuery(name="Invitation.findAll", query="SELECT i FROM Invitation i")
public class Invitation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ingress_date")
	private Date ingressDate;

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

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getIngressDate() {
		return this.ingressDate;
	}

	public void setIngressDate(Date ingressDate) {
		this.ingressDate = ingressDate;
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