package com.gamers;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("api")
public class AppRoot extends Application {
/*
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {

        resources.add(TestBean.class);


    }
*/

    //TODO: подключить модули angular
    //TODO: jms - какая то логика
    //TODO: продумать функционал
    //TODO: продумать апи
    //TODO: дописать дао-сервисы
    //TODO: дописать бины
    //TODO: дописать фронт

    /* JMS логика:
     * форум
     * подарки
     * приглашения в команды (добавить команды)
     * напоминания о продлении подписки на стримеров
     * подписки/отслеживание новинок, напоминания о выходе новых игр
     */

    // JMS Логика: пользователь может оставить репорт, после добавления
    // просыпается mdb, который записывает в бд сообщение для каждого админа

}