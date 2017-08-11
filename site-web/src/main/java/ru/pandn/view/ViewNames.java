package ru.pandn.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ViewNames {
    private static final Logger logger = LoggerFactory.getLogger(ViewNames.class);

    public static final String MAIN_ACTION = "/";
    public static final String ADD_USER = "/user/add";
    public static final String DELETE_USER = "/user/delete";

    public Object get(String key){
        try {
            return this.getClass().getField(key).get(String.class);
        } catch (NoSuchFieldException e) { return null; }
        catch (IllegalAccessException e) { return null; }
    }

}
