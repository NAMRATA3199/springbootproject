package com.namrata.ItemAPI.repository.entity;

import com.namrata.ItemAPI.Controller.dto.Itemdto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Item
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id = null;

    private String name;

    private String description;

    private String imageUrl;

    public Item()
    {
    }

    public Item( Itemdto itemdto )
    {
        this.name = itemdto.getName();
        this.description = itemdto.getDescription();
        this.imageUrl = itemdto.getImageUrl();
    }

    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public void setImageUrl( String imageUrl )
    {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString()
    {
        return "Item{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + ", imageUrl='"
            + imageUrl + '\'' + '}';
    }
}