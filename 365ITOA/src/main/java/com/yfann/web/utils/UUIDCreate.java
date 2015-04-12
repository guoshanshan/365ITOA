package com.yfann.web.utils;

import java.util.UUID;

/**
 * Created by Simon on 2015/4/5.
 */
public class UUIDCreate {
    public static String takeUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
