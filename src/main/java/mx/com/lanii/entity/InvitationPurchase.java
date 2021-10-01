package mx.com.lanii.entity;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


/**
 * The persistent class for the invitation_purchase database table.
 * 
 */
@Entity
@Table(name="invitation_purchase")
@NamedQuery(name="InvitationPurchase.findAll", query="SELECT i FROM InvitationPurchase i")
public class InvitationPurchase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)")
	private UUID id;

	private int amount;

	private LocalDateTime date;

	//bi-directional many-to-one association to Event
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
	private Event event;

	private BigDecimal cost;

	//bi-directional many-to-one association to InvitationRange
	@ManyToOne
	@JoinColumn(name="invitation_range_id")
	private InvitationRange invitationRange;

	public InvitationPurchase() {
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public BigDecimal getCost() {
		return this.cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public LocalDateTime getDate() {
		return this.date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public InvitationRange getInvitationRange() {
		return this.invitationRange;
	}

	public void setInvitationRange(InvitationRange invitationRange) {
		this.invitationRange = invitationRange;
	}

}