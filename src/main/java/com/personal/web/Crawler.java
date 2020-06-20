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
            try {
                String url = "https://www.bobaedream.co.kr/mycar/mycar_list.php?gubun=K&page=3&order=S11&view_size=70";
                Connection.Response homepage = Jsoup.connect(url).method(Connection.Method.GET)
                        .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36\"")
                        .execute();
                Document d = homepage.parse();
                Elements img = d.select("a.img.w164");
                Elements name = d.select("p.tit>a");
                Elements year = d.select("div.mode-cell.year>span");
                Elements km = d.select("div.mode-cell.km>span");
                Elements fuel = d.select("div.mode-cell.fuel>span");
                Elements price = d.select("div.mode-cell.price");
//                System.out.println("이미지: "+img.get(0));
//                System.out.println("이름: "+name.get(0));
//                System.out.println("년도: "+year.get(0));
//                System.out.println("키로: "+km.get(0));
//                System.out.println("연료: "+fuel.get(0));
//                System.out.println("가격: "+price.get(0));
                Car car = null;
                for (int i = 0; i < name.size(); i++) {
                    car = new Car();
                    car.setCarSeq(Long.valueOf((i)));
                    car.setImg("http:"+img.get(i).select("img").attr("src"));
                    car.setName(name.get(i).text());
                    car.setYear(year.get(i).text());
                    car.setKm(km.get(i).text());
                    car.setFuel(fuel.get(i).text());
                    car.setPrice(price.get(i).text());
                    carRepository.save(car);
                }
            } catch (Exception e) {
                System.out.println("에러발생 : " + e);
            }
    }
}
