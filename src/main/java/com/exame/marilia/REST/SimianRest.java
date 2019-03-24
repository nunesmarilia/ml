package com.exame.marilia.REST;

import com.exame.marilia.model.Simian;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.core.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/simian")
public class SimianRest implements Serializable {

	private static final transient Logger LOG = LoggerFactory.getLogger(SimianRest.class);

	@RequestMapping(value="/", method=RequestMethod.POST, produces= MediaType.APPLICATION_JSON)
	void simian() {
		System.out.println("Eita");
		//System.out.println(this.isSimian(dna));

		// return Response.status( Status.OK ).build();
	}

	// Varrear todas as posições pra ver se tem somente (A, T, C, G),

	/*
	@GetMapping("/stats")
	Simian one(@PathVariable Long id) {

		return repository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException(id));
	}
	*/

	private boolean isSimian (String[][] dna){
			boolean dna_s = false;

			inicio:
			for (int index_lin = 0; index_lin < dna.length; index_lin++) {

				String[] linha = dna[index_lin];

				for (int index_col = 0; index_col < linha.length; index_col++) {

					String componente = linha[index_col];

					// Analise horizontal
					int count = 0;

					for (int a_c = index_col + 1; a_c < linha.length; a_c++) {

						if (linha[a_c] == componente) {
							count++;

						} else {
							count = 0;
							break;
						}

						if (count >= 3) {
							dna_s = true;
							System.out.println("Analise horizontal");
							break inicio;
						}
					}

					// Analise vertical

					count = 0;

					for (int a_l = index_lin + 1; a_l < dna.length; a_l++) {

						if (dna[a_l][index_col] == componente) {
							count++;

						} else {
							count = 0;
							break;
						}

						if (count >= 3) {

							dna_s = true;

							System.out.println("Analise vertical");

							break inicio;

						}

					}



					// Diagonal +L +C

					count = 0;

					int a_l = index_lin + 1;

					for (int a_c = index_col + 1; a_c < linha.length; a_c++) {

						// Para evitar o estoro do array

						if (a_l >= dna.length) {

							continue;

						}



						if (dna[a_l][a_c] == componente) {

							count++;

						} else {

							count = 0;

							break;

						}



						if (count >= 3) {

							dna_s = true;

							System.out.println("Diagonal +L +C");

							break inicio;

						}



						a_l++;

					}



					// Diagonal +L -C

					count = 0;

					a_l = index_lin + 1;

					for (int a_c = index_col - 1; a_c >= 0; a_c--) {

						// Para evitar o estoro do array

						if (a_l >= dna.length) {

							break;

						}



						if (dna[a_l][a_c] == componente) {

							count += 1;

						} else {

							count = 0;

							break;

						}



						if (count >= 3) {

							dna_s = true;

							System.out.println("Diagonal +L -C");

							break inicio;

						}

						a_l++;

					}



				}

			}

			return dna_s;
		}
}