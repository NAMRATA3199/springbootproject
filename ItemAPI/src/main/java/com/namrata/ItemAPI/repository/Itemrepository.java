package com.namrata.ItemAPI.repository;


import com.namrata.ItemAPI.repository.entity.Item;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface Itemrepository
    extends CrudRepository<Item, Integer>
{
}