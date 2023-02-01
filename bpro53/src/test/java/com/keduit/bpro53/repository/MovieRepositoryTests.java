package com.keduit.bpro53.repository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.keduit.bpro53.entity.Movie;
import com.keduit.bpro53.entity.MovieImage;

@SpringBootTest
public class MovieRepositoryTests {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private MovieImageRepository movieImageRepository;

	@Test
	@Transactional
	@Commit
	public void insertMovies() {
		IntStream.rangeClosed(0, 100).forEach(i -> {
			Movie movie = Movie.builder().title("Movie...." + i).build();

			System.out.println("------------------");

			movieRepository.save(movie);

			int count = (int) (Math.random() * 5) + 1;

			for (int j = 0; j < count; j++) {
				MovieImage movieImage = MovieImage.builder().uuid(UUID.randomUUID().toString()).movie(movie)
						.imgName("test img" + j + ".jpg").build();

				movieImageRepository.save(movieImage);

			}
		});
	}

	@Test
	public void testListPage() {
		PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "mno"));

		Page<Object[]> result = movieRepository.getListPage(pageRequest);
		
		for(Object[] objects : result.getContent()) {
			System.out.println(Arrays.toString(objects));
		}
	}
	
	@Test
	public void testGetMovieWithAll() {
		List<Object[]> result = movieRepository.getMovieWithAllList(10L);
		
		System.out.println(result);
		
		for(Object[] arr : result) {
			System.out.println(Arrays.toString(arr));
		}
		
	}
}
