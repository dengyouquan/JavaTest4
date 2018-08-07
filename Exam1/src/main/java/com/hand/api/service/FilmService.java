package com.hand.api.service;


import com.hand.domain.entity.Film;

/**
 * @Program: JavaTest4
 * @Description:
 * @Author: Youquan Deng
 * @Create: 2018-08-07 14:09
 **/
public interface FilmService {
    void insert(Film film);

    void insertFilm(boolean success, Film film);
}
