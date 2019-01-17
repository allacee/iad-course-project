package com.gamers.entities;

import java.util.Date;
import java.util.Set;
import java.util.List;
import java.util.LinkedHashSet;
import javax.persistence.*;
import javax.persistence.GenerationType;
import lombok.*;
/**
 * @author Черноусов Евгений, Глушков Дмитрий
 * @version 1.0
 * @since beta
 * Это класс обеспечивающий описание сущности <strong>Г_Подача_блюда</strong> в виде класса
 */
@Entity
@Table(name="Г_Подача_блюда")
@EqualsAndHashCode
public class DishOut
{
    @Id
    @Column(name="ИД", columnDefinition = "serial")
    @GeneratedValue(strategy=GenerationType.IDENTITY)   
    private long id;


    @ManyToOne
    @JoinColumn(name="ИД_Места")
    private long id1;

    @ManyToOne
    @JoinColumn(name="ИД_Блюда")
    private long id2;

    @Column(name="Время")
    private Date date;

    public DishOut()
    {
    }

    /**
     * Устанавливает значения по атрибутам сущности
     * @param id1 ИД Места
     * @param id2 ИД Блюда
     * @param date Время
     */
    public DishOut(long id1, long id2, Date date)
    {
        this.id1 = id1;
        this.id2 = id2;
        this.date = date;
    }

    public long getId()
    {
        return id;
    }

    public long getId1() {
        return id1;
    }

    public long getId2() {
        return id2;
    }

    public Date getDate() {
        return date;
    }

    public void setId1(long id1) {
        this.id1 = id1;
    }

    public void setId2(long id2) {
        this.id2 = id2;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}