package com.atguigu.boot.converter;

import com.atguigu.boot.bean.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * 自定义的Converter
 * */
public class MyAtguiguMessageConverter implements HttpMessageConverter<Person> {
   /**
    * 读是需要在方法种有@requestBody标注的参数，此处只正对写
    * */
    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    /**
     *当方法返回的值类型是Person时就开始写
     */
    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return clazz.isAssignableFrom(Person.class);
    }

    /**
     * 服务器要统计所有MessageConverter都能写出哪些内容类型，自定义协议数据类型
     * 写出我们自定义的application/x-guigu类型
     * @return
     */
    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return MediaType.parseMediaTypes("application/my-Atguigu");
    }

    @Override
    public List<MediaType> getSupportedMediaTypes(Class<?> clazz) {
        return HttpMessageConverter.super.getSupportedMediaTypes(clazz);
    }

    @Override
    public Person read(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    /**
     *自定义数据的写出
     */
    @Override
    public void write(Person person, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String data = person.getUserName()+","+ person.getAge()+","+person.getBirth()+","+ person.getPet();
        OutputStream body = outputMessage.getBody();
        body.write(data.getBytes());
    }
}
