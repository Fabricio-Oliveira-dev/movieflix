package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthService authService;

    @Transactional
    public ReviewDTO insert(ReviewDTO dto) {
        Review review = new Review();
        review.setText(dto.getText());
        Movie movieId = movieRepository.getReferenceById(dto.getMovieId());

        User user = authService.authenticated();
        review.setMovie(movieId);

        review.setUser(user);

        review = reviewRepository.save(review);
        return new ReviewDTO(review);
    }
}
