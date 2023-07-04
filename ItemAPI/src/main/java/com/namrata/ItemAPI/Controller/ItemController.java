package com.namrata.ItemAPI.Controller;

import com.namrata.ItemAPI.Controller.dto.Itemdto;
import com.namrata.ItemAPI.repository.entity.Item;
import com.namrata.ItemAPI.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/items" )
public class ItemController
{

    final ItemService itemService;


    public ItemController( @Autowired ItemService itemService )
    {
        this.itemService = itemService;
    }

    @GetMapping( "/all" )
    public Iterable<Item> getItems()
    {
        return itemService.all();
    }

    @CrossOrigin
    @PostMapping
    public Item save( @RequestBody Itemdto Itemdto )
    {
        return itemService.save(new Item(Itemdto));
    }

    @GetMapping( "/{id}" )
    public Item findItemById( @PathVariable Integer id )
    {
        return itemService.findById( id );
    }

    @PutMapping( "/{id}" )
    public Item update( @RequestBody Itemdto itemdto, @PathVariable Integer id )
    {
        Item item = itemService.findById( id );
        item.setName( itemdto.getName() );
        item.setDescription( itemdto.getDescription() );
        item.setImageUrl( itemdto.getImageUrl() );
        return itemService.save( item );
    }

    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Integer id )
    {
        itemService.delete( id );
    }

}

