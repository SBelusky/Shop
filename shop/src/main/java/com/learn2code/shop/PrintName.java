//@Value -> na získanie dát z .properties súboru, formát zápisu "${}"
//@PostConstruct -> metóda sa spustí až po načítaní konfigurácia, čiže beanov atď.

package com.learn2code.shop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class PrintName {
    @Value("${name}")
    String name;

    @PostConstruct
    public void AfterLoadSpring(){
        System.out.println(name);
    }
}
