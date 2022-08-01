package pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
@Entity
@Table
public class TeachesAndSubject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	@OneToOne
	Teacher teach;
	@OneToOne
	Subjects subject;
	public TeachesAndSubject() {
		// TODO Auto-generated constructor stub
	}
	

	public TeachesAndSubject(Teacher teach, Subjects subject) {
		super();
		this.teach = teach;
		this.subject = subject;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Teacher getTeach() {
		return teach;
	}

	public void setTeach(Teacher teach) {
		this.teach = teach;
	}

	public Subjects getSubject() {
		return subject;
	}

	public void setSubject(Subjects subject) {
		this.subject = subject;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + ((teach == null) ? 0 : teach.hashCode());
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
		TeachesAndSubject other = (TeachesAndSubject) obj;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (teach == null) {
			if (other.teach != null)
				return false;
		} else if (!teach.equals(other.teach))
			return false;
		return true;
	}
	

}
