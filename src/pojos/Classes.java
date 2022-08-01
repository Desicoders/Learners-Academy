package pojos;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
@Entity
@Table
public class Classes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@OneToMany(fetch=FetchType.LAZY)
	Set< TeachesAndSubject> TeachesAndSubject=null;	
	@Column
	String name;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public Set<TeachesAndSubject> getTeachesAndSubject() {
		return TeachesAndSubject;
	}

	public void setTeachesAndSubject(Set<TeachesAndSubject> teachesAndSubject) {
		TeachesAndSubject = teachesAndSubject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Classes( String name) {
		super();
		this.name = name;
	}

	public Classes() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Classes other = (Classes) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
