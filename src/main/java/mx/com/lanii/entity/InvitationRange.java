package mx.com.lanii.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the invitation_range database table.
 * 
 */
@Entity
@Table(name="invitation_range")
@NamedQuery(name="InvitationRange.findAll", query="SELECT i FROM InvitationRange i")
public class InvitationRange implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private int from;

	private double price;

	private byte status;

	private int to;

	//bi-directional many-to-one association to CommunicationType
	@ManyToOne
	@JoinColumn(name="communication_type_id")
	private CommunicationType communicationType;

	//bi-directional many-to-one association to EventType
	@ManyToOne
	@JoinColumn(name="event_type_id")
	private EventType eventType;

	public InvitationRange() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getFrom() {
		return this.from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public int getTo() {
		return this.to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public CommunicationType getCommunicationType() {
		return this.communicationType;
	}

	public void setCommunicationType(CommunicationType communicationType) {
		this.communicationType = communicationType;
	}

	public EventType getEventType() {
		return this.eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

}