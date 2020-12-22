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
import com.star.sud.app.entity.Employee;

public class CustomGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String prefix = Constants.TRXN_NUM_PREFIX;
		String sql = "SELECT " + Constants.SCHEMA_NAME + ".EMPLOYEE_ID_SEQ.NEXTVAL FROM DUAL";
		int idLength = Constants.EMP_NUM_LENGTH;
		Connection connection = session.connection();

		try (Statement statement = connection.createStatement()) {
			Employee contract = (Employee) object;

			if (contract.getEmpId() != null)
				return contract.getEmpId();

			int sequenceLength = idLength - prefix.length();

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
