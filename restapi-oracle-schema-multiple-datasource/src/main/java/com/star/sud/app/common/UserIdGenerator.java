package com.star.sud.app.common;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.star.sud.app.constant.Constants;
import com.star.sud.app.shoppingcart.entity.User;

public class UserIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String prefix = Constants.TRXN_USER_NUM_PREFIX;
		String sql = "SELECT " + Constants.SCHEMA_ONLINE_APP + ".USER_ID_SEQ.NEXTVAL FROM DUAL";
		Connection connection = session.connection();

		try (Statement statement = connection.createStatement()) {
			User contract = (User) object;

			if (contract.getUserId() != null)
				return contract.getUserId();

			int sequenceLength = Constants.USER_NUM_LENGTH - prefix.length();

			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				long id = rs.getLong(1);
				String contractNo = prefix + StringUtils.leftPad(String.valueOf(id + 1), sequenceLength, "0");
				return contractNo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}