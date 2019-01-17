package com.gamers.entities;

import javax.persistence.*;
import javax.persistence.GenerationType;
import lombok.*;

import java.util.Date;

/**
 * @author Черноусов Евгений, Глушков Дмитрий
 * @version 1.0
 * @since beta
 * Это класс обеспечивающий описание сущности <strong>Г_Задача</strong> в виде класса
 */
@Entity
@Table(name="Г_Задача")
@EqualsAndHashCode
public class Task
{
    @Id
    @Column(name="ИД", columnDefinition = "serial")
    @GeneratedValue(strategy=GenerationType.IDENTITY)   
    private long id;

    @ManyToOne
    @JoinColumn(name="ИД_Пользователя")
    private long id1;

    @Column(name="Название")
    private String name;

    @Column(name="Описание")
    private String desc;

    @Column(name="Дата")
    private Date date;

    public Task()
    {
    }

    /**
     * Устанавливает значения по атрибутам сущности
     * @param name Название
     * @param desc Описание
     * @param date Дата
     */
    public Task(String name, String desc, Date date)
    {
        this.name = name;
        this.desc = desc;
        this.date = date;
    }

    public long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public long getId1() {
        return id1;
    }

    public String getDesc() {
        return desc;
    }

    public Date getDate() {
        return date;
    }

    /**
     * Метод устанавливает название
     * @param name Строка - будет установлена как название
     */
    public void setName(String name)
    {
        this.name = name;
    }

    public void setId1(long id1) {
        this.id1 = id1;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
