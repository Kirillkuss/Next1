    
package com.itrail.test.domain;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author barysevich_k
 */
@Entity
@Table(name = "ANIMALREST")
public class Animal {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name  =  "ANIMAL_ID")  private Integer    idAnimal;
        @Column(name = "type_animal")  private String     type;
        @Column(name = "coat_animal")  private BigDecimal coat;
        @Column(name = "count_animal") private Integer    count;
        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "USER_ID")  private User       owner;
        public Animal() {
        }             
/**
 * @param idAnimal
 * @param type
 * @param coat
 * @param count
 */
        public Animal(Integer idAnimal,String type, BigDecimal coat,Integer count){
            this.idAnimal = idAnimal;
            this.type = type;
            this.coat = coat;
            this.count = count;
        }
        
    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getCoat() {
        return coat;
    }

    public void setCoat(BigDecimal coat) {
        this.coat = coat;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.idAnimal);
        hash = 83 * hash + Objects.hashCode(this.type);
        hash = 83 * hash + Objects.hashCode(this.coat);
        hash = 83 * hash + Objects.hashCode(this.owner);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.idAnimal, other.idAnimal)) {
            return false;
        }
        if (!Objects.equals(this.coat, other.coat)) {
            return false;
        }
        return Objects.equals(this.owner, other.owner);
    }

    @Override
    public String toString() {
        return "Animal{" + "idAnimal=" + idAnimal + ", type=" + type + ", coat=" + coat +  '}';
    }
    
    
        
}
