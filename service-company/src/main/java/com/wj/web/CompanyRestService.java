package com.wj.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Pour montrer la config qu'il a crée; on crée un web service rest
 */

/*
 * Une fois qu'on change les valeurs des paramètres ci-dessous; 
 * Si on veut qu'ils se rafraichissent; On utilise l'annotation
 * @RefreshScope.
 * Tous les paramètres qu'on injecte via value; dès que le microservive
 * recharge sa configuration, Il va les ractualiser.
 */
@RefreshScope 
@RestController
public class CompanyRestService {
	
	/*
	 * On récupère les valeurs des paramètres.
	 * Pour les récuperer à partir de la config; on utilise la notation value, 
	 * en spécifiant le nom de la société.
	 * La variable specifié à l'interieur de l'accolade est le même que celle
	 * defini dans la configuration
	 */
	@Value("${xParam}")
	private int xParam;
	@Value("${yParam}")
	private int yParam;
	@Value("${wj}")
	private String wj;
	
	/*
	 * Methode de type Map qui va contenir les valeurs definis ci-dessus
	 */
	@GetMapping("/myConfig")
	public Map<String, Object> myConfig(){
		Map<String, Object> params = new HashMap<>();
		params.put("xParam", xParam);
		params.put("yParam", yParam);
		params.put("wj", wj);
		
		/*
		 * on ajoute le nom du thread qui a donnée la repone.
		 * Dans le modèle multithread, Pour chaque requête utilisé par
		 * l'utilisateur; on va mobiliser un thread pour donner la reponse;
		 * pour traiter la requête
		 */
		params.put("thredName", Thread.currentThread().getName()); 
		
		return params;
	}
	
}
