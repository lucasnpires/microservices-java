package br.com.lucasnpires.hrpayroll.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	
	private Double dailyIncome;
	
	private Integer days;
	
	public Double getTotal() {
		return days * dailyIncome;
	}
}
