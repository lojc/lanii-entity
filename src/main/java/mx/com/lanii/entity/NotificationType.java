package mx.com.lanii.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the notification_type database table.
 * 
 */
@Entity
@Table(name="notification_type")
@NamedQuery(name="NotificationType.findAll", query="SELECT n FROM NotificationType n")
public class NotificationType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String code;

	private String name;

	//bi-directional many-to-one association to Notification
	@OneToMany(mappedBy="notificationType")
	private List<Notification> notifications;

	public NotificationType() {
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

	public List<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public Notification addNotifications(Notification notifications) {
		getNotifications().add(notifications);
		notifications.setNotificationType(this);

		return notifications;
	}

	public Notification removeNotifications(Notification notifications) {
		getNotifications().remove(notifications);
		notifications.setNotificationType(null);

		return notifications;
	}


}