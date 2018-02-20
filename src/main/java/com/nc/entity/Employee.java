package com.nc.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Employee {
  @Id
  @GeneratedValue
  private int id;
  
//  @Column(name="firstName")
  private String firstName;

//  @Column(name="lastName")
  private String lastName;

//  @Column(name = "salary")
  private int salary;

  public Employee() {}

  public Employee(String fname, String lname, int salary) {
    this.firstName = fname;
    this.lastName = lname;
    this.salary = salary;
  }

  public int getId() {
    return id;
  }

  public void setId( int id ) {
    this.id = id;
  }


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName( String first_name ) {
    this.firstName = first_name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName( String last_name ) {
    this.lastName = last_name;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary( int salary ) {
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "Employee{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", salary=" + salary +
            '}';
  }
}