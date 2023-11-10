package com.ipbd.ipbdsms;
import com.ipbd.ipbdsms.service.service.impl.TbLoginServiceImpl;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

public class test {

    @Test
    void test() throws NoSuchAlgorithmException {
        TbLoginServiceImpl tbLoginService = new TbLoginServiceImpl();
        String encrypt = tbLoginService.encrypt("super");
        System.out.println(encrypt);
    }
}
