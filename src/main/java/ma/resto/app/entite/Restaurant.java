package ma.resto.app.entite;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String adresse;
	@Temporal(TemporalType.TIME)
	private Date heureOuvert;
	@Temporal(TemporalType.TIME)
	private Date heureClose;
	private String jourOverture;
	private double longitude;
	private double latitude;
	private String nom;
	private String rank;
	@ManyToOne
	
	private Zone zone;
	@ManyToOne
	
	private Serie serie;
	@ManyToOne
	@JsonIgnore
	private User user;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "resto_specialite", joinColumns = @JoinColumn(name = "resto_id"), inverseJoinColumns = @JoinColumn(name = "specialite_id"))
	@JsonIgnore
	private List<Specialite> specialites;
	@OneToMany(mappedBy = "restaurant")
	@JsonIgnore
	private List<Photo> photos;
}
