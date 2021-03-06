package com.exame.marilia.ml;

import com.exame.marilia.ml.dto.StatDTO;
import com.exame.marilia.ml.model.Simian;
import com.exame.marilia.ml.service.ISimianService;
import com.exame.marilia.ml.service.IStatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Valida��o de DNA", description = "Descubra se o DNA � s�mio ou humano ")
public class SimianRestController {

	private final ISimianService simianService;
	private final IStatService statService;

	public SimianRestController(ISimianService simianService, IStatService statService){
		this.simianService  = simianService;
		this.statService    = statService;
	}

	@ApiOperation(value = "Analise de DNA simio")
	@PostMapping("/simian")
	public ResponseEntity<String> simian(@RequestBody Simian simian) {
		boolean validSimian;

		try {
			// Valida��o dos dados da matriz de DNA
			this.validCharacterDNA(simian.getDna());

			validSimian   = this.isSimian(simian.getDna());

			StringBuilder strId    = new StringBuilder();

			for(String objLinha: simian.getDna()){
				strId.append("-").append(objLinha);
			}

			if( strId.length() > 0 )
				simian.setKeyDna(strId.toString().substring(1));

			simian.setSimian(validSimian);
			simianService.save(simian);

		}catch (Exception e){
			return new ResponseEntity<>("HTTP 403-FORBIDDEN", HttpStatus.FORBIDDEN);
		}

		if( validSimian )
			return new ResponseEntity<>("HTTP 200-OK", HttpStatus.OK);
		else
			return new ResponseEntity<>("HTTP 403-FORBIDDEN", HttpStatus.FORBIDDEN);
	}

	// Varrear todas as posi��es pra ver se tem somente (A, T, C, G)
	public void validCharacterDNA(List<String> listDna) throws Exception{
		for(String objLinha: listDna){

			for (int index_col = 0; index_col < objLinha.length(); index_col++) {
				String componente = objLinha.substring(index_col, index_col + 1);

				switch (componente){
					case "A" :
						break;

					case "T" :
						break;

					case "C" :
						break;

					case "G" :
						break;

					default:
						throw new Exception();
				}
			}
		}
	}

	@ApiOperation(value = "DNAs analisados")
	@GetMapping("/stats")
	public StatDTO countResults(){
		try{
			return statService.countResults();

		}catch (Exception e){
			return null;
		}
	}

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

						if(linha.substring(a_c,a_c+1).equals(componente)) {
							count++;

						} else {
							break;
						}

						if (count >= 3) {
							dna_s = true;
							break inicio;
						}
					}

					// Analise vertical
					count = 0;

					for (int a_l = index_lin + 1; a_l < dna.size(); a_l++) {

						if (dna.get(a_l).substring(index_col,index_col+1).equals(componente)) {
							count++;

						} else {
							break;
						}

						if (count >= 3) {
							dna_s = true;
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

						if (dna.get(a_l).substring(a_c,a_c+1).equals(componente)) {
							count++;
						} else {
							break;
						}

						if (count >= 3) {
							dna_s = true;
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

						if (dna.get(a_l).substring(a_c, a_c).equals(componente)) {
							count += 1;

						} else {
							break;
						}

						if (count >= 3) {
							dna_s = true;
							break inicio;
						}

						a_l++;
					}
				}
			}

			return dna_s;
		}
}