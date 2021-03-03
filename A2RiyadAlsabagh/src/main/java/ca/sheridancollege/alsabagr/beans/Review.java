package ca.sheridancollege.alsabagr.beans;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {

	private Long id;
	private String resName, resReview;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate showDay;
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime showTime;
	
}
