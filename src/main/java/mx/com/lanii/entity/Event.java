package mx.com.lanii.entity;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the event database table.
 * 
 */
@Entity
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)")
	private UUID id;

	private String address;

	@Column(name="can_send_ingress_pass")
	private boolean canSendIngressPass;

	@Column(name="can_rsvp")
	private boolean canRsvp;

	private LocalDateTime date;

	@Column(name="date_finished")
	private LocalDateTime dateFinished;

	@Column(name="date_start")
	private LocalDateTime dateStart;

	@Column(name="date_started")
	private LocalDateTime dateStarted;

	private double duration;

	@Column(name="guest_amount")
	private int guestAmount;

	@Column(name="invitation_amount")
	private int invitationAmount;

	@Column(name="location_name")
	private String locationName;

	@Column(name="reschedule_date")
	private LocalDateTime rescheduleDate;

	private boolean status;

	private String title;

	@Column(name="total_cost")
	private double totalCost;

	@Column(name="user_id")
	private String userId;

	//bi-directional many-to-one association to EventType
	@ManyToOne
	@JoinColumn(name="event_type_id")
	private EventType eventType;

	//bi-directional many-to-one association to Template
	@ManyToOne
	private Template template;

	//bi-directional one-to-one association to EventExtraParamEventType
	@OneToOne(mappedBy="event")
	private EventExtraParamEventType eventExtraParamEventType;

	//bi-directional many-to-one association to Invitation
	@OneToMany(fetch=FetchType.LAZY, mappedBy="event", cascade={CascadeType.ALL})
	private List<Invitation> invitations;

	//bi-directional many-to-one association to InvitationPurchase
	@OneToMany(fetch=FetchType.LAZY, mappedBy="event", cascade={CascadeType.ALL})
	private List<InvitationPurchase> invitationPurchases;

	public Event() {
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean getCanSendIngressPass() {
		return this.canSendIngressPass;
	}

	public void setCanSendIngressPass(boolean canSendIngressPass) {
		this.canSendIngressPass = canSendIngressPass;
	}

	public boolean getCanRsvp() {
		return this.canRsvp;
	}

	public void setCanRsvp(boolean canRsvp) {
		this.canRsvp = canRsvp;
	}

	public LocalDateTime getDate() {
		return this.date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public LocalDateTime getDateFinished() {
		return this.dateFinished;
	}

	public void setDateFinished(LocalDateTime dateFinished) {
		this.dateFinished = dateFinished;
	}

	public LocalDateTime getDateStart() {
		return this.dateStart;
	}

	public void setDateStart(LocalDateTime dateStart) {
		this.dateStart = dateStart;
	}

	public LocalDateTime getDateStarted() {
		return this.dateStarted;
	}

	public void setDateStarted(LocalDateTime dateStarted) {
		this.dateStarted = dateStarted;
	}

	public double getDuration() {
		return this.duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public int getGuestAmount() {
		return this.guestAmount;
	}

	public void setGuestAmount(int guestAmount) {
		this.guestAmount = guestAmount;
	}

	public int getInvitationAmount() {
		return this.invitationAmount;
	}

	public void setInvitationAmount(int invitationAmount) {
		this.invitationAmount = invitationAmount;
	}

	public String getLocationName() {
		return this.locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public LocalDateTime getRescheduleDate() {
		return this.rescheduleDate;
	}

	public void setRescheduleDate(LocalDateTime rescheduleDate) {
		this.rescheduleDate = rescheduleDate;
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getTotalCost() {
		return this.totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public EventType getEventType() {
		return this.eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public Template getTemplate() {
		return this.template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public EventExtraParamEventType getEventExtraParamEventType() {
		return this.eventExtraParamEventType;
	}

	public void setEventExtraParamEventType(EventExtraParamEventType eventExtraParamEventType) {
		this.eventExtraParamEventType = eventExtraParamEventType;
	}

	public List<Invitation> getInvitations() {
		return this.invitations;
	}

	public void setInvitations(List<Invitation> invitations) {
		this.invitations = invitations;
	}

	public Invitation addInvitation(Invitation invitation) {
		getInvitations().add(invitation);
		invitation.setEvent(this);

		return invitation;
	}

	public Invitation removeInvitation(Invitation invitation) {
		getInvitations().remove(invitation);
		invitation.setEvent(null);

		return invitation;
	}

	public List<InvitationPurchase> getInvitationPurchases() {
		return this.invitationPurchases;
	}

	public void setInvitationPurchases(List<InvitationPurchase> invitationPurchases) {
		this.invitationPurchases = invitationPurchases;
	}

	public InvitationPurchase addInvitationPurchase(InvitationPurchase invitationPurchase) {
		getInvitationPurchases().add(invitationPurchase);
		invitationPurchase.setEvent(this);

		return invitationPurchase;
	}

	public InvitationPurchase removeInvitationPurchase(InvitationPurchase invitationPurchase) {
		getInvitationPurchases().remove(invitationPurchase);
		invitationPurchase.setEvent(null);

		return invitationPurchase;
	}

}