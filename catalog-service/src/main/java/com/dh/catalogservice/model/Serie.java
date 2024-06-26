package com.dh.catalogservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public record Serie(String id, String name, String genre, List<Season> seasons) {
    public record Season(Integer seasonNumber, List<Chapter> chapters) {
        public record Chapter(String name, Integer number, String urlStream) {
        }
    }
}
