package com.softekh.capp.rm;

import com.softekh.capp.domain.Contact;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author ISAAC BLACK
 */
public class ContactRowMapper implements RowMapper<Contact> {

    @Override
    public Contact mapRow(ResultSet rs, int i) throws SQLException {
    Contact c=new Contact();
    c.setContactId(rs.getInt("ContactId"));
    c.setUserId(rs.getInt("contactId"));
    c.setName(rs.getString("name"));
    c.setPhone(rs.getString("phone"));
    c.setEmail(rs.getString("email"));
    c.setAddress(rs.getString("address"));
    c.setRemark(rs.getString("remark"));
    return c;
    }
    
}
