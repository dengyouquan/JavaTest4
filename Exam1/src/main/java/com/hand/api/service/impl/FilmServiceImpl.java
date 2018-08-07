package com.hand.api.service.impl;

import com.hand.api.service.FilmService;
import com.hand.domain.entity.Film;
import com.hand.infra.mapper.FilmMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Program: JavaTest4
 * @Description:
 * @Author: Youquan Deng
 * @Create: 2018-08-07 14:09
 **/
public class FilmServiceImpl implements FilmService {

    private FilmMapper filmMapper;

    public FilmMapper getFilmMapper() {
        return filmMapper;
    }

    public void setFilmMapper(FilmMapper filmMapper) {
        this.filmMapper = filmMapper;
    }

    @Override
    public void insert(Film film) {
        filmMapper.insert(film);
    }

    /*
    success:是否选择成功插入
    film:要插入的Film
     */
    @Transactional(rollbackFor = Exception.class)
    public void insertFilm(boolean success, Film film) {
        long startTime = System.currentTimeMillis();
        filmMapper.insert(film);
        long endTime = System.currentTimeMillis();
        System.out.println("sql cost time:" + (endTime - startTime) + "ms");
        if (!success) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("transaction rollback");
            }
        }
    }
}
