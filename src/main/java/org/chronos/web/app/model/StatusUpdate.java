package org.chronos.web.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name = "STATUS_UPDATE")
public class StatusUpdate {

	@Id
	@Column(name = "STATUS_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long statusId;

	@Column(name = "STATUS_TEXT")
	@Size(min=5, max=255, message="{addStatus.text.size}")
	private String statusText;

	@Column(name = "DATE_ADDED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAdded;

	@PrePersist
	protected void onCreate() 
	{
		if (dateAdded == null) {
			dateAdded = new Date();
		}
	}
	
	public StatusUpdate() 
	{
		super();
	}

	public StatusUpdate(String statusText) {
		this.statusText = statusText;
	}

	public StatusUpdate(String statusText, Date added) {
		this.statusText = statusText;
		this.dateAdded = added;
	}

	public Long getStatusId() {
		return statusId;  
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	@Override
	public String toString() {
		return "StatusUpdate [statusId=" + statusId + ", statusText=" + statusText + ", dateAdded=" + dateAdded + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateAdded == null) ? 0 : dateAdded.hashCode());
		result = prime * result + ((statusId == null) ? 0 : statusId.hashCode());
		result = prime * result + ((statusText == null) ? 0 : statusText.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatusUpdate other = (StatusUpdate) obj;
		if (dateAdded == null) {
			if (other.dateAdded != null)
				return false;
		} else if (!dateAdded.equals(other.dateAdded))
			return false;
		if (statusId == null) {
			if (other.statusId != null)
				return false;
		} else if (!statusId.equals(other.statusId))
			return false;
		if (statusText == null) {
			if (other.statusText != null)
				return false;
		} else if (!statusText.equals(other.statusText))
			return false;
		return true;
	}
}
