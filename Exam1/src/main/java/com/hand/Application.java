package com.hand;

import com.hand.api.service.FilmService;
import com.hand.domain.entity.Film;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class Application {
    private static ApplicationContext ctx;

    static {
        ctx = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
    }

    public static void main(String[] args) {
        System.out.println("Context Start");
        FilmService filmService = (FilmService) ctx.getBean("filmService");
        String title = System.getenv("FILM_TITLE");
        String description = System.getenv("FILM_DESCRIPTION");
        String lanStr = System.getenv("FILM_LAN");
        if (title.equals("") || description.equals("") || lanStr.equals("")) {
            System.out.println("System.getenv fail");
            return;
        }
        byte lan;
        try {
            lan = Byte.parseByte(lanStr);
        } catch (Exception e) {
            System.out.println("language id illegal");
            return;
        }
        Film film = new Film(title, description, (short) 2018, lan, (byte) 6, 0.99, (short) 88,
                20.99, "PG", null, new Date());
        Film film1 = new Film(title, description, (short) 2017, lan, (byte) 6, 0.99, (short) 88,
                20.99, "PG", null, new Date());
        System.out.println("Film Title:\n" + film.getTitle());
        System.out.println("Film Description:\n" + film.getDescription());
        System.out.println("Film LanguageId:\n" + film.getLanguageId());
        System.out.println("first insert");
        filmService.insertFilm(false, film1);
        System.out.println("second insert");
        filmService.insertFilm(true, film);
        System.out.println("insert success");
        System.out.println("Context Stop");
    }
}

