package edu.freelance.booking.Dto;

import org.springframework.web.multipart.MultipartFile;

public class ItemDto {
    private Long id;
    private String title;
    private int price;
    private String info;
    private int duration;
    private MultipartFile cover;
    private boolean active = true;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public MultipartFile getCover() {
        return cover;
    }
    public void setCover(MultipartFile cover) {
        this.cover = cover;
    }
}
