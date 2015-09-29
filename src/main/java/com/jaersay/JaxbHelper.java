package com.jaersay;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by zhaorui on 15/9/29.
 */
public class JaxbHelper {

    public static String ConvertModelToXml(Object object) {
        JAXBContext context = null;
        Writer outputWriter = new StringWriter();
        Marshaller marshaller;

        try {
            context = JAXBContext.newInstance(object.getClass());
            marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");// 编码格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);// 是否格式化生成的xml串
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);// 是否省略xml头信息（<?xml
            marshaller.marshal(object, outputWriter);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return outputWriter.toString();

    }
}
