package mx.com.lanii.entity;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


/**
 * The persistent class for the notification database table.
 * 
 */
@Entity
@NamedQuery(name="Notification.findAll", query="SELECT n FROM Notification n")
public class Notification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)")
	private UUID id;

	private LocalDateTime date;

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

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return this.date;
	}

	public void setDate(LocalDateTime date) {
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