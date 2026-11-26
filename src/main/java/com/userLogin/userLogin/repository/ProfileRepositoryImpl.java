package com.userLogin.userLogin.repository;

import com.userLogin.userLogin.model.Profile;
import com.userLogin.userLogin.repository.mapper.ProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileRepositoryImpl implements ProfileRepository{
    private static final String PROFILE_TABLE_NAME = "profile";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Profile getProfileByUserId(Long userId) {
        String sql = "SELECT * FROM " + PROFILE_TABLE_NAME + " WHERE user_id=?";

        try {
            return jdbcTemplate.queryForObject(
                    sql,
                    new ProfileMapper(),
                    userId
            );
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public void createProfile(Profile profile) {
        String sql = "INSERT INTO " + PROFILE_TABLE_NAME +
                " (user_id, first_name, last_name, email, phone, address) VALUES (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(
                sql,
                profile.getUserId(),
                profile.getFirstName(),
                profile.getLastName(),
                profile.getEmail(),
                profile.getPhone(),
                profile.getAddress()
        );
    }



    @Override
    public void updateProfile(Profile profile) {
        String sql = "UPDATE " + PROFILE_TABLE_NAME +
                " SET first_name=?, last_name=?, email=?, phone=?, address=?" +
                " WHERE user_id=?";

        jdbcTemplate.update(
                sql,
                profile.getFirstName(),
                profile.getLastName(),
                profile.getEmail(),
                profile.getPhone(),
                profile.getAddress(),
                profile.getUserId()
        );
    }

    @Override
    public void deleteProfileByUserId(Long userId) {
        String sql = "DELETE FROM " + PROFILE_TABLE_NAME + " WHERE user_id=?";

        jdbcTemplate.update(sql,userId);
    }
}
