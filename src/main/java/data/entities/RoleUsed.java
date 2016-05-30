package data.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class RoleUsed {

    @Id
    @GeneratedValue
    private int id;
    
    @ManyToMany(fetch = FetchType.EAGER)
    private Person person;
    
    @Enumerated(EnumType.STRING)
    private Role role;
}
