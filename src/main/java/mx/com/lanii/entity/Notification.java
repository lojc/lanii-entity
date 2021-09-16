package mx.com.lanii.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the notification database table.
 * 
 */
@Entity
@NamedQuery(name="Notification.findAll", query="SELECT n FROM Notification n")
public class Notification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	//bi-directional many-to-one association to CommunicationType
	@ManyToOne
	@JoinColumn(name="communication_type_id")
	private CommunicationType communicationType;

	//bi-directional many-to-one association to Invitation
	@ManyToOne
	private Invitation invitation;

	//bi-directional many-to-one association to NotificationType
	@ManyToOne
	@JoinColumn(name="notification_type_id")
	private NotificationType notificationType;

	public Notification() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public CommunicationType getCommunicationType() {
		return this.communicationType;
	}

	public void setCommunicationType(CommunicationType communicationType) {
		this.communicationType = communicationType;
	}

	public Invitation getInvitation() {
		return this.invitation;
	}

	public void setInvitation(Invitation invitation) {
		this.invitation = invitation;
	}

	public NotificationType getNotificationType() {
		return this.notificationType;
	}

	public void setNotificationType(NotificationType notificationType) {
		this.notificationType = notificationType;
	}

}