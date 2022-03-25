package com.videoclub;

import com.videoclub.dao.DaoFactory;
import com.videoclub.dao.base.ActorDao;
import com.videoclub.dao.base.MovieDao;
import com.videoclub.dao.entity.Actor;
import com.videoclub.dao.entity.Movie;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.time.LocalDate;

@WebListener
public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        MovieDao moviedao = DaoFactory.getMovieDao();
        moviedao.save(new Movie("La ligne verte", 188, LocalDate.ofYearDay(1999, 1)));
        moviedao.save(new Movie("Le parrain", 175, LocalDate.ofYearDay(1972, 1)));
        moviedao.save(new Movie("H2G2 ", 109, LocalDate.ofYearDay(2005, 1)));
        moviedao.save(new Movie("Que justice soit faite", 104, LocalDate.ofYearDay(2009, 1)));
        moviedao.save(new Movie("Les affranchis", 146, LocalDate.ofYearDay(1990, 1)));
        moviedao.save(new Movie("Metropolis", 153, LocalDate.ofYearDay(1927, 1)));
        moviedao.save(new Movie("Blade Runner 2049", 163, LocalDate.ofYearDay(2017, 1)));
        moviedao.save(new Movie("Princesse Mononoké", 133, LocalDate.ofYearDay(1997, 1)));
        moviedao.save(new Movie("Transformers", 224, LocalDate.ofYearDay(2007, 1)));



        ActorDao actordao = DaoFactory.getActorDao();
        actordao.save(new Actor("Michael Clarke", "Duncan"));
        actordao.save(new Actor("Tom", "Hanks"));

        actordao.save(new Actor("Alfredo James", "Pacino"));
        actordao.save(new Actor("Marlon", "Brando"));

        actordao.save(new Actor("Alan", "Rickman"));
        actordao.save(new Actor("Martin", "Freeman"));

        actordao.save(new Actor("Gerard", "Butler"));
        actordao.save(new Actor("Jamie", "Foxx"));

        actordao.save(new Actor("Robert", "De Niro"));
        actordao.save(new Actor("Ray", "Liotta"));

        actordao.save(new Actor("Brigitte", "Helm"));
        actordao.save(new Actor("Gustav", "Fröhlich"));

        actordao.save(new Actor("Ryan", "Gosling"));
        actordao.save(new Actor("Robin", "Wright"));

        actordao.save(new Actor("Megan", "Fox"));
        actordao.save(new Actor("Rachael", "Taylor"));

    }
}
