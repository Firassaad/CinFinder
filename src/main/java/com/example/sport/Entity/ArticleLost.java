package com.example.sport.Entity;
import com.sun.istack.Nullable;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ArticleLost implements Serializable {
    private  Long id;
    private Long num ;
    private  String fullname ;
    private String date;
    private int num_tel ;
    @Nullable
    private Long exist_id;

    public ArticleLost() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getNum() {
        return num;
    }
    public void setNum(Long num) {
        this.num = num;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public int getNum_tel() {
        return num_tel;
    }
    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }
    public Long getExist_id() {
        return exist_id;
    }
    public void setExist_id(Long exist_id) {
        this.exist_id = exist_id;
    }
    @Override
    public String toString() {
        return "ArticleLost{" +
                "id=" + id +
                ", num=" + num +
                ", fullname='" + fullname + '\'' +
                ", date='" + date + '\'' +
                ", num_tel=" + num_tel +
                ", exist_id=" + exist_id +
                '}';
    }
}
