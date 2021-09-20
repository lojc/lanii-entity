package mx.com.lanii.entity;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the communication_type database table.
 * 
 */
@Entity
@Table(name="communication_type")
@NamedQuery(name="CommunicationType.findAll", query="SELECT c FROM CommunicationType c")
public class CommunicationType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)")
	private UUID id;

	private String code;

	private String name;

	//bi-directional many-to-one association to InvitationRange
	@OneToMany(mappedBy="communicationType")
	private List<InvitationRange> invitationRanges;

	//bi-directional many-to-one association to Notification
	@OneToMany(mappedBy="communicationType")
	private List<Notification> notifications;

	public CommunicationType() {
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

	public List<InvitationRange> getInvitationRanges() {
		return this.invitationRanges;
	}

	public void setInvitationRanges(List<InvitationRange> invitationRanges) {
		this.invitationRanges = invitationRanges;
	}

	public InvitationRange addInvitationRange(InvitationRange invitationRange) {
		getInvitationRanges().add(invitationRange);
		invitationRange.setCommunicationType(this);

		return invitationRange;
	}

	public InvitationRange removeInvitationRange(InvitationRange invitationRange) {
		getInvitationRanges().remove(invitationRange);
		invitationRange.setCommunicationType(null);

		return invitationRange;
	}

	public List<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public Notification addNotification(Notification notification) {
		getNotifications().add(notification);
		notification.setCommunicationType(this);

		return notification;
	}

	public Notification removeNotification(Notification notification) {
		getNotifications().remove(notification);
		notification.setCommunicationType(null);

		return notification;
	}

}