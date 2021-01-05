package com.kakarot;

import java.sql.ResultSet;
import java.sql.Statement;

import com.kakarot.dbconnections.ConnectionManager;

public class CredidentialsCheck {

	public boolean check(String username, String password) {

		if (username != null && password != null)
			try {
				String sql = "SELECT password FROM users WHERE username = '" + username + "';";
				Statement con = ConnectionManager.getConnectionManager().getStatement();
				ResultSet rs = con.executeQuery(sql);
				if (rs.next())
					if (password.equals(rs.getString(1))) {
						return true;
					}
			} catch (Exception e) {
				return false;
			}

		return false;
	}

}
