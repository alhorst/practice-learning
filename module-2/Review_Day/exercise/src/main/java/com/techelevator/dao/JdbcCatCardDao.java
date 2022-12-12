package com.techelevator.dao;

import com.techelevator.model.CatCard;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCatCardDao implements CatCardDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcCatCardDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CatCard> getAllCatCards() {
        List<CatCard> catCardList = new ArrayList<>();
        String sql = "SELECT cat_card_id, img_url, cat_fact, caption FROM catcards";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            catCardList.add(mapRowToCatCard(results));
        }
        return catCardList;
    }

    @Override
    public CatCard getCatCardById(int id) {
        String sql =
                "SELECT cat_card_id, img_url, cat_fact, caption FROM catcards " +
                "WHERE cat_card_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            return mapRowToCatCard(results);
        }
        return null;
    }

    @Override
    public CatCard addCatCard(CatCard catCard) {
        String sql = "INSERT INTO catcards (img_url, cat_fact, caption) " +
                "VALUES (?, ?, ?) RETURNING cat_card_id";
        Integer returnedId = jdbcTemplate.queryForObject(sql, Integer.class, catCard.getImgUrl(),
                catCard.getCatFact(), catCard.getCaption());
        return getCatCardById(returnedId);
    }

    @Override
    public CatCard updateCatCard(CatCard updatedCatCard, int id) {
        String sql = "UPDATE catcards SET caption = ? " +
                "WHERE cat_card_id = ?";
        jdbcTemplate.update(sql, id, updatedCatCard.getImgUrl(), updatedCatCard.getCatFact(),
                updatedCatCard.getCaption());
        return updatedCatCard;
    }

    @Override
    public void deleteCatCard(int id) {
        String sql = "DELETE FROM catcards WHERE cat_card_id = ?";
        jdbcTemplate.update(sql, id);
    }

    private CatCard mapRowToCatCard(SqlRowSet results) {
        CatCard catCard = new CatCard();
        catCard.setCatCardId(results.getInt("cat_card_id"));
        catCard.setImgUrl(results.getString("img_url"));
        catCard.setCatFact(results.getString("cat_fact"));
        catCard.setCaption(results.getString("caption"));
        return catCard;
    }
}
