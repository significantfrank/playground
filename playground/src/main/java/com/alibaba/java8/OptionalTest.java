package com.alibaba.java8;

import lombok.Data;
import org.junit.Test;

import javax.xml.ws.soap.Addressing;
import java.util.Optional;

import static junit.framework.Assert.assertEquals;

/**
 * frank zhang 2019-04-17
 */
public class OptionalTest {

    @Test
    public void optionalMap(){
        User user = new User();
        boolean result = Optional.of(user).map((p) -> {return p.getAddress() != null;}).orElse(false);
        System.out.println(result);
    }

    @Test
    public void whenCreateOfNullableOptional_thenOk() {
        String name = "John";
        Optional<String> opt = Optional.ofNullable(name);
        assertEquals("John", opt.get());

        Optional<String> opt2 = Optional.ofNullable(null);
        System.out.println(opt2);
        System.out.println(opt2.isPresent());
    }

    @Test
    public void oldNullCheckWay(){
        User user = new User();
        //String isocode = user.getAddress().getCountry().getIsoCode().toUpperCase();
        if (user != null) {
            Address address = user.getAddress();
            if (address != null) {
                Country country = address.getCountry();
                if (country != null) {
                    String isocode = country.getIsoCode();
                    if (isocode != null) {
                        isocode = isocode.toUpperCase();
                    }
                }
            }
        }
    }

    @Test
    public void newNullCheckWay(){
        User user = new User();
        Optional<User> opt = Optional.ofNullable(user);

    }
}

@Data
class User{
    private Address address;
}

@Data
class Address{
    private Country country;
}

@Data
class Country{
    private String isoCode;
}
