package com.example.sport.Entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Founded implements Serializable {
   private Long id ;
   private  Long id_Lost;
   private Long id_found;
   private String msg;


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_Lost() {
        return id_Lost;
    }

    public void setId_Lost(Long id_Lost) {
        this.id_Lost = id_Lost;
    }

    public Long getId_found() {
        return id_found;
    }

    public void setId_found(Long id_found) {
        this.id_found = id_found;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Founded{" +
                "id=" + id +
                ", id_Lost=" + id_Lost +
                ", id_found=" + id_found +
                ", msg='" + msg + '\'' +
                '}';
    }
}
