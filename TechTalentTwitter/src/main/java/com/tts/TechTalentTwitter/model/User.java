package com.tts.TechTalentTwitter.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;




@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;
    
    @Email(message = "Please provide a valid email")
    @NotEmpty(message = "Please provide an email")
    private String email;
    
    @NotEmpty(message = "Please provide a username")
    @Length(min = 3, message = "Your username must have at least 3 characters")
    @Length(max = 15, message = "Your username cannot have more than 15 characters")
    @Pattern(regexp="[^\\s]+", message="Your username cannot contain spaces")
    private String username;
    
    @Length(min = 5, message = "Your password must have at least 5 characters")
    @NotEmpty(message = "Please provide a password")
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;
    
    @NotEmpty(message = "Please provide your first name")
    private String firstName;
    
    @NotEmpty(message = "Please provide your last name")
    private String lastName;
    
    private int active;
    
    @CreationTimestamp 
	private Date createdAt;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_follower", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "follower_id"))
    private List<User> followers;
    
    @ManyToMany(mappedBy="followers")
	private List<User> following;
 
    public void setFollowers(List<User> followers2) {
		// TODO Auto-generated method stub
		
	}
	public List<User> getFollowers() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setActive(int i) {
		// TODO Auto-generated method stub
		
	}
	public List<User> getFollowing() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setRoles(HashSet<javax.management.relation.Role> hashSet) {
		// TODO Auto-generated method stub
		
	}
	public CharSequence getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setPassword(String encode) {
		// TODO Auto-generated method stub
		
	}
	public Object getUsername() {
		// TODO Auto-generated method stub
		return null;
	}


}


	


