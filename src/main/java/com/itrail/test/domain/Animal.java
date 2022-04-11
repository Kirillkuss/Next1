package com.itrail.test.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
import javax.validation.constraints.Size;

/**
 *
 * @author barysevich_k
 */
@ApiModel(description = "Информация о питомце")
@Entity
@Table(name = "ANIMALREST")
public class Animal {

    @ApiModelProperty(value = "Ид питомца ", name = "idAnimal", dataType = "Integer", example = "1",required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ANIMAL_ID")
    private Integer idAnimal;
    
    @ApiModelProperty(value = "Тип питомца ", name = "Type", dataType = "String",required = true)
    @Column(name = "type_animal")
    @Size(min = 1, max = 20)
    private String type;
    
    @ApiModelProperty(value = "Цена питомца ", name = "Coat", dataType = "String", example = "1", required = true)
    @Column(name = "coat_animal")
    private BigDecimal coat;
    
    @ApiModelProperty(value = "Количество питомцев ", name = "Count", dataType = "Integer", example = "1", required = true)
    @Column(name = "count_animal")
    private Integer count;
    
    @ApiModelProperty(value = "Хозяин питомца ", name = "Owner",example = "null",required = false)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User owner;

    public Animal() {
    }

    public Animal(Integer idAnimal, String type, BigDecimal coat, Integer count) {
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
        return "Animal{" + "idAnimal=" + idAnimal + ", type=" + type + ", coat=" + coat + '}';
    }

}
