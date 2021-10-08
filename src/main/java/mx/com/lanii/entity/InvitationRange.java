package mx.com.lanii.entity;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
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
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)")
	private UUID id;

	private int from;

	private BigDecimal price;

	private boolean status;

	private int to;

	//bi-directional many-to-one association to EventType
	@ManyToOne
	@JoinColumn(name="event_type_id")
	private EventType eventType;

	//bi-directional many-to-one association to InvitationPurchase
	@OneToMany(mappedBy="invitationRange")
	private List<InvitationPurchase> invitationPurchases;

	public InvitationRange() {
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public int getFrom() {
		return this.from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getTo() {
		return this.to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public EventType getEventType() {
		return this.eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public List<InvitationPurchase> getInvitationPurchases() {
		return this.invitationPurchases;
	}

	public void setInvitationPurchases(List<InvitationPurchase> invitationPurchases) {
		this.invitationPurchases = invitationPurchases;
	}

	public InvitationPurchase addInvitationPurchases(InvitationPurchase invitationPurchases) {
		getInvitationPurchases().add(invitationPurchases);
		invitationPurchases.setInvitationRange(this);

		return invitationPurchases;
	}

	public InvitationPurchase removeInvitationPurchases(InvitationPurchase invitationPurchases) {
		getInvitationPurchases().remove(invitationPurchases);
		invitationPurchases.setInvitationRange(null);

		return invitationPurchases;
	}

}