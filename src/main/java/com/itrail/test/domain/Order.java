
package com.itrail.test.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.itrail.test.serializer.LocalDateTimeSerializer;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author barysevich_k
 */
@Entity
@Table(name = "ORDEREST")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer            idOrder;
    private Integer            userID;
    private Integer            animalID;
    private BigDecimal         sum;
    @JsonSerialize( using = LocalDateTimeSerializer.class )
    private LocalDateTime      time;

    public Order() {
    }

    public Order(Integer idOrder, Integer userID, Integer animalID, BigDecimal sum, LocalDateTime time) {
        this.idOrder  = idOrder;
        this.userID   = userID;
        this.animalID = animalID;
        this.sum      = sum;
        this.time     = time;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getAnimalID() {
        return animalID;
    }

    public void setAnimalID(Integer animalID) {
        this.animalID = animalID;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.idOrder);
        hash = 67 * hash + Objects.hashCode(this.userID);
        hash = 67 * hash + Objects.hashCode(this.animalID);
        hash = 67 * hash + Objects.hashCode(this.sum);
        hash = 67 * hash + Objects.hashCode(this.time);
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
        final Order other = (Order) obj;
        if (!Objects.equals(this.time, other.time)) {
            return false;
        }
        if (!Objects.equals(this.idOrder, other.idOrder)) {
            return false;
        }
        if (!Objects.equals(this.userID, other.userID)) {
            return false;
        }
        if (!Objects.equals(this.animalID, other.animalID)) {
            return false;
        }
        return Objects.equals(this.sum, other.sum);
    }

    @Override
    public String toString() {
        return "Order{" + "idOrder=" + idOrder + ", userID=" + userID + ", animalID=" + animalID + ", sum=" + sum + ", time=" + time + '}';
    }
    
    
    
}
