package com.exame.marilia.ml;

import com.exame.marilia.ml.dto.StatDTO;
import com.exame.marilia.ml.model.Simian;
import com.exame.marilia.ml.service.ISimianService;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.List;

@RestController
public class SimianRestController {

	private final ISimianService simianService;

	public SimianRestController(ISimianService simianService){
		this.simianService = simianService;
	}

	@PostMapping("/simian")
	public Response.Status simian(@RequestBody Simian simian) {
		boolean validSimian   = this.isSimian(simian.getDna());

		try {
			// Validação dos dados da matriz de DNA
			///this.validCharacterDNA(simian.getDna());

			simian.setSimian(validSimian);
			simianService.save(simian);

			return Response.Status.OK;

		}catch (Exception e){
			return Response.Status.FORBIDDEN;
		}
	}

	// Varrear todas as posições pra ver se tem somente (A, T, C, G)
	public void validCharacterDNA(String[] array) throws Exception{

		for (int i = 0; i < array.length; i++) {
			if ( !(array[i] == "A" ||
					array[i] == "T" ||
					array[i] == "C" ||
					array[i] == "G") ){
				throw new Exception();
			}
		}
	}

	/*
	@GetMapping("/stats")
	StatDTO countResults(){
		try{
			//return simianService.countResults();

		}catch (Exception e){
			return null;
		}
	}
*/
	private boolean isSimian (List<String> dna){
			boolean dna_s = false;

			inicio:
			for (int index_lin = 0; index_lin < dna.size(); index_lin++) {
				String linha = dna.get(index_lin);

				for (int index_col = 0; index_col < linha.length(); index_col++) {
					String componente = linha.substring(index_col, index_col+1);

					// Analise horizontal
					int count = 0;

					for (int a_c = index_col + 1; a_c < linha.length(); a_c++) {

						if (linha.substring(a_c,a_c+1) == componente) {
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

					for (int a_l = index_lin + 1; a_l < dna.size(); a_l++) {

						if (dna.get(a_l).substring(index_col,index_col+1) == componente) {
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

					for (int a_c = index_col + 1; a_c < linha.length(); a_c++) {

						// Para evitar o estoro do array
						if (a_l >= dna.size()) {
							continue;
						}

						if (dna.get(a_l).substring(a_c,a_c+1) == componente) {
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
						if (a_l >= dna.size()) {
							break;
						}

						if (dna.get(a_l).substring(a_c, a_c) == componente) {
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