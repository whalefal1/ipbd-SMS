package com.ipbd.ipbdsms.utils;

import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import cn.hutool.core.io.FileUtil;

public class QrUtil {
    public static void main(String[] args) {
        QrConfig qrConfig = new QrConfig(600, 600);
        //高级别二维码
        qrConfig.setErrorCorrection(ErrorCorrectionLevel.H);
        QrCodeUtil.generate("http://101.132.177.19:8010/backend/sign/javaSign", qrConfig , FileUtil.file("d:/qrcode.jpg"));
    }
}
