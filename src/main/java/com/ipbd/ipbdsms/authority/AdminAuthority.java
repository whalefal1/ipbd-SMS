package com.ipbd.ipbdsms.authority;

import java.util.ArrayList;
import java.util.List;

public class AdminAuthority implements Authority {

    @Override
    public List<String> getAuthority() {
        return new ArrayList<String>(){{
            add("admin:add");
        }};
    }
}
