package entidades;

public class Editora {
	
	int id;
	String nome;
	String url;
	
	public Editora(int id, String nome, String url) {
		super();
		this.id = id;
		this.nome = nome;
		this.url = url;
	}
	
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getUrl() {
		return url;
	}
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Editora other = (Editora) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Editora [id=" + id + ", nome=" + nome + ", url=" + url + "]";
	}
	
	

}
