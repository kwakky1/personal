package com.personal.web;

import com.personal.web.entity.Car;
import com.personal.web.repository.CarRepository;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Crawler {
    @Autowired CarRepository carRepository;
    public void oldCar() {
        System.out.println("크롤링시작");
        try {
            String url = "https://www.kbchachacha.com/public/search/main.kbc#!?page=2&sort=-orderDate&gas=004007";
            Connection.Response homepage = Jsoup.connect(url).method(Connection.Method.GET)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36\"")
                    .execute();
            Document d = homepage.parse();
            System.out.println(d);
            Elements img = d.select("img.thumb UIimageScrollLoad");
            Elements manufacturer = d.select("span.cls>strong");
            Elements name = d.select("span.cls>em");
            Elements trim = d.select("span.dtl>strong");
            Elements year = d.select("span.yer");
            Elements km = d.select("span.km");
            Elements local = d.select("span.loc");
            System.out.println("지역 : " + d.select("span.loc"));
            Elements price = d.select("td.prc_hs>strong");
            Car car = null;
            for (int i = 0; i < year.size(); i++) {
                car = new Car();
                car.setCarSeq(Long.valueOf((i+1)));
                car.setImg(img.get(i).select("img").attr("src"));
                car.setManufacturer(manufacturer.get(i).text());
                car.setName(name.get(i).text());
                car.setTrim(trim.get(i).text());
                car.setYear(year.get(i).text());
                car.setKm(km.get(i).text());
                car.setLocal(local.get(i).text());
                car.setPrice(price.get(i).text());
                carRepository.save(car);
                System.out.println(car.toString());
            }
        } catch (Exception e) {
            System.out.println("에러발생");
        }
    }
}
