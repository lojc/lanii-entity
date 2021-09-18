package mx.com.lanii.entity;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


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
	private String id;

	private String address;

	@Column(name="can_send_email")
	private boolean canSendEmail;

	@Column(name="can_send_ingress_pass")
	private boolean canSendIngressPass;

	@Column(name="can_send_sms")
	private boolean canSendSms;

	@Column(name="can_send_whatsapp")
	private boolean canSendWhatsapp;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_finished")
	private Date dateFinished;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_start")
	private Date dateStart;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_started")
	private Date dateStarted;

	private double duration;

	@Column(name="guest_amount")
	private int guestAmount;

	@Column(name="invitation_amount")
	private int invitationAmount;

	@Column(name="location_name")
	private String locationName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="reschedule_date")
	private Date rescheduleDate;

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
	@OneToMany(mappedBy="event")
	private List<Invitation> invitations;

	public Event() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean getCanSendEmail() {
		return this.canSendEmail;
	}

	public void setCanSendEmail(boolean canSendEmail) {
		this.canSendEmail = canSendEmail;
	}

	public boolean getCanSendIngressPass() {
		return this.canSendIngressPass;
	}

	public void setCanSendIngressPass(boolean canSendIngressPass) {
		this.canSendIngressPass = canSendIngressPass;
	}

	public boolean getCanSendSms() {
		return this.canSendSms;
	}

	public void setCanSendSms(boolean canSendSms) {
		this.canSendSms = canSendSms;
	}

	public boolean getCanSendWhatsapp() {
		return this.canSendWhatsapp;
	}

	public void setCanSendWhatsapp(boolean canSendWhatsapp) {
		this.canSendWhatsapp = canSendWhatsapp;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDateFinished() {
		return this.dateFinished;
	}

	public void setDateFinished(Date dateFinished) {
		this.dateFinished = dateFinished;
	}

	public Date getDateStart() {
		return this.dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateStarted() {
		return this.dateStarted;
	}

	public void setDateStarted(Date dateStarted) {
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

	public Date getRescheduleDate() {
		return this.rescheduleDate;
	}

	public void setRescheduleDate(Date rescheduleDate) {
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

}