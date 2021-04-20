package com.amstech.inc.demo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.amstech.inc.demo.DTO.UserDTO;
import com.amstech.inc.demo.utils.DButils;

public class UserDAO {
	
	private static final String INSERT_USER_INFO = "insert into Persons (id,firstName,lastName,email,password) values (?,?,?,?,?)";

	private static final String SELECT_ALL_USER = "select * from Persons";

	private static final String FIND_BY_ID = "select * from Persons where id = ? ";

	private static final String SELECT_USER_BY_EMAIL_PASSWORD = "select * from Persons where email = ? and password = ?";

	private static final String DELETE_USER_BY_ID = "delete from Persons  where id =?";

	private static final String UPDATE_USERS_BY_ID = "update Persons set firstName = ?, lastName = ?, email = ? where id =?";

	// Save Method
		public static int save(UserDTO userDTO) throws Exception {
			int count = 0;
			Connection connection = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				connection = DButils.getConnection();
				pstmt = connection.prepareStatement(INSERT_USER_INFO);

				pstmt.setInt(1, userDTO.getId());
				pstmt.setString(2, userDTO.getFirstName());
				pstmt.setString(3, userDTO.getLastName());
				pstmt.setString(4, userDTO.getEmail());
				pstmt.setString(5, userDTO.getPassword());

				count = pstmt.executeUpdate();

			} catch (Exception e) {
				System.err.println(e.getMessage());
				throw e;
			} finally {
				DButils.close(null, null, null);
			}
			return count;
		}
		
		public static UserDTO findByEmailPassword1(String email, String password) throws Exception {

			Connection connection = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			UserDTO userDTO = new UserDTO();

			try {
				connection = DButils.getConnection();
				pstmt = connection.prepareStatement(SELECT_USER_BY_EMAIL_PASSWORD);

				pstmt.setString(1, email);
				pstmt.setString(2, password);
				
				rs = pstmt.executeQuery();

				if (rs.next()) {
					userDTO.setId(rs.getInt("id"));
					userDTO.setFirstName(rs.getString("firstname"));
					userDTO.setLastName(rs.getString("lastname"));
					userDTO.setEmail(rs.getString("email"));
					userDTO.setPassword(rs.getString("password"));
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
				throw e;
			} finally {
				DButils.close(null, null, null);
			}
			return userDTO;
		}

		public static UserDTO findById(int id) throws Exception {
			Connection connection = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			UserDTO userDTO = new UserDTO();

			try {
				connection = DButils.getConnection();
				pstmt = connection.prepareStatement(FIND_BY_ID);

				pstmt.setInt(1, id);

				rs = pstmt.executeQuery();
				if (rs.next()) {
					userDTO.setId(rs.getInt("id"));
					userDTO.setFirstName(rs.getString("firstName"));
					userDTO.setLastName(rs.getString("lastName"));
					userDTO.setEmail(rs.getString("email"));
					userDTO.setPassword(rs.getString("password"));
				}

			} catch (Exception e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			} finally {
				DButils.close(null, null, null);
			}
			return userDTO;
		}
		
		
		public static  int deleteById(int id) throws Exception
		{
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;

		 try {
			connection = DButils.getConnection();
			pstmt = connection.prepareStatement(DELETE_USER_BY_ID);
			pstmt.setInt(1, id);
			count = pstmt.executeUpdate();
		 } catch (Exception e) {
			
			System.err.println(e.getMessage());
			throw e;
		}finally{
			DButils.close(null, null, null);
		}
		
		return count;
		}
		
		// Update
			public static int update(UserDTO userDTO) throws Exception {

				int count = 0;
				Connection connection = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				try {
					connection = DButils.getConnection();
					pstmt = connection.prepareStatement(UPDATE_USERS_BY_ID);

					pstmt.setString(1, userDTO.getFirstName());
					pstmt.setString(2, userDTO.getLastName());
					pstmt.setString(3, userDTO.getEmail());
					pstmt.setInt(4, userDTO.getId());

					count = pstmt.executeUpdate();

				} catch (Exception e) {
					System.err.println("error");
					throw e;
				} finally {
					DButils.close(null, null, null);
				}

				return count;

			}
				
		
		public static List<UserDTO> findAll() throws Exception {
			Connection connection = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			UserDTO userDTO = new UserDTO();
			List<UserDTO> userDTOlist = new ArrayList();

			try {
				connection = DButils.getConnection();
				pstmt = connection.prepareStatement(SELECT_ALL_USER);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					userDTO = new UserDTO();

					userDTO.setId(rs.getInt("id"));
					userDTO.setFirstName(rs.getString("firstname"));
					userDTO.setLastName(rs.getString("lastname"));
					userDTO.setEmail(rs.getString("email"));

					userDTOlist.add(userDTO);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
				throw e;
			} finally {
				DButils.close(null, null,null);
			}

			return userDTOlist;

		}

}
