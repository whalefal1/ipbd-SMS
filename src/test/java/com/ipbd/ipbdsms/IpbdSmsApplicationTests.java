package com.ipbd.ipbdsms;

import cn.hutool.extra.qrcode.QrConfig;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IpbdSmsApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test(){
        QrConfig qrConfig = new QrConfig(600, 600);
        //高级别二维码
        qrConfig.setErrorCorrection(ErrorCorrectionLevel.H);
        qrConfig.setBackColor(0xFF000000);

    }

}
