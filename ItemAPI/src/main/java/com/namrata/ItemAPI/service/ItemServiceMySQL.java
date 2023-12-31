package com.namrata.ItemAPI.service;
import com.namrata.ItemAPI.repository.Itemrepository;
import com.namrata.ItemAPI.repository.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceMySQL
    implements ItemService
{
    private final Itemrepository itemRepository;

    public ItemServiceMySQL( @Autowired Itemrepository itemRepository )
    {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item save( Item item )
    {
        return itemRepository.save( item );
    }

    @Override
    public void delete( int itemId )
    {
        itemRepository.deleteById( itemId );
    }

    @Override
    public List<Item> all()
    {
        List<Item> result = new ArrayList<>();
        itemRepository.findAll().forEach( result::add );
        return result;
    }

    @Override
    public Item findById( int itemId )
    {
        return itemRepository.findById( itemId ).get();
    }
}
