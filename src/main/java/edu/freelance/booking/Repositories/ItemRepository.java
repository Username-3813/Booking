package edu.freelance.booking.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.freelance.booking.Models.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByActiveTrue();
}