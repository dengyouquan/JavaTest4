package com.hand;

import com.hand.api.service.FilmService;
import com.hand.domain.entity.Film;
import com.hand.infra.util.AfterInsertFilmEventPublisher;
import com.hand.infra.util.BeforeInsertFilmEventPublisher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class Application {
    private static ConfigurableApplicationContext ctx;

    static {
        ctx = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
    }

    public static void main(String[] args) {
        ctx.start();
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
        BeforeInsertFilmEventPublisher publisher =
                (BeforeInsertFilmEventPublisher) ctx.getBean("beforeInsertFilmEventPublisher");
        AfterInsertFilmEventPublisher publisher1 =
                (AfterInsertFilmEventPublisher) ctx.getBean("afterInsertFilmEventPublisher");
        publisher.publish();
        try {
            filmService.insertFilm(false, film1);
        } catch (Exception e) {
            System.out.println("transcation rollback");
        }
        publisher1.publish();
        System.out.println("second insert");
        try {
            filmService.insertFilm(true, film);
        } catch (Exception e) {
            System.out.println("transcation rollback");
        }
        System.out.println("insert success");
        ctx.stop();
    }
}

