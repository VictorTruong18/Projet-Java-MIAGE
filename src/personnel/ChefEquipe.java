package personnel;

import java.util.List;

public interface ChefEquipe {
	
	public void recruter(String nom, String prenom, Specialite specialite);
	public void renvoyer(int id);
	public int getNbOuvriers();
	public List<Integer> getIndiceOuvriers(Specialite specialite);

}
