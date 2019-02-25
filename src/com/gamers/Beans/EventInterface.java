package com.gamers.Beans;


import org.json.simple.JSONObject;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Local;
import java.sql.Time;

@Local
public interface EventInterface
{

    @RolesAllowed({"admin", "user"})
    JSONObject create(String description, String dateStr, String timeStr);

    @RolesAllowed({"admin", "user"})
    JSONObject findByDate(String dateStr);

    @RolesAllowed({"admin", "user"})
    JSONObject delete(String id);

}
