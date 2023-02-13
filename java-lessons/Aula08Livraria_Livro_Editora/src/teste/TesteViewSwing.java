package teste;

import controller.Controller;
import model.dao.Dao;
import model.dao.mysql.DaoMySql;
import view.View;
import view.swing.ViewSwing;

public class TesteViewSwing {
	
	public static void main(String[] args) {
		View view = new ViewSwing();
		Dao dao = new DaoMySql();
		
		Controller controller = new Controller(dao, view);
	}

}
